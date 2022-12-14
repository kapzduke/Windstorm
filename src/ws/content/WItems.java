package ws.content;

import arc.struct.*;
import arc.graphics.*;
import mindustry.type.*;

public class WItems {

	public static Item terron, axonium, ectonite, notanium, chasmium;
	public static Liquid destorus;
	public static Seq<Item> windstItems = new Seq<>();

	public static void load() {

        axonium = new Item("axonium", Color.valueOf("ff795e")) {{cost = 0.7f; hardness = 1; alwaysUnlocked = true; }};
		terron = new Item("terron", Color.valueOf("ffcd66")) {{cost = 1f; hardness = 1; alwaysUnlocked = true;}};
		notanium = new Item("notanium", Color.valueOf("8aa3f4"))  {{cost = 1.5f;}};
		chasmium = new Item("chasmium", Color.valueOf("84f491")) {{cost = 2.75f;}};
        ectonite = new Item("ectonite", Color.valueOf("a387ea")) {{cost = 2.75f;}};
        
		// todo
		destorus = new Liquid("destorus", Color.white){{
			heatCapacity = 0.4f;
            boilPoint = 5f;
            gasColor = Color.grays(0.9f);
		}};
		
        windstItems.addAll(terron, axonium, ectonite, notanium, chasmium);
	}
}