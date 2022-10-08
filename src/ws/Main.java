
package ws;
import mindustry.mod.*;
import ws.content.*;

public class Main extends Mod {
    @Override
    public void loadContent(){
        WBullets.load();
        WItems.load();
        WBlocks.load();
        WTree.load();
    }
}
