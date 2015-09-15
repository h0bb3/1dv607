
from Dice import Dice

class DiceGame:

    # Constructor
    def __init__(self):

        # 2 new instances of Dice object
        self.m_d1 = Dice()
        self.m_d2 = Dice()

    def play(self):

        self.m_d1.roll()
        self.m_d2.roll()

        print('m_d1: {}'.format(self.m_d1.getValue()))
        print('m_d2: {}'.format(self.m_d2.getValue()))

        return self.m_d1.getValue() + self.m_d2.getValue() == 7
