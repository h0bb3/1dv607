package view.console;

import java.awt.*;
import java.util.HashMap;

import static java.awt.event.KeyEvent.*;

public class Secretary extends Robot {
    private static HashMap<String, String> g_charToAltCode = null;

    public Secretary() throws AWTException {
        super();
        populateAltCodeMap();
    }

    private void populateAltCodeMap() {
        if (g_charToAltCode == null) {
            g_charToAltCode = new HashMap<>();
            g_charToAltCode.put("\t", "9");
            g_charToAltCode.put("¤", "15");
            g_charToAltCode.put("¶", "20");
            g_charToAltCode.put("§", "21");
            g_charToAltCode.put(" ", "32");
            g_charToAltCode.put("!", "33");
            g_charToAltCode.put("\"", "34");
            g_charToAltCode.put("#", "35");
            g_charToAltCode.put("$", "36");
            g_charToAltCode.put("%", "37");
            g_charToAltCode.put("&", "38");
            g_charToAltCode.put("'", "39");
            g_charToAltCode.put("(", "40");
            g_charToAltCode.put(")", "41");
            g_charToAltCode.put("*", "42");
            g_charToAltCode.put("+", "43");
            g_charToAltCode.put(",", "44");
            g_charToAltCode.put("-", "45");
            g_charToAltCode.put(".", "46");
            g_charToAltCode.put("/", "47");
            g_charToAltCode.put("0", "48");
            g_charToAltCode.put("1", "49");
            g_charToAltCode.put("2", "50");
            g_charToAltCode.put("3", "51");
            g_charToAltCode.put("4", "52");
            g_charToAltCode.put("5", "53");
            g_charToAltCode.put("6", "54");
            g_charToAltCode.put("7", "55");
            g_charToAltCode.put("8", "56");
            g_charToAltCode.put("9", "57");
            g_charToAltCode.put(":", "58");
            g_charToAltCode.put(";", "59");
            g_charToAltCode.put("<", "60");
            g_charToAltCode.put("=", "61");
            g_charToAltCode.put(">", "62");
            g_charToAltCode.put("?", "63");
            g_charToAltCode.put("@", "64");
            g_charToAltCode.put("A", "65");
            g_charToAltCode.put("B", "66");
            g_charToAltCode.put("C", "67");
            g_charToAltCode.put("D", "68");
            g_charToAltCode.put("E", "69");
            g_charToAltCode.put("F", "70");
            g_charToAltCode.put("G", "71");
            g_charToAltCode.put("H", "72");
            g_charToAltCode.put("I", "73");
            g_charToAltCode.put("J", "74");
            g_charToAltCode.put("K", "75");
            g_charToAltCode.put("L", "76");
            g_charToAltCode.put("M", "77");
            g_charToAltCode.put("N", "78");
            g_charToAltCode.put("O", "79");
            g_charToAltCode.put("P", "80");
            g_charToAltCode.put("Q", "81");
            g_charToAltCode.put("R", "82");
            g_charToAltCode.put("S", "83");
            g_charToAltCode.put("T", "84");
            g_charToAltCode.put("U", "85");
            g_charToAltCode.put("V", "86");
            g_charToAltCode.put("W", "87");
            g_charToAltCode.put("X", "88");
            g_charToAltCode.put("Y", "89");
            g_charToAltCode.put("Z", "90");
            g_charToAltCode.put("[", "91");
            g_charToAltCode.put("\\", "92");
            g_charToAltCode.put("]", "93");
            g_charToAltCode.put("^", "94");
            g_charToAltCode.put("_", "95");
            g_charToAltCode.put("`", "96");
            g_charToAltCode.put("a", "97");
            g_charToAltCode.put("b", "98");
            g_charToAltCode.put("c", "99");
            g_charToAltCode.put("d", "100");
            g_charToAltCode.put("e", "101");
            g_charToAltCode.put("f", "102");
            g_charToAltCode.put("g", "103");
            g_charToAltCode.put("h", "104");
            g_charToAltCode.put("i", "105");
            g_charToAltCode.put("j", "106");
            g_charToAltCode.put("k", "107");
            g_charToAltCode.put("l", "108");
            g_charToAltCode.put("m", "109");
            g_charToAltCode.put("n", "110");
            g_charToAltCode.put("o", "111");
            g_charToAltCode.put("p", "112");
            g_charToAltCode.put("q", "113");
            g_charToAltCode.put("r", "114");
            g_charToAltCode.put("s", "115");
            g_charToAltCode.put("t", "116");
            g_charToAltCode.put("u", "117");
            g_charToAltCode.put("v", "118");
            g_charToAltCode.put("w", "119");
            g_charToAltCode.put("x", "120");
            g_charToAltCode.put("y", "121");
            g_charToAltCode.put("z", "122");
            g_charToAltCode.put("{", "123");
            g_charToAltCode.put("|", "124");
            g_charToAltCode.put("}", "125");
            g_charToAltCode.put("~", "126");
            g_charToAltCode.put("", "127");
            g_charToAltCode.put("Ç", "128");
            g_charToAltCode.put("ü", "129");
            g_charToAltCode.put("é", "130");
            g_charToAltCode.put("â", "131");
            g_charToAltCode.put("ä", "132");
            g_charToAltCode.put("à", "133");
            g_charToAltCode.put("å", "134");
            g_charToAltCode.put("ç", "135");
            g_charToAltCode.put("ê", "136");
            g_charToAltCode.put("ë", "137");
            g_charToAltCode.put("è", "138");
            g_charToAltCode.put("ï", "139");
            g_charToAltCode.put("î", "140");
            g_charToAltCode.put("ì", "141");
            g_charToAltCode.put("æ", "145");
            g_charToAltCode.put("Æ", "146");
            g_charToAltCode.put("ô", "147");
            g_charToAltCode.put("ö", "148");
            g_charToAltCode.put("ò", "149");
            g_charToAltCode.put("û", "150");
            g_charToAltCode.put("ù", "151");
            g_charToAltCode.put("ÿ", "152");
            g_charToAltCode.put("¢", "155");
            g_charToAltCode.put("£", "156");
            g_charToAltCode.put("¥", "157");
            g_charToAltCode.put("×", "158");
            g_charToAltCode.put("ƒ", "159");
            g_charToAltCode.put("á", "160");
            g_charToAltCode.put("í", "161");
            g_charToAltCode.put("ó", "162");
            g_charToAltCode.put("ú", "163");
            g_charToAltCode.put("ñ", "164");
            g_charToAltCode.put("Ñ", "165");
            g_charToAltCode.put("ª", "166");
            g_charToAltCode.put("º", "167");
            g_charToAltCode.put("¿", "168");
            g_charToAltCode.put("¬", "170");
            g_charToAltCode.put("½", "171");
            g_charToAltCode.put("¼", "172");
            g_charToAltCode.put("¡", "173");
            g_charToAltCode.put("«", "174");
            g_charToAltCode.put("»", "175");
            g_charToAltCode.put("¦", "179");
            g_charToAltCode.put("ß", "225");
            g_charToAltCode.put("µ", "230");
            g_charToAltCode.put("±", "241");
            g_charToAltCode.put("°", "248");
            g_charToAltCode.put("•", "249");
            g_charToAltCode.put("·", "250");
            g_charToAltCode.put("²", "253");
            g_charToAltCode.put("€", "0128");
            g_charToAltCode.put("„", "0132");
            g_charToAltCode.put("…", "0133");
            g_charToAltCode.put("†", "0134");
            g_charToAltCode.put("‡", "0135");
            g_charToAltCode.put("ˆ", "0136");
            g_charToAltCode.put("‰", "0137");
            g_charToAltCode.put("Š", "0138");
            g_charToAltCode.put("‹", "0139");
            g_charToAltCode.put("Œ", "0140");
            g_charToAltCode.put("‘", "0145");
            g_charToAltCode.put("’", "0146");
            g_charToAltCode.put("“", "0147");
            g_charToAltCode.put("”", "0148");
            g_charToAltCode.put("–", "0150");
            g_charToAltCode.put("—", "0151");
            g_charToAltCode.put("˜", "0152");
            g_charToAltCode.put("™", "0153");
            g_charToAltCode.put("š", "0154");
            g_charToAltCode.put("›", "0155");
            g_charToAltCode.put("œ", "0156");
            g_charToAltCode.put("Ÿ", "0159");
            g_charToAltCode.put("¨", "0168");
            g_charToAltCode.put("©", "0169");
            g_charToAltCode.put("®", "0174");
            g_charToAltCode.put("¯", "0175");
            g_charToAltCode.put("³", "0179");
            g_charToAltCode.put("´", "0180");
            g_charToAltCode.put("¸", "0184");
            g_charToAltCode.put("¹", "0185");
            g_charToAltCode.put("¾", "0190");
            g_charToAltCode.put("À", "0192");
            g_charToAltCode.put("Á", "0193");
            g_charToAltCode.put("Â", "0194");
            g_charToAltCode.put("Ã", "0195");
            g_charToAltCode.put("Ä", "0196");
            g_charToAltCode.put("Å", "0197");
            g_charToAltCode.put("È", "0200");
            g_charToAltCode.put("É", "0201");
            g_charToAltCode.put("Ê", "0202");
            g_charToAltCode.put("Ë", "0203");
            g_charToAltCode.put("Ì", "0204");
            g_charToAltCode.put("Í", "0205");
            g_charToAltCode.put("Î", "0206");
            g_charToAltCode.put("Ï", "0207");
            g_charToAltCode.put("Ð", "0208");
            g_charToAltCode.put("Ò", "0210");
            g_charToAltCode.put("Ó", "0211");
            g_charToAltCode.put("Ô", "0212");
            g_charToAltCode.put("Õ", "0213");
            g_charToAltCode.put("Ö", "0214");
            //m_charToAltCode.put("×", "0215");
            g_charToAltCode.put("Ø", "0216");
            g_charToAltCode.put("Ù", "0217");
            g_charToAltCode.put("Ú", "0218");
            g_charToAltCode.put("Û", "0219");
            g_charToAltCode.put("Ü", "0220");
            g_charToAltCode.put("Ý", "0221");
            g_charToAltCode.put("Þ", "0222");
            g_charToAltCode.put("ã", "0227");
            g_charToAltCode.put("ð", "0240");
            g_charToAltCode.put("õ", "0245");
            g_charToAltCode.put("÷", "0247");
            g_charToAltCode.put("ø", "0248");
            //m_charToAltCode.put("ü", "0252");
            g_charToAltCode.put("ý", "0253");
            g_charToAltCode.put("þ", "0254");
        }
    }

    public void type(String a_str) {

        for(int i=0; i < a_str.length(); i++){

            //region Description
            keyPress(VK_ALT);
            String altCode;
            String charStr = a_str.substring(i, i + 1);
            altCode = g_charToAltCode.get(charStr);
            if (altCode != null) {

                //endregion
                for (int j = 0; j < altCode.length(); j++) {
                    typeNumPad(Integer.parseInt(altCode.substring(j, j + 1)));
                }
                keyRelease(VK_ALT);
            }
        }

    }

    private void typeNumPad(int digit) {
        switch (digit) {
            case 0: doType(VK_NUMPAD0); break;
            case 1: doType(VK_NUMPAD1); break;
            case 2: doType(VK_NUMPAD2); break;
            case 3: doType(VK_NUMPAD3); break;
            case 4: doType(VK_NUMPAD4); break;
            case 5: doType(VK_NUMPAD5); break;
            case 6: doType(VK_NUMPAD6); break;
            case 7: doType(VK_NUMPAD7); break;
            case 8: doType(VK_NUMPAD8); break;
            case 9: doType(VK_NUMPAD9); break;
        }
    }

    private void doType(int a_vk) {
        keyPress(a_vk);
        keyRelease(a_vk);
    }
}
