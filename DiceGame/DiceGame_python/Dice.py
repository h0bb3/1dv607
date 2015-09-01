
import random

class Dice:

    # Constructor
    def __init__(self):
        self.m_value = 0

    # Function
    def roll(self):
        self.m_value = random.randint(1,6)

    # Function
    def getValue(self):
        return self.m_value
