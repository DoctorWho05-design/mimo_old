package plugins.Discord;

import mimo.Mimo;
import mimo.Controller.Data;
import mimo.Controller.Plugin.Plugin;

public class Discord extends Plugin{

    public Discord() {
        super("Discord");
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