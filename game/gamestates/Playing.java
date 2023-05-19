package gamestates;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import core.UserPanel;
import entities.Player;
import level.LevelHandler;

public class Playing extends State implements StateMethods {

    private Player player;
    private LevelHandler levelHandler;

    public Playing(UserPanel game) {
        super(game);
        initClasses();
    }

    private void initClasses() {
        levelHandler = new LevelHandler(game);

        player = new Player(200, 200, UserPanel.SCALED_TILE_SIZE, UserPanel.SCALED_TILE_SIZE);
        player.setLevelData(levelHandler.getLevel().getLevelData());
        
    }

    @Override
    public void update() {
        levelHandler.update();
        player.update();
    }

    @Override
    public void draw(Graphics g) {
        levelHandler.draw(g);
        player.render(g);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_W:
                player.setUp(true);
                break;
            case KeyEvent.VK_A:
                player.setMovingLeft(true);
                break;
            case KeyEvent.VK_S:
                player.setDown(true);
                break;
            case KeyEvent.VK_D:
                player.setMovingRight(true);
                break;
            case KeyEvent.VK_SPACE:
                player.setJump(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_W:
                player.setUp(false);
                break;
            case KeyEvent.VK_A:
                player.setMovingLeft(false);
                break;
            case KeyEvent.VK_S:
                player.setDown(false);
                break;
            case KeyEvent.VK_D:
                player.setMovingRight(false);
                break;
            case KeyEvent.VK_SPACE:
                player.setJump(false);
        }
    }

    public Player getPlayer() {
        return player;
    }
    
}
