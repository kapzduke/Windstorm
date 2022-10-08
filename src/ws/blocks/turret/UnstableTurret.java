package ws.blocks.turret;

import mindustry.entities.bullet.*;
import mindustry.world.blocks.defense.turrets.*;

public class UnstableTurret extends PowerTurret {
    public UnstableTurret(String name) {
        super(name);
    }
    
    public float damageAddition = 0.75f;
    public float damageLimit = this.shootType.damage * 3f;

    public class UnstableTurretBuild extends PowerTurretBuild {
        float lastDamage = shootType.damage;
        @Override
        public void shoot(BulletType b){
            super.shoot(b);
            if(shootType.damage < damageLimit) {
                shootType.damage += damageAddition;
            } else {
                shootType.damage = lastDamage;
            }
        }
    }
}