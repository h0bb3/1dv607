import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

// https://developer.mozilla.org/en-US/docs/Web/API/WebSockets_API/Writing_WebSocket_servers
public class Frame {

    public enum OPCode {
        CONTINUATION(0x00),
        TEXT_FRAME(0x01),
        BINARY_FRAME(0x02),
        CONNECTION_CLOSE(0x08),
        PING(0x09),
        PONG(0xA0),
        ILLEGAL(0xFF);


        public final int m_value;
        private OPCode(int a_value) {
            m_value = a_value;
        }
    }

    public enum ByteMask {
        FIN((byte)0b10000000),
        RSV1((byte)0b010000000),
        RSV2((byte)0b001000000),
        RSV3((byte)0b000100000),
        OPCODE((byte)0b00001111),
        MASK((byte)0b10000000),
        LEN_0((byte)0b01111111);


        ByteMask(byte a_mask) {
            m_mask = a_mask;
            assert(m_mask != 0);
            byte mask = 1;
            m_swissle = 0;
            while ((m_mask & mask) == 0) {
                mask <<= 1;
                m_swissle++;
            }

        }
        private byte m_mask;
        private byte m_swissle;

        public byte getMaskedValue(byte a_b) {
            return (byte)((a_b & m_mask) >> m_swissle);
        }

        public byte set(byte a_b) {
            return (byte)(a_b | m_mask);
        }

        public byte unset(byte a_b) {
            return (byte)(a_b & (~m_mask));
        }

        public byte set(byte a_b, int a_value) {
            int bits = (a_value & (m_mask >> m_swissle)) << m_swissle;
            return (byte)(a_b | bits);
        }
    }

    private OPCode m_frameType;
    private byte m_data[] = null;   // TODO: make this into an array list of byte arrays as the data may be very large

    Frame(String a_message) throws IOException {
        m_frameType = OPCode.TEXT_FRAME;
        m_data = a_message.getBytes(StandardCharsets.UTF_8);
    }

    Frame(String a_message1, String a_message2) {
        m_frameType = OPCode.TEXT_FRAME;

        byte m1[] = a_message1.getBytes(StandardCharsets.UTF_8);
        byte m2[] = a_message2.getBytes(StandardCharsets.UTF_8);
        m_data = new byte[m1.length + m2.length];
        System.arraycopy(m1, 0, m_data, 0, m1.length);
        System.arraycopy(m2, 0, m_data, m1.length, m2.length);

    }

    byte[] getData() {
        return m_data;
    }

    private int getSizeO(byte a_sizeByte) {
       return toUnsigned(ByteMask.LEN_0.getMaskedValue(a_sizeByte));
    }

    private OPCode getOpCode(int a_code) {
        for(OPCode o : OPCode.values()) {
            if (o.m_value == a_code) {
                return o;
            }
        }

        return OPCode.ILLEGAL;
    }

    // This one will block until the correct amount of data is received.
    Frame(DataInputStream a_in) throws IOException {
        if (a_in != null) {
            byte first = a_in.readByte();   // FIN, RSV1, RSV2 RSV3, OPCODE (4)
            byte second = a_in.readByte(); // mask, len (7)
            m_frameType = getOpCode(ByteMask.OPCODE.getMaskedValue(first));

            // TODO: Handle divided packages

            if (m_frameType == OPCode.ILLEGAL) {
                throw new IOException("Illegal OPCode Received: " + ByteMask.OPCODE.getMaskedValue(first));
            }


            long size = getSizeO(second);
            if (size == 126) {
                size = a_in.readUnsignedShort();
            } else if (size == 127) {
                size = a_in.readLong();
            }
            m_frameType = OPCode.TEXT_FRAME; // TODO: This is hard coded for now
            System.out.println("fin:" +  ByteMask.FIN.getMaskedValue(first));
            System.out.println("payload len 0:" + size);

            if (size > Integer.MAX_VALUE) {
                throw new IOException("Illegal Size Received (currently MAX is MAX integer: " + size);
            }

            byte key[] = new byte[4];
            byte data[] = new byte[(int)size];  // TODO: we need to support reading into multiple arrays for very long datas (and also for FIN = 0)

            a_in.read(key);
            a_in.read(data);

            m_data = decode(key, data);
        }
    }

    public void send(DataOutputStream a_out) throws IOException {
        byte [] header  = new byte[] {(byte)0, (byte)0};

        header[0] = ByteMask.FIN.set(header[0]);
        header[0] = ByteMask.OPCODE.set(header[0], m_frameType.m_value);
        header[1] = ByteMask.MASK.unset(header[1]);

        int extraSize = 0;
        if (m_data.length < 126) {
            header[1] = ByteMask.LEN_0.set(header[1], m_data.length);
            assert(m_data.length == getSizeO(header[1]));
        } else if (m_data.length <= 0xffff){
            header[1] = ByteMask.LEN_0.set(header[1], 126);
            extraSize = 1;
        } else {
            header[1] = ByteMask.LEN_0.set(header[1], 127);
            extraSize = 2;
        }

        a_out.write(header);
        if (extraSize == 1) {
            a_out.writeShort(m_data.length);
        } else if (extraSize == 2) {
            a_out.writeLong(m_data.length);
        }
        a_out.write(m_data);
    }

    private byte[] decode(byte[] a_key, byte[] a_data) {
        assert(a_key.length == 4);
        byte[] decoded = new byte[a_data.length];

        for (int i = 0; i < a_data.length; i++) {
            decoded[i] = (byte) (a_data[i] ^ a_key[i & 0x3]);
        }

        return decoded;
    }

    private int toUnsigned(byte a_b) {
        return a_b & 0xff;
    }
}
