//
//  Player.swift
//  MVC_O_DiceGame_Swift_3.0.1
//
//  Created by Sunny Buttar on 2016-11-13.
//  Copyright © 2016 Sarpreet Singh. All rights reserved.
//

import Foundation

public class Player : IDiceRolledObserver {
    
    private var m_view : IView;
    
    init(a_view : IView) {
        m_view = a_view;
    }
    
    func playGame(a_game : DiceGame) {
        
        a_game.addSubscriber(a_sub: self);
        m_view.displayWelcomeMessage();
        m_view.displayInstructions();
        
        while m_view.wantsToPlay() {
            m_view.displayResult(a_win: a_game.play());
            
            m_view.displayInstructions();
        }
    }
    
    func diceRolled(a_faceValue: Int) {
        m_view.displayDiceValue(a_value: a_faceValue);
    }
}
