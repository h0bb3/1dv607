#!/usr/bin/env ruby
require './Dice.rb'

class DiceGame
  #constructor
  def initialize
    @d1 = Dice.new
    @d2 = Dice.new
  end

  #Play the game
  def play
    @d1.roll
    @d2.roll
    @d1.face_value + @d2.face_value == 7 
  end
end
