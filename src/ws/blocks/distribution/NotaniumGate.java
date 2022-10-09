package ws.blocks.distribution;

import arc.scene.ui.layout.*;
import mindustry.gen.*;
import mindustry.world.blocks.distribution.*;

public class NotaniumGate extends OverflowGate {

    public NotaniumGate(String name) {
        super(name);
        configurable = true;
    }
    
    public class NotaniumGateBuild extends OverflowGateBuild {
        public void buildConfiguration(Table t){
            t.button(Icon.add, () -> {
                invert = !invert;
            });
        }
    }
}