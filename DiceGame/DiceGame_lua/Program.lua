require('DiceGame')

local g = DiceGame:new()

if g:play() then
print('You are a winner!')

else
print('Sorry')
end
