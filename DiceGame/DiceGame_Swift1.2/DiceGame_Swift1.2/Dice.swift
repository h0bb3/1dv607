//
//  Dice.swift
//  Dice
//
//  Created by Andreas Bom on 2015-09-02.
//  Copyright (c) 2015 Andreas Bom. All rights reserved.
//

import Foundation


class Dice {
    var m_value:Int
    
    init(){
        m_value = 0
    }
    
    func Roll(){
        m_value = Int(arc4random_uniform(5) + 1)
        
    }
    
    func GetValue()->Int{
        return m_value
    }
}