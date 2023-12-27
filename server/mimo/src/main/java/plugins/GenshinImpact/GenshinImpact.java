package plugins.GenshinImpact;

import mimo.Mimo;
import mimo.Controller.Data;
import mimo.Controller.PluginController.Plugin;

public class GenshinImpact extends Plugin{

    public GenshinImpact() {
        super("Genshin Impact", true);
    }

    @Override
    public void start() {
        
        Mimo.DEBUGER.startMethod(getPluginName() + " start()");
    }

    @Override
    public void run() {
        Mimo.DEBUGER.startMethod(getPluginName() + " run()");
    }

    @Override
    public void run(Data mData) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'run'");
    }
    
}
