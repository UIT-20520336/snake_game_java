package com.mygdx.game.level;

import com.mygdx.game.Game;
import com.mygdx.game.entities.Player.Facing;
import com.mygdx.game.entities.Wall;

import java.util.ArrayList;
import java.util.List;

public class LevelData {
    protected int rows;
    protected int columns;
    protected final int gridCell = 20;

    protected int levelID;

    protected int fruitToNextLevel;

    protected List<Wall> walls;

    protected float startX;
    protected float startY;
    protected Facing facing;
    protected LevelData nextLevel;

    protected void line(int x1, int y1, int x2, int y2) {

        int dx = x1 - x2;
        int dy = y1 - y2;
        //distance between to points
        float distance = (float) Math.sqrt(dx * dx + dy * dy);
        //the distance between the two points must be different then zero, and dx or dy must be zero.
        if (distance == 0 || dx != 0 && dy != 0)
            return;

        for (int i = (dx == 0 ? y1 : x1);
             i <= (dx == 0 ? y2 : x2);
             i++) {
            walls.add(new Wall(
                    (dx == 0 ? x1 : i) * gridCell,
                    (dy == 0 ? y1 : i) * gridCell,
                    gridCell));
        }

    }

    void init() {
        //setup board
        Game.WIDTH = columns * gridCell;
        Game.HEIGHT = rows * gridCell;

        Game.camera.position.set(Game.WIDTH / 2, Game.HEIGHT / 2, 0);
        Game.camera.update();
    }

    public LevelData getFirstLevel() {
        return new Level1();
    }

    int getRows() {
        return rows;
    }

    int getColumns() {
        return columns;
    }

    int getGridCell() {
        return gridCell;
    }

    int getID() {
        return levelID;
    }

    int getFruitToNextLevel() {
        return fruitToNextLevel;
    }

    List<Wall> getWalls() {
        return walls;
    }

    float getStartX() {
        return startX;
    }

    float getStartY() {
        return startY;
    }

    Facing getFacing() {
        return facing;
    }
}

class Level1 extends LevelData {
    public Level1() {
        walls = new ArrayList<>();

        rows = 20;
        columns = 20;
        levelID = 1;
        fruitToNextLevel = 1;

        startX = 5;
        startY = 5;
        facing = Facing.UP;
        nextLevel = new Level2();

        init();

        line(0, 0, 19, 0);
        line(0, 19, 19, 19);
        line(0, 1, 0, 18);
        line(19, 1, 19, 18);
    }
}

class Level2 extends LevelData {
    public Level2() {
        walls = new ArrayList<>();

        rows = 20;
        columns = 20;
        levelID = 2;
        fruitToNextLevel = 1;

        startX = 5;
        startY = 5;
        facing = Facing.UP;
        nextLevel = new Level3();

        init();

        line(0, 0, 6, 0);
        line(13, 0, 19, 0);
        line(0, 19, 6, 19);
        line(13, 19, 19, 19);

        line(0, 1, 0, 6);
        line(0, 13, 0, 18);
        line(19, 1, 19, 6);
        line(19, 13, 19, 18);
    }
}

class Level3 extends LevelData {
    public Level3() {
        walls = new ArrayList<>();

        rows = 20;
        columns = 20;
        levelID = 3;
        fruitToNextLevel = 2;

        startX = 3;
        startY = 5;
        facing = Facing.UP;
        nextLevel = new Level4();

        init();

        line(0, 0, 6, 0);
        line(13, 0, 19, 0);
        line(0, 19, 6, 19);
        line(13, 19, 19, 19);

        line(0, 1, 0, 6);
        line(0, 13, 0, 18);
        line(19, 1, 19, 6);
        line(19, 13, 19, 18);

        line(5, 6, 14, 6);
        line(5, 13, 14, 13);
    }
}

class Level4 extends LevelData {
    public Level4() {
        walls = new ArrayList<>();

        rows = 20;
        columns = 20;
        levelID = 4;
        fruitToNextLevel = 80;
        startX = 3;
        startY = 13;
        facing = Facing.UP;
        nextLevel = new Level5();

        init();

        line(0, 7, 10, 7);
        line(10, 13, 19, 13);
        line(7, 10, 7, 19);
        line(13, 0, 13, 10);

    }

}

class Level5 extends LevelData {
    public Level5() {
        walls = new ArrayList<>();

        rows = 20;
        columns = 20;
        levelID = 5;
        fruitToNextLevel = 100;
        startX = 10;
        startY = 10;
        facing = Facing.UP;
        nextLevel = new Level6();

        init();

        line(0, 0, 0, 6);
        line(0, 13, 0, 19);
        line(1, 19, 19, 19);
        line(19, 13, 19, 18);
        line(19, 0, 19, 6);
        line(1, 0, 18, 0);

        line(6, 5, 6, 14);
        line(13, 5, 13, 14);
    }
}

class Level6 extends LevelData {
    public Level6() {
        walls = new ArrayList<>();

        rows = 20;
        columns = 20;
        levelID = 6;
        fruitToNextLevel = 120;
        startX = 10;
        startY = 8;
        facing = Facing.UP;
        nextLevel = new Level7();
        init();

        line(0, 0, 0, 6);
        line(1, 6, 3, 6);
        line(3, 7, 3, 13);
        line(0, 13, 2, 13);
        line(0, 14, 0, 19);
        line(0, 14, 0, 19);
        line(1, 19, 7, 19);
        line(7, 15, 7, 18);
        line(8, 15, 12, 15);
        line(12, 16, 12, 19);
        line(13, 19, 19, 19);
        line(19, 13, 19, 18);
        line(17, 13, 18, 13);
        line(17, 6, 18, 6);
        line(19, 0, 19, 6);
        line(12, 0, 18, 0);
        line(12, 1, 12, 2);
        line(1, 0, 7, 0);
        line(7, 1, 7, 2);
    }
}

class Level7 extends LevelData {
    public Level7() {
        walls = new ArrayList<>();

        rows = 20;
        columns = 20;
        levelID = 7;
        fruitToNextLevel = 140;
        startX = 15;
        startY = 5;
        facing = Facing.DOWN;
        nextLevel = new Level8();
        init();

        line(0, 10, 19, 10);
        line(10, 0, 10, 9);
        line(10, 11, 10, 19);
    }
}

class Level8 extends LevelData {
    public Level8() {
        walls = new ArrayList<>();

        rows = 20;
        columns = 20;
        levelID = 8;
        fruitToNextLevel = 160;
        startX = 10;
        startY = 15;
        facing = Facing.RIGHT;
        nextLevel = new Level9();
        init();

        line(0, 10, 19, 10);
        line(6, 0, 6, 9);
        line(13, 0, 13, 9);
    }

}

class Level9 extends LevelData {
    public Level9() {
        walls = new ArrayList<>();

        rows = 20;
        columns = 20;
        levelID = 9;
        fruitToNextLevel = 180;
        startX = 15;
        startY = 15;
        facing = Facing.RIGHT;
        nextLevel = new Level10();
        init();

        line(0, 10, 19, 10);
        line(6, 0, 6, 9);
        line(13, 0, 13, 9);
        line(10, 11, 10, 19);
    }
}

class Level10 extends LevelData {
    public Level10() {
        walls = new ArrayList<>();
        
        rows = 20;
        columns = 20;
        levelID = 10;
        fruitToNextLevel = 200;
        startX = 10;
        startY = 9;
        facing = Facing.LEFT;
        nextLevel = null;
        init();

        line(0, 6, 19, 6);
        line(0, 12, 8, 12);
        line(12, 12, 19, 12);
        line(0, 19, 3, 19);
        line(7, 19, 16, 19);
        line(12, 0, 12, 5);
        line(8, 13, 8, 18);
        line(0, 16, 0, 18);
    }
}