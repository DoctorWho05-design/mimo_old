package mimo.Controller.PluginController;

import java.util.HashMap;

import mimo.Mimo;

public class PluginMap extends HashMap<String, Plugin>{
    public void startPlugins() {
        Mimo.DEBUGER.startMethod("startPlugin()");
        this.forEach((k,v) -> handleStart(k, v));
    }

    private void handleStart(String mKey, Plugin mPlugin) {
        mPlugin.start();
    }

    public void runPlugins() {
        Mimo.DEBUGER.startMethod("runPlugin()");
        this.forEach((k,v) -> handleRun(k, v));
    }

    private void handleRun(String mKey, Plugin mPlugin) {
        mPlugin.run();
    }
}
