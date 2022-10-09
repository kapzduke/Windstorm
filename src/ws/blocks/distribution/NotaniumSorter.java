package ws.blocks.distribution;

import arc.scene.ui.layout.*;
import mindustry.gen.*;
import mindustry.world.blocks.distribution.*;

public class NotaniumSorter extends Sorter {

    public NotaniumSorter(String name) {
        super(name);
        configurable = true;
    }
    
    public class NotaniumSorterBuild extends SorterBuild {
        public void buildConfiguration(Table t){
            super.buildConfiguration(t);
            t.button(Icon.up, () -> {
                invert = false;
            });
            t.button(Icon.down, () -> {
                invert = true;
            });
        }
    }
}
