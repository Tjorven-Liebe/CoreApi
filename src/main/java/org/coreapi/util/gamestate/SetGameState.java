package org.coreapi.util.gamestate;

public class SetGameState {

    public void start() {
        GetGameState.gameState = GameState.START;
    }

    public void ingame() {
        GetGameState.gameState = GameState.INGAME;
    }

    public void end() {
        GetGameState.gameState = GameState.END;
    }

}
