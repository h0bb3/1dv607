module Model
  class Dice

    # Readable attribute
    attr_reader :face_value

    # Constructor
    def initialize
      @face_value = 0
    end

    # Roll the Die
    def roll
      @face_value = rand(6) + 1
    end

  end
end
