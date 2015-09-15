#!/usr/bin/env ruby

require './DiceGame.rb'

if __FILE__ == $0
  g = DiceGame.new

  if g.play
    puts 'You are a winner!'
  else
    puts 'Sorry'
  end
end
