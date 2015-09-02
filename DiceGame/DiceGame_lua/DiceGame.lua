require('Dice')

-- Meta class
DiceGame = {}
DiceGame.__index = DiceGame

--Constructor
function DiceGame:new ()
    local o = {m_d1 = Dice:new(), m_d2 = Dice:new()}
    setmetatable(o, self)
    return o
end

--Function
function DiceGame:play()
    self.m_d1:roll()
    self.m_d2:roll()

    print(('m_d1: %i'):format(self.m_d1:getValue()))
    print(('m_d2: %i'):format(self.m_d2:getValue()))

    return self.m_d1:getValue() + self.m_d2:getValue() == 7

end

