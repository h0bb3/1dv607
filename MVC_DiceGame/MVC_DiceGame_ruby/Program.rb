#!/usr/bin/env ruby

require './model/DiceGame.rb'
require './view/Console.rb'
require './controller/Player.rb'

game        = Model::DiceGame.new
view        = View::Console.new
controller  = Controller::Player.new

controller.playGame(game, view)
