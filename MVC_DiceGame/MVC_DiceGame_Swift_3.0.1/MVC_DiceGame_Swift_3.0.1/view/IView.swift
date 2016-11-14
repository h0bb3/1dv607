//
//  IView.swift
//  MVC_DiceGame_Swift_3.0.1
//
//  Created by Sarpreet Singh on 2016-11-13.
//  Copyright © 2016 Sarpreet Singh. All rights reserved.
//

import Foundation

protocol IView {
    
    func wantsToPlay() -> Bool;
    
    func displayResult(a_win : Bool, a_dice1Val : Int, a_dice2Val : Int);
    
    func displayWelcomeMessage();
    
    func displayInstructions();
}
