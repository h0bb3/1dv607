module Controller
  class Player

    def initialize a_view
      @view = a_view;
    end

    def play a_game
      a_game.add_subscriber self 
      @view.display_instructions

      until @view.wants_to_quit? do
        @view.display_instructions
        @view.display_result a_game.play
      end
    end

    def rolled_dice face_value
      @view.display_dice_value face_value
    end

  end
end
