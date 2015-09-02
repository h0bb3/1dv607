-- Meta class
Dice = {}
Dice.__index = Dice

--Constructor
function Dice:new()
    local o = {m_value = math.random(5)}
    setmetatable(o, self)
    return o
end

--Function
function Dice:roll()
    math.randomseed(tonumber(tostring({}):match("0x(.*)$"),16)) --LUA random generator sucks
    math.random() --First random number is not completely random, see comment above
    local number = math.random(5)
    self.m_value = number
end

--Function
function Dice:getValue()
    return self.m_value
end

