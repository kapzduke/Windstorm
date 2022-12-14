package ws.content;

import arc.graphics.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.graphics.*;

public class WBullets {
    public static BulletType empty,
    axoniumWallBullet, notaniumWallBullet;

    public static void load(){
        empty = new BasicBulletType(0, 0){{
            width = height = lifetime = 0;
        }};

        axoniumWallBullet = new BasicBulletType(6, 8){{
            width = height = 8;
            lifetime = 45;
        }};

        notaniumWallBullet = new BasicBulletType(8, 14){{
            width = height = 8;
            lifetime = 60;
        }};
    }
}