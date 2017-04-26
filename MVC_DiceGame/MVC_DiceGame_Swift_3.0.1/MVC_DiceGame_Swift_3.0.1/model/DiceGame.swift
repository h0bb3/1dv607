//
//  DiceGame.swift
//  MVC_DiceGame_Swift_3.0.1
//
//  Created by Sarpreet Singh on 2016-11-13.
//  Copyright © 2016 Sarpreet Singh. All rights reserved.
//

import Foundation

public class DiceGame {
    
    private var m_d1 : Dice;
    private var m_d2 : Dice;
    
    init() {
        m_d1 = Dice();
        m_d2 = Dice();
    }
    
    public func play() -> Bool {
        m_d1.roll();
        m_d2.roll();
        
        return m_d1.getValue() + m_d2.getValue() == 7;
    }
    
    public func getValueDice1() -> Int {
        return m_d1.getValue();
    }
    
    public func getValueDice2() -> Int {
        return m_d2.getValue();
    }
}
