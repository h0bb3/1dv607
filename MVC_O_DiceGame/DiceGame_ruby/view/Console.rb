module View
  class Console

    def display_dice_value value
        puts value
    end

    def wants_to_quit?
      gets == "#{self.class::QUIT_ON_INPUT}\n"
    end

  end
end
