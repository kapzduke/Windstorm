package ws.content;

import arc.*;
import arc.util.*;
import arc.math.*;
import arc.struct.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import mindustry.gen.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.content.*;
import mindustry.graphics.*;
import mindustry.world.meta.*;
import mindustry.world.draw.*;
import mindustry.world.blocks.*;
import mindustry.entities.part.*;
import mindustry.entities.bullet.*;
import mindustry.entities.pattern.*;
import mindustry.world.blocks.units.*;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.liquid.*;
import mindustry.world.blocks.storage.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.defense.turrets.*;

import ws.blocks.defense.*;
import ws.blocks.distribution.*;

import static mindustry.type.Category.*;
import static mindustry.type.ItemStack.*;
import static ws.content.WItems.*;

public class WBlocks {
	public static Block
    // start
    start,
    // defense
    axoniumWall, axoniumWallLarge, axoniumWallHuge,
    disposableWall, disposableWallLarge, disposableWallHuge,
    // distribution
    axoBridge, terronBridge, axoRouter, axoSorter, axoGate,
    // production
    miniBore;

    public static void load(){
        // start
        start = new Block("start"){{
			buildVisibility = BuildVisibility.debugOnly;
			inEditor = false;
			alwaysUnlocked = true;
		}};

        // defense
        axoniumWall = new BulletWall("axonium-wall"){{
            requirements(defense, with(WItems.axonium, 8), true);
            scaledHealth = 200;
            bullet = WBullets.axoniumWallBullet;
            bullets = 12;
            size = 1;
            chanceDeflect = 0.3f;
        }};

        axoniumWallLarge = new BulletWall("axonium-wall-large"){{
            requirements(defense, with(WItems.axonium, 32));
            scaledHealth = 200;
            bullet = WBullets.axoniumWallBullet;
            bullets = 12;
            size = 2;
            chanceDeflect = 0.3f;
        }};

        axoniumWallHuge = new BulletWall("axonium-wall-huge"){{
            requirements(defense, with(WItems.axonium, 72));
            scaledHealth = 200;
            bullet = WBullets.axoniumWallBullet;
            bullets = 12;
            size = 3;
            chanceDeflect = 0.3f;
        }};

        disposableWall = new DisposableWall("disposable-wall"){{
            requirements(defense, with(WItems.axonium, 8, terron, 6, notanium, 6));
            scaledHealth = 320;
            explosion(24, 8, Fx.massiveExplosion);
            size = 1;
        }};

        disposableWallLarge = new DisposableWall("disposable-wall-large"){{
            requirements(defense, mult(disposableWall.requirements, 4));
            scaledHealth = 320;
            explosion(24, 8, Fx.massiveExplosion);
            size = 2;
        }};

        disposableWallHuge = new DisposableWall("disposable-wall-huge"){{
            requirements(defense, mult(disposableWall.requirements, 9));
            scaledHealth = 320;
            explosion(24, 8, Fx.massiveExplosion);
            size = 3;
        }};

        // distribution
        axoBridge = new BufferedItemBridge("axo-bridge"){{
            requirements(distribution, with(WItems.axonium, 6), true);
            squareSprite = fadeIn = moveArrows = false;
            range = 6;
            speed = 50f;
            arrowSpacing = 6f;
            bufferCapacity = 24;
        }};

        terronBridge = new BufferedItemBridge("terron-bridge"){{
            requirements(distribution, with(WItems.terron, 6, axonium, 3));
            squareSprite = fadeIn = moveArrows = false;
            range = 9;
            speed = 85f;
            arrowSpacing = 6f;
            bufferCapacity = 16;
        }};

        axoRouter = new Router("axo-router"){{
            requirements(distribution, with(axonium, 3));
            buildCostMultiplier = 3.5f;
        }};

        axoSorter = new AxoSorter("axo-sorter"){{
            requirements(Category.distribution, with(axonium, 5, notanium, 3));
            buildCostMultiplier = 3.5f;
        }};

        axoGate = new AxoGate("axo-gate"){{
            requirements(Category.distribution, with(Items.lead, 2, Items.copper, 4, notanium, 3));
            buildCostMultiplier = 3f;
        }};

        // production
        miniBore = new Drill("mini-bore"){{
            requirements(Category.production, with(Items.copper, 12), true);
            tier = 1;
            drawRim = drawSpinSprite = false;
            drillTime = 600/4*1.75f;
            size = 1;
        }};
    }
}