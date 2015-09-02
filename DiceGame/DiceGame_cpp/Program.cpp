#include <iostream>;
#include "Dice.h";
#include "DiceGame.h";

int main()
{
	srand(time(0)); // Random seed

	DiceGame game = DiceGame();

	if (game.Play())
		std::cout << "You are a winner";
	else
		std::cout << "Sorry";

	getchar(); // Pauses the game
    return 0;
}