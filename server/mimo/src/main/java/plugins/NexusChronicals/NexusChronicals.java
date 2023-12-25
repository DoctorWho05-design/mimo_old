package plugins.NexusChronicals;

import mimo.Mimo;
import mimo.Controller.PluginManager.Plugin;

public class NexusChronicals extends Plugin{

    public NexusChronicals() {
        super("NexusChronicals");
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
