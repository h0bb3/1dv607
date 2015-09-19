# coding: utf-8
module View
  class SweConsole < Console

    QUIT_ON_INPUT  = "s"

    def display_instructions
      system "clear"
      puts "Välkommen till tärningsspelet. Tryck en tangent för att spela, eller #{QUIT_ON_INPUT} för att sluta"
    end

    def wants_to_quit?
      gets == "#{QUIT_ON_INPUT}\n"
    end

    def display_result player_won
        if player_won
          puts "Du är en vinnare!"
        else
          puts "Ledsen men du förlorade"
        end
    end

  end
end
