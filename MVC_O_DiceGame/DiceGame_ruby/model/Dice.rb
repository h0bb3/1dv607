module Model
  class Dice

    attr_reader :face_value

    def initialize
      @face_value = 0
    end

    def roll
      @face_value = rand(6) + 1
    end

  end
end
