//
//  Dice.swift
//  MVC_O_DiceGame_Swift_3.0.1
//
//  Created by Sunny Buttar on 2016-11-13.
//  Copyright © 2016 Sarpreet Singh. All rights reserved.
//

import Foundation

public class Dice {
    
    private var m_value : Int;
    
    init() {
        m_value = 0;
    }
    
    public func roll() {
        m_value = Int(arc4random_uniform(6) + 1);
    }
    
    func getValue() -> Int {
        return m_value;
    }
}
