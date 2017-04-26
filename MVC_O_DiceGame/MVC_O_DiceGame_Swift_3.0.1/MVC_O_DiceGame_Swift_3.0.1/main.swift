//
//  main.swift
//  MVC_O_DiceGame_Swift_3.0.1
//
//  Created by Sunny Buttar on 2016-11-13.
//  Copyright © 2016 Sarpreet Singh. All rights reserved.
//

import Foundation


    var game = DiceGame();
    var view = Console();//SweConsole();
    var controller = Player(a_view : view);

    controller.playGame(a_game: game);


