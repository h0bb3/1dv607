//
//  DiceGame.swift
//  Dice
//
//  Created by Andreas Bom on 2015-09-02.
//  Copyright (c) 2015 Andreas Bom. All rights reserved.
//

import Foundation

class DiceGame {
    
    var m_d1:Dice
    var m_d2:Dice
    
    
    init(){
        m_d1 = Dice()
        m_d2 = Dice()
    }
    
    func Play()->Bool{
        m_d1.Roll()
        m_d2.Roll()
        return m_d1.GetValue() + m_d2.GetValue() == 7
    }
    
}