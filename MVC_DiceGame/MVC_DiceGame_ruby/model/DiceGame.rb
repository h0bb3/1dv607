require './model/Dice.rb'

module Model
  class DiceGame

    def initialize
      @d1 = Model::Dice.new
      @d2 = Model::Dice.new
    end

    def dice_one_value
      @d1.face_value
    end

    def dice_two_value
      @d2.face_value
    end

    def play
      @d1.roll
      @d2.roll
      @d1.face_value + @d2.face_value == 7
    end

  end
end
