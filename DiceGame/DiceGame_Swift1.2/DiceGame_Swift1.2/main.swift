//
//  main.swift
//  Dice
//
//  Created by Andreas Bom on 2015-09-02.
//  Copyright (c) 2015 Andreas Bom. All rights reserved.
//

import Foundation

let g = DiceGame()
var x = 0

do {
    if(g.Play()){
        println("You are a winner")
        x = 1
    }else {
        println("Sorry")
    }
} while x == 0