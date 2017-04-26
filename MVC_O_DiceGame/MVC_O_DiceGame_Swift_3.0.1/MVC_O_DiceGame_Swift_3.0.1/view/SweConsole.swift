//
//  SweConsole.swift
//  MVC_O_DiceGame_Swift_3.0.1
//
//  Created by Sunny Buttar on 2016-11-13.
//  Copyright © 2016 Sarpreet Singh. All rights reserved.
//

import Foundation

public class SweConsole : IView {
    
    func getInputChar() -> String {
        var input : String = readLine()!;
        while input == "\n" || input == "\r" || input.characters.count > 1{
            input = readLine()!;
        }
        return input;
    }
    
    func wantsToPlay() -> Bool {
        return getInputChar() != "a";
    }
    
    func displayResult(a_win : Bool) {
        if a_win {
            print("Vann");
        } else {
            print("Förlorade ");
        }
    }
    
    func displayWelcomeMessage() {
        print("Välkommen till tärningsspelet");
    }
    
    func displayInstructions() {
        print("Truck en tangent för att spela eller 'a' för att avsluta");
    }
    
    func displayDiceValue(a_value: Int) {
        print(String (a_value));
    }
}
