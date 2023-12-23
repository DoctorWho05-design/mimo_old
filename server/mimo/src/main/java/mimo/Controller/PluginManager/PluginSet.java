package mimo.Controller.PluginManager;

import java.util.HashSet;
import mimo.Mimo;

public class PluginSet extends HashSet<Plugin>{

    public void startPlugins() {
        Mimo.DEBUGER.startMethod("startPlugin()");
        for (Plugin plugin : this) {
            
        }
    }

    public void runPlugins() {
        Mimo.DEBUGER.startMethod("runPlugin()");
        for (Plugin plugin : this) {
            
        }
    }
}
