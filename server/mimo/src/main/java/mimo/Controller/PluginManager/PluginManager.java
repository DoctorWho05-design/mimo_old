package mimo.Controller.PluginManager;

import java.util.HashSet;
import java.util.Set;

public class PluginManager {
    private Set<Plugin> mPluginsSet;

    public PluginManager() {
        initPluginManager();
    }

    private void initPluginManager() {
        mPluginsSet = new HashSet<>();
    }


    public Set getPluginSet() {return mPluginsSet;}
}
