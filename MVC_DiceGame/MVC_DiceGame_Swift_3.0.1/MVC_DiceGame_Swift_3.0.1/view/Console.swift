//
//  Console.swift
//  MVC_DiceGame_Swift_3.0.1
//
//  Created by Sarpreet Singh on 2016-11-13.
//  Copyright © 2016 Sarpreet Singh. All rights reserved.
//

import Foundation

public class Console : IView {
    
    func getInputChar() -> String {
        var input : String = readLine()!;
        while input == "\n" || input == "\r" || input.characters.count > 1{
            input = readLine()!;
        }
        return input;
    }
    
    func wantsToPlay() -> Bool {
        return getInputChar() != "q";
    }
    
    func displayResult(a_win : Bool, a_dice1Val : Int, a_dice2Val : Int) {
        if a_win {
            print("Win: " + String (a_dice1Val) + "  " + String (a_dice2Val));
        } else {
            print("Lose: " + String (a_dice1Val) + "  " + String (a_dice2Val));
        }
    }
    
    func displayWelcomeMessage() {
        print("Hello Dice Game World");
    }
    
    func displayInstructions() {
        print("Any key to play 'q' to quit");
    }
}
