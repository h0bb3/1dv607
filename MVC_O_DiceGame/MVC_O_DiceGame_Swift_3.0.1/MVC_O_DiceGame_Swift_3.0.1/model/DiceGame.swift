//
//  DiceGame.swift
//  MVC_O_DiceGame_Swift_3.0.1
//
//  Created by Sunny Buttar on 2016-11-13.
//  Copyright © 2016 Sarpreet Singh. All rights reserved.
//

import Foundation
import Darwin

public class DiceGame {

    private var m_d1 : Dice;
    private var m_d2 : Dice;
    private var m_d3 : Dice;
    private var m_subscribers : Array<IDiceRolledObserver>;

    init() {
        m_d1 = Dice();
        m_d2 = Dice();
        m_d3 = Dice();
        m_subscribers = Array<IDiceRolledObserver>();
    }

    func addSubscriber(a_sub : IDiceRolledObserver) {
        m_subscribers.append(a_sub);
    }

    func rollDice(a_dice : Dice) {
        a_dice.roll();

        for item in m_subscribers {
            item.diceRolled(a_faceValue: a_dice.getValue());
        }

        sleep(2);
    }

    func play() -> Bool {
        rollDice(a_dice: m_d1);
        rollDice(a_dice: m_d2);
        rollDice(a_dice: m_d3);

        return m_d1.getValue() + m_d2.getValue() + m_d3.getValue() == 9;
    }
}
