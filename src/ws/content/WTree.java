package ws.content;

import arc.struct.*;
import arc.util.*;
import mindustry.content.*;
import mindustry.entities.bullet.*;
import mindustry.game.Objectives.*;
import mindustry.type.*;
import mindustry.type.unit.*;

import static ws.content.WBlocks.*;
import static ws.content.WItems.*;
import static mindustry.content.TechTree.*;

public class WTree{
	
	public static void load(){	
		nodeRoot("windst", start, () -> {
			// items
			nodeProduce(axonium, () -> {
				nodeProduce(terron, Seq.with(new Produce(axonium)), () -> {});
				nodeProduce(notanium, Seq.with(new Produce(axonium)), () -> {
					nodeProduce(ectonite, Seq.with(new Produce(notanium)), () -> {});
					nodeProduce(chasmium, Seq.with(new Produce(notanium)), () -> {});
				});
			});

			// blocks
			// defense
			node(axoniumWall, () -> {
				node(axoniumWallLarge, () -> {
					node(axoniumWallHuge); // todo notanium walls
				});
				node(disposableWall, () -> {
					node(disposableWallLarge, () -> {
						node(disposableWallHuge);
					});
				});
			});

			// distribution
			node(axoBridge, () -> {
				node(axoRouter);
				node(axoSorter, () -> {
					node(axoGate);
					node(terronBridge);
				});
			});

            // production
            node(miniBore, () -> {
                // todo notanium bore
            });

        });
    }
}