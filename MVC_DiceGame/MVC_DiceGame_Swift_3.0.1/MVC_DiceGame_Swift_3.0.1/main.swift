//
//  main.swift
//  MVC_DiceGame_Swift_3.0.1
//
//  Created by Sarpreet Singh on 2016-11-13.
//  Copyright © 2016 Sarpreet Singh. All rights reserved.
//

import Foundation

var game = DiceGame();
var view = Console();//SweConsole();
var controller = Player();

controller.playGame(a_game: game, a_view: view);
