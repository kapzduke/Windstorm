package ws.blocks.defense;

import arc.scene.ui.layout.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.gen.*;
import mindustry.world.blocks.defense.*;

public class DisposableWall extends Wall {
	public DisposableWall(String name) {
        super(name);
        configurable = true;
    }

    public float damage = 1f, range = 80f;
    public Effect explodeEffect = Fx.massiveExplosion;

    public void explosion(int damage, int range, Effect fx){
        this.damage = damage;
        this.range = range;
        this.explodeEffect = fx;
    }

	public class DisposableWallBuild extends WallBuild {
		@Override
		public void onDestroyed() {
			super.onDestroyed();
			Damage.damage(team, x, y, range, damage);
			explodeEffect.at(x, y);
		}

        public void buildConfiguration(Table t){
            t.button(Icon.commandAttack, () -> {
                this.kill();
            });
        }
	}
}
