package ws.blocks.distribution;

import arc.scene.ui.layout.*;
import mindustry.gen.*;
import mindustry.world.blocks.distribution.*;

public class AxoSorter extends Sorter {

    public AxoSorter(String name) {
        super(name);
        configurable = true;
    }
    
    public class AxoSorterBuild extends SorterBuild {
        public void buildConfiguration(Table t){
            t.button(Icon.up, () -> {
                invert = false;
            });
            t.button(Icon.down, () -> {
                invert = true;
            });
        }
    }
}
