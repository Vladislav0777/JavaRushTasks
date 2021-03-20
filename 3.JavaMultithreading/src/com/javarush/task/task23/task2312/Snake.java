package com.javarush.task.task23.task2312;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<SnakeSection> sections = new ArrayList<>();
    private boolean isAlive;
    private SnakeDirection direction;

    public Snake(int x, int y) {
        sections.add(new SnakeSection(x,y));
        isAlive = true;
    }

    public int getX(){
        return sections.get(0).getX();
    }
    public int getY(){
        return sections.get(0).getY();
    }

    public void move() {
        if (!isAlive){
            return;
        } else if (direction==SnakeDirection.UP) {
            move(0,-1);
        } else if (direction==SnakeDirection.RIGHT) {
            move(1,0);
        } else if (direction==SnakeDirection.DOWN) {
            move(0,1);
        } else if (direction==SnakeDirection.LEFT) {
            move(-1,0);
        }
    }
    public void move(int i, int j) {
    }


    public List<SnakeSection> getSections() {
        return sections;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public SnakeDirection getDirection() {
        return direction;
    }

    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }

    public void checkBorders(SnakeSection head) {
        if(head.getX()<0) {
            isAlive=false;
        } else if(head.getY()<0) {
            isAlive=false;
        } else if(head.getX()>=Room.game.getHeight()){
            isAlive=false;
        } else if(head.getY()>=Room.game.getWidth()) {
            isAlive=false;
        }
    }
    public void checkBody(SnakeSection head) {
        if(sections.contains(head)) {
            isAlive=false;
        }
    }
}

