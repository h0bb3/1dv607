//
//  Console.swift
//  MVC_O_DiceGame_Swift_3.0.1
//
//  Created by Sunny Buttar on 2016-11-13.
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
    
    func displayResult(a_win : Bool) {
        if a_win {
            print("You Win!!");
        } else {
            print("You Loose!! ");
        }
    }
    
    func displayWelcomeMessage() {
        print("Hello Dice Game World");
    }
    
    func displayInstructions() {
        print("Any key to play 'q' to quit");
    }
    
    func displayDiceValue(a_value: Int) {
         print(String (a_value));
    }
}
