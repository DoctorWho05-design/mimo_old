package plugins.GenshinImpact;

import mimo.Mimo;
import mimo.Controller.PluginManager.Plugin;

public class GenshinImpact extends Plugin{

    public GenshinImpact() {
        super("Genshin Impact");
    }

    @Override
    public void start() {
        
        Mimo.DEBUGER.startMethod(getPluginName() + " start()");
    }

    @Override
    public void run() {
        Mimo.DEBUGER.startMethod(getPluginName() + " run()");
    }
    
}
