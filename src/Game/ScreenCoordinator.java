/*
 * SER225- Mystery Game
 * the dawgs- Adelina Chocho, Ella Berry, Morgan Montz, Sam Woodburn, Tuana Turhan
 * Fall 2024
 * 
 * package- Game
 * class- ScreenCoordinator: Based on the current game state, this class determines which Screen 
 * should be shown; There can only be one "currentScreen", although screens can have "nested" screens
 */

package Game;

import Engine.BackgroundMusic;
import Engine.DefaultScreen;
import Engine.GraphicsHandler;
import Engine.Screen;
import Screens.CreditsScreen;
import Screens.Death;
import Screens.HowToPlay;
import Screens.Join;
import Screens.LostScreen;
import Screens.MenuScreen;
import Screens.PlayLevelScreen;
import Screens.ButcherDeathScreen;
import Screens.WinScreen;
import Screens.CharacterSelectScreen;
import Screens.Context0Screen;
import Screens.Context1Screen;
import Screens.MissingPosterScreen;
import Screens.ButcherDeathScreen;



public class ScreenCoordinator extends Screen {
	// currently shown Screen
	protected Screen currentScreen = new DefaultScreen();
	// keep track of gameState so ScreenCoordinator knows which Screen to show
	protected GameState gameState;
	protected GameState previousGameState;

	private BackgroundMusic backgroundMusic;
	private boolean musicInitialized = false;

	public ScreenCoordinator(){
		//Initialize main music when game starts 
		if (!musicInitialized){
			backgroundMusic = new BackgroundMusic("Resources/GameSong.wav");
			musicInitialized = true;
			backgroundMusic.PlayMainMusic();
		}
	}

	public GameState getGameState() {
		return gameState;
	}
	// Other Screens can set the gameState of this class to force it to change the currentScreen
	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}

	public void setPrevState(GameState prevState){
        this.previousGameState = prevState;
    }
    public GameState getPrevState(){
        return this.previousGameState;
    }
	
	

	@Override
	public void initialize() {
		// start game off with Menu Screen
		gameState = GameState.MENU;
	}

	@Override
	public void update() {
		do {
			// if previousGameState does not equal gameState, it means there was a change in gameState
			// this triggers ScreenCoordinator to bring up a new Screen based on what the gameState is
			if (previousGameState != gameState) {
				switch(gameState) {
					case MENU:
						currentScreen = new MenuScreen(this);
						backgroundMusic.playLocationMusic("menu");
						break;
					case LEVEL:
						currentScreen = new PlayLevelScreen(this);
						backgroundMusic.playLocationMusic("level");
						break;
					case CREDITS:
						currentScreen = new CreditsScreen(this);
						backgroundMusic.playLocationMusic("credits");
						break;
					case HOWTOPLAY:
						currentScreen = new HowToPlay(this);
						backgroundMusic.playLocationMusic("howtoplay");
						currentScreen = new HowToPlay(this);
						break;
					case CONTEXT0:
						currentScreen = new Context0Screen(this);
						backgroundMusic.playLocationMusic("context1");
						break;
					case CONTEXT1:
						currentScreen = new Context1Screen(this);
						backgroundMusic.playLocationMusic("context1");
						break;
					case MISSINGPOSTER:
						currentScreen = new MissingPosterScreen(this);
						break;
					case CHARSELECT:
						currentScreen = new CharacterSelectScreen(this);

						backgroundMusic.playLocationMusic("charselect");
						break;
					case DEATH:
						currentScreen = new Death(this);
						break;
					case LOST:
    					currentScreen = new LostScreen(new PlayLevelScreen(this));
						break;
					// case PETERDEATH:
					// 	currentScreen = new ButcherDeathScreen(this);
						// break;
					case JOIN:
					 	currentScreen = new Join(this);
						break;
					case WIN:
						currentScreen = new WinScreen((new PlayLevelScreen(this)));
					
				}
				currentScreen.initialize();
			}
			previousGameState = gameState;

			// call the update method for the currentScreen
			currentScreen.update();
		} while (previousGameState != gameState);
	}

	@Override
	public void draw(GraphicsHandler graphicsHandler) {
		// call the draw method for the currentScreen
		currentScreen.draw(graphicsHandler);
	}
}
