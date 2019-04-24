package com.control;
/*This enum class for states is used to switch between different states of the game. This is used 
 * in other classes depending on the user input and the progress of the game.*/
public enum States {
	tutorial,
	level1,
	level2,
	level3,
	bosslevel,
	shop, 
	
	TitleScreen,
	highscores,
	Load,
	Options,
	
	Pause,
	pauseOptions,

	Controls,
	Sound,
	Credits,
	
	winscreen,
	deathscreen;
}
