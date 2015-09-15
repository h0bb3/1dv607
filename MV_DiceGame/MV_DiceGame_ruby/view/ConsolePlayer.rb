require 'io/console'

module View
  class ConsolePlayer

    def play a_game
      message = 'Welcome to the cool Dice Game. Press any Key to play, or q to Quit'
      puts message

      until gets == "q\n"  do
        system "clear"
        puts message
        if a_game.play
          puts "You are a winner: #{a_game.dice_one_value} #{a_game.dice_two_value}"
        else
          puts "Sorry you lost: #{a_game.dice_one_value} #{a_game.dice_two_value}"
        end
      end

    end

  end
end
