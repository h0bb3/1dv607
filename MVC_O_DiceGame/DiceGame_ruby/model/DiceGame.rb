require './model/Dice.rb'

module Model
  class DiceGame

    def initialize
      @d1 = Model::Dice.new
      @d2 = Model::Dice.new
      @d3 = Model::Dice.new
      @observers = []
    end

    def add_subscriber subscriber
      @observers << subscriber
    end

    def roll dice
      dice.roll
      @observers.each do |o|
        o.rolled_dice dice.face_value
      end
    end

    def play
      roll @d1
      sleep 2
      roll @d2
      sleep 2
      roll @d3

      @d1.face_value + @d2.face_value + @d3.face_value == 9
    end

  end
end
