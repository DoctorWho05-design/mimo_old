package plugins.NexusChronicals;

import mimo.Mimo;
import mimo.Controller.Data;
import mimo.Controller.Plugin.Plugin;

public class NexusChronicals extends Plugin{

    public NexusChronicals() {
        super("NexusChronicals", false);
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
