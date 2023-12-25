package mimo.Controller.PluginManager;

import java.util.HashSet;
import mimo.Mimo;

class PluginSet extends HashSet<Plugin>{

    public void startPlugins() {
        Mimo.DEBUGER.startMethod("startPlugin()");
        for (Plugin plugin : this) {
            plugin.start();
        }
    }

    public void runPlugins() {
        Mimo.DEBUGER.startMethod("runPlugin()");
        for (Plugin plugin : this) {
            plugin.run();
        }
    }
}
