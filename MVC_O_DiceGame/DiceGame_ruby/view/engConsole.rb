module View
  class EngConsole < Console

    QUIT_ON_INPUT  = "q"

    def display_instructions
      system "clear"
      puts "Welcome to the cool Dice Game. Press any Key to play, or #{QUIT_ON_INPUT} to Quit"
    end

    def wants_to_quit?
      gets == "#{QUIT_ON_INPUT}\n"
    end

    def display_result player_won
        if player_won
          puts "You are a winner!"
        else
          puts "Sorry you lost!"
        end
    end

  end
end
