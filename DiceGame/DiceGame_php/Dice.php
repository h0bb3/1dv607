<?php


class Dice
{

    private $m_value;

    public function __construct()
    {
        $this->m_value = 0;
    }

    public function Roll()
    {
        $this->m_value = rand(1, 6);
    }

    public function GetValue() {
        return $this->m_value;
    }
}