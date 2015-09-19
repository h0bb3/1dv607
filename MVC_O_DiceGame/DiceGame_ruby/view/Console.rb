module View
  class Console


    def display_instructions
      raise NotImplementedError
    end

    def display_result 
      raise NotImplementedError
    end

    def wants_to_quit?
      raise NotImplementedError
    end

    def display_dice_value value
        puts value
    end

  end
end
