package plugins.Satisfactory;

import mimo.Mimo;
import mimo.Controller.PluginManager.Plugin;

public class Satisfactory extends Plugin{

    
    public Satisfactory() {
        super("Satisfactory");
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
