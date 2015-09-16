module View
  class Console

    QUIT_ON_INPUT  = "q"

    def display_instructions
      system "clear"
      puts "Welcome to the cool Dice Game. Press any Key to play, or #{QUIT_ON_INPUT} to Quit"
    end

    def wants_to_quit?
      gets == "#{QUIT_ON_INPUT}\n"
    end

    def display_result(player_won, dice_one_value, dice_two_value)
        if player_won
          puts "You are a winner: #{dice_one_value} #{dice_two_value}"
        else
          puts "Sorry you lost: #{dice_one_value} #{dice_two_value}"
        end
    end

  end
end
