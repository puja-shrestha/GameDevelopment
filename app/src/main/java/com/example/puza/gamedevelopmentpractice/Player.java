package com.example.puza.gamedevelopmentpractice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Player {

    //Bitmap to get character from image
    private Bitmap bitmap;

    //coordinates
    private int x;
    private int y;

    //motion speed of the character
    private int speed = 0;

    //boolean variable to track the ship is boosting or not
    private boolean boosting;

    //gravity values to add gravity effect on the ship
    private final int GRAVITY = -10;

    //Controlling Y coordinate so that ship won't go outside teh screen
    private int maxY;
    private int minY;

    //Limit the bounds of the ship's speed
    private final int MIN_SPEED = 1;
    private final int MAX_SPEED = 20;


    //constructor
    public Player(Context context, int screenX, int screenY) {
        x = 75;
        y = 50;
        speed = 1;

        //getting bitmap from drawable resource
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.player);

        //calculating maxY
        maxY = screenY - bitmap.getHeight();

        //top edge's y paint is 0 so min y will always be zero
        minY = 0;

        //seeting the boosting values to false initially
        boosting = false;
    }

    //setting boosting true
    public void setBoosting() {
        boosting = true;
    }

    //setting boosting false
    public void stopBoosting() {
        //if the ship is boosting
        if (boosting) {
            //speeding up the ship
            speed += 2;
        } else {
            //slowing down if not boosting
            speed -= 5;
        }

        //controlling the top speed
        if (speed > MAX_SPEED) {
            speed = MAX_SPEED;
        }

        //if the speed is less than min speed
        //controlling it so that it won't stop completely
        if (speed < MIN_SPEED) {
            speed = MIN_SPEED;
        }

        //moving the ship down
        y -= speed + GRAVITY;

        //but controlling it also so that it won't go off the screen
        if (y < minY) {
            y = minY;
        }
        if (y > minY) {
            y =maxY;
        }
    }

    //method to update coordinate of character
    public void update(){
        //updating x coordinate
        x++;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSpeed() {
        return speed;
    }
}
