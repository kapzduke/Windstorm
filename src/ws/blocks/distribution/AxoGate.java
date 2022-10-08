package ws.blocks.distribution;

import arc.scene.ui.layout.*;
import mindustry.gen.*;
import mindustry.world.blocks.distribution.*;

public class AxoGate extends OverflowGate {

    public AxoGate(String name) {
        super(name);
        configurable = true;
    }
    
    public class AxoGateBuild extends OverflowGateBuild {
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