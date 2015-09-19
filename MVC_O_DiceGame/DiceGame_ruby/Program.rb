#!/usr/bin/env ruby

require './model/DiceGame.rb'
require './model/DiceGameObserver.rb'
require './view/Console.rb'
require './view/SweConsole.rb'
require './view/EngConsole.rb'
require './controller/Player.rb'

game        = Model::DiceGame.new
view        = View::SweConsole.new
controller  = Controller::Player.new view

controller.play game
