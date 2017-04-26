//
//  IView.swift
//  MVC_O_DiceGame_Swift_3.0.1
//
//  Created by Sunny Buttar on 2016-11-13.
//  Copyright © 2016 Sarpreet Singh. All rights reserved.
//

import Foundation

protocol IView {
    
    func wantsToPlay() -> Bool;
    
    func displayResult(a_win : Bool);
    
    func displayWelcomeMessage();
    
    func displayInstructions();
    
    func displayDiceValue(a_value : Int);
}
