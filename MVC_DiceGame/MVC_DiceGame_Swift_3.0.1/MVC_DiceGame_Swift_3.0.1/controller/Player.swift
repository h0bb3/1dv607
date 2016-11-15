//
//  Player.swift
//  MVC_DiceGame_Swift_3.0.1
//
//  Created by Sarpreet Singh on 2016-11-13.
//  Copyright © 2016 Sarpreet Singh. All rights reserved.
//

import Foundation

public class Player {
    
    
    func playGame(a_game : DiceGame, a_view : IView) {
        
        a_view.displayWelcomeMessage();
        a_view.displayInstructions();
        
        while a_view.wantsToPlay() {
            a_view.displayResult(a_win: a_game.play(), a_dice1Val: a_game.getValueDice1(), a_dice2Val: a_game.getValueDice2())
            
            a_view.displayInstructions();
        }
    }
}
