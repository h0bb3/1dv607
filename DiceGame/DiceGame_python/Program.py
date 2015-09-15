#!/usr/bin/python -tt

from DiceGame import DiceGame

# Works like public static void main (in Java)
if __name__ == '__main__':

    # New instance of DiceGame
    g = DiceGame()

    if g.play():
        print('You are a winner!')

    else:
        print('Sorry')
