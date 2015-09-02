#pragma once
#include <chrono>;

class Dice
{
public:
	Dice();
	void Roll();
	int GetValue();

private:
	int m_value;
};

Dice::Dice()
{
	m_value = 0;
}
void Dice::Roll()
{
	m_value = rand() % 6 + 1;
}
int Dice::GetValue()
{
	return m_value;
}