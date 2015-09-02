#pragma once
#include "Dice.h";

class DiceGame
{
public:
	DiceGame();
	bool Play();

private:
	Dice m_d1;
	Dice m_d2;
};

DiceGame::DiceGame()
{
	m_d1 = Dice();
	m_d2 = Dice();
}
bool DiceGame::Play()
{
	m_d1.Roll();
	m_d2.Roll();
	return m_d1.GetValue() + m_d2.GetValue() == 7;
}