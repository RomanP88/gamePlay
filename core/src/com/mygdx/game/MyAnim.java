package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MyAnim {

    Texture img;
    Animation<TextureRegion> anm;
    private float time;


    public MyAnim(String name, int row, int col , float fps, Animation.PlayMode playMode) {
        time = 0;
        img = new Texture(name);
        TextureRegion reg1 = new TextureRegion(img);
        TextureRegion [][] regions = reg1.split(img.getWidth()/col, img.getHeight()/row);
        TextureRegion[] tmp = new TextureRegion[regions.length * regions[0].length];
        int cnt = 0;
        for (int i = 0; i < regions.length; i++) {
            for (int j = 0; j < regions[0].length; j++) {
                tmp[cnt++] = regions[i][j];
            }
        }
        anm = new Animation<>(1/fps, tmp);
        anm.setPlayMode(playMode);
    }


    public TextureRegion draw(){
        return anm.getKeyFrame(time);
    }

    public void setTime(float dt){
        time += dt;
    }

    public void dispose(){
        this.img.dispose();
    }

}
