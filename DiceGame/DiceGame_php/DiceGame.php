<?php

require_once('Dice.php');

class DiceGame
{
    private $m_d1;
    private $m_d2;

    public function __construct()
    {
        $this->m_d1 = new Dice();
        $this->m_d2 = new Dice();
    }

    public function Play()
    {
        $this->m_d1->Roll();
        $this->m_d2->Roll();
        
        return $this->m_d1->GetValue() + $this->m_d2->GetValue() == 7;
    }
}