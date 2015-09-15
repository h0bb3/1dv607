#!/usr/bin/env ruby

require './model/DiceGame.rb'
require './view/ConsolePlayer.rb'

if __FILE__ == $0

  game = Model::DiceGame.new
  player = View::ConsolePlayer.new

  player.play game

end
