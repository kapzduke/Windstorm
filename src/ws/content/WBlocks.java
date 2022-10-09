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
import multicraft.*;
import static multicraft.IOEntry.*;
import ws.blocks.defense.*;
import ws.blocks.distribution.*;

import static mindustry.type.Category.*;
import static mindustry.type.ItemStack.*;
import static ws.content.WItems.*;

public class WBlocks {
	public static Block
    // start
    start,
    // environment
    oreAxonium, oreTerron, oreChasmium,
    baroniteWall, baronite, lasiniteWall, lasinite, hafiniteWall, hafinite, ossodiumWall, ossodium,
    // crafters
    notaniumForge, ectoniteSmelter,
    // defense
    axoniumWall, axoniumWallLarge, axoniumWallHuge,
    notaniumWall, notaniumWallLarge, notaniumWallHuge,
    disposableWall, disposableWallLarge, disposableWallHuge,
    // distribution
    axoBridge, terronBridge, axoRouter, notaniumSorter, notaniumGate, notaniumDistributor
    // production
    ;

    public static void load(){
        // start
        start = new Block("start"){{
			buildVisibility = BuildVisibility.debugOnly;
			inEditor = false;
			alwaysUnlocked = true;
		}};

        // environment
        oreAxonium = new OreBlock(axonium){{
            variants = 3;
        }};

        oreTerron = new OreBlock(terron){{
            variants = 3;
        }};

        oreChasmium = new OreBlock(chasmium){{
            variants = 3;
        }};

        baroniteWall = new StaticWall("baronite-wall"){{
            variants = 3;
        }};

        lasiniteWall = new StaticWall("lasinite-wall"){{
            variants = 3;
        }};

        hafiniteWall = new StaticWall("hafinite-wall"){{
            variants = 3;
        }};

        ossodiumWall = new StaticWall("ossodium-wall"){{
            variants = 3;
        }};

        baronite = new Floor("baronite"){{
            variants = 3;
            wall = baroniteWall;
        }};

        lasinite = new Floor("lasinite"){{
            variants = 3;
            wall = lasiniteWall;
        }};

        hafinite = new Floor("hafinite"){{
            variants = 3;
            wall = hafiniteWall;
        }};

        ossodium = new Floor("ossodium"){{
            variants = 3;
            wall = ossodiumWall;
        }};
        // crafters
        // todo small/large factories
        notaniumForge = new MultiCrafter("notanium-forge") {{
            requirements(crafting, with(axonium, 32, terron, 28));
            size = 3;
            resolvedRecipes = Seq.with(
                // why
                new Recipe(
                    new IOEntry(
                        Seq.with(ItemStack.with(
                            axonium, 1,
                            terron, 1
                        )),
                        Seq.with(LiquidStack.with()),
                        2.4f
                    ),
                    new IOEntry(
                        Seq.with(ItemStack.with(
                            notanium, 1
                        )),
                        Seq.with(LiquidStack.with())
                    ),
                    120f
                ),
                new Recipe(
                    new IOEntry(
                        Seq.with(ItemStack.with(
                            axonium, 4,
                            terron, 3
                        )),
                        Seq.with(LiquidStack.with()),
                        4.25f
                    ),
                    new IOEntry(
                        Seq.with(ItemStack.with(
                            notanium, 3
                        )),
                        Seq.with(LiquidStack.with())
                    ),
                    120f
                )
            );
        }};

        ectoniteSmelter = new MultiCrafter("ectonite-smelter") {{
            requirements(crafting, with(axonium, 64, terron, 56, notanium, 22));
            size = 4;
            resolvedRecipes = Seq.with(
                // why
                new Recipe(
                    new IOEntry(
                        Seq.with(ItemStack.with(
                            terron, 3,
                            chasmium, 2
                        )),
                        Seq.with(LiquidStack.with()),
                        2.4f
                    ),
                    new IOEntry(
                        Seq.with(ItemStack.with(
                            ectonite, 2
                        )),
                        Seq.with(LiquidStack.with())
                    ),
                    60 * 5
                ),
                new Recipe(
                    new IOEntry(
                        Seq.with(ItemStack.with(
                            terron, 5,
                            chasmium, 3
                        )),
                        Seq.with(LiquidStack.with()),
                        4.5f
                    ),
                    new IOEntry(
                        Seq.with(ItemStack.with(
                            ectonite, 4
                        )),
                        Seq.with(LiquidStack.with())
                    ),
                    60 * 5
                )
            );
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

        notaniumWall = new BulletWall("notanium-wall"){{
            requirements(defense, with(notanium, 8));
            scaledHealth = 475;
            bullet = WBullets.notaniumWallBullet;
            bullets = 18;
            size = 1;
        }};

        notaniumWallLarge = new BulletWall("notanium-wall-large"){{
            requirements(defense, mult(with(notanium, 8), 4));
            scaledHealth = 475;
            bullet = WBullets.notaniumWallBullet;
            bullets = 18;
            size = 2;
        }};

        notaniumWallHuge = new BulletWall("notanium-wall-huge"){{
            requirements(defense, mult(with(notanium, 8), 9));
            scaledHealth = 475;
            bullet = WBullets.notaniumWallBullet;
            bullets = 18;
            size = 3;
        }};

        disposableWall = new DisposableWall("disposable-wall"){{
            requirements(defense, with(WItems.axonium, 8, terron, 6, notanium, 6));
            scaledHealth = 320;
            explosion(24, 80, Fx.massiveExplosion);
            size = 1;
        }};

        disposableWallLarge = new DisposableWall("disposable-wall-large"){{
            requirements(defense, mult(disposableWall.requirements, 4));
            scaledHealth = 320;
            explosion(24, 80*2, Fx.massiveExplosion);
            size = 2;
        }};

        disposableWallHuge = new DisposableWall("disposable-wall-huge"){{
            requirements(defense, mult(disposableWall.requirements, 9));
            scaledHealth = 320;
            explosion(24, 80*3, Fx.massiveExplosion);
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
        // todo terron router
        notaniumSorter = new NotaniumSorter("axo-sorter"){{
            requirements(Category.distribution, with(notanium, 6));
            buildCostMultiplier = 3.5f;
        }};

        notaniumGate = new NotaniumGate("axo-gate"){{
            requirements(Category.distribution, with(notanium, 5, axonium, 4));
            buildCostMultiplier = 3.5f;
        }};

        notaniumDistributor = new Router("notanium-distributor"){{
            requirements(Category.distribution, mult(with(notanium, 5, axonium, 4), 4));
        }};

    }
}