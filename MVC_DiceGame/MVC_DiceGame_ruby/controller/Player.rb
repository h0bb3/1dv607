module Controller
  class Player

    def playGame(a_game, a_view)
      a_view.display_instructions
      until a_view.wants_to_quit? do
        a_view.display_instructions
        a_view.display_result(a_game.play, a_game.dice_one_value, a_game.dice_two_value)
      end
    end

  end
end
