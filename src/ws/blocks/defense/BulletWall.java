package ws.blocks.defense;

import mindustry.entities.bullet.*;
import mindustry.world.blocks.defense.*;
import ws.content.*;

public class BulletWall extends Wall {
    public BulletWall(String name){
        super(name);
    }

    public int bullets = 6;
    public BulletType bullet = WBullets.empty;

    public class BulletWallBuild extends WallBuild {
        @Override
        public void onDestroyed(){
            super.onDestroyed();
            for(int i = 0;i<bullets;i++){
                bullet.create(this, x, y, i * (360/bullets));
            }
        }
    }
}