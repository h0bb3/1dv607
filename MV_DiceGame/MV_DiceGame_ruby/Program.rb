#!/usr/bin/env ruby

require './model/DiceGame.rb'
require './view/ConsolePlayer.rb'

game    = Model::DiceGame.new
player  = View::ConsolePlayer.new

player.play game
