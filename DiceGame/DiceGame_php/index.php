<?php


require_once('DiceGame.php');

$g = new DiceGame();

if($g->Play()){
    echo "You are a winner";
}
else{
    echo "Sorry";
}