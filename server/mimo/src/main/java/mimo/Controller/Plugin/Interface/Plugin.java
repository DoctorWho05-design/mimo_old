package mimo.Controller.Plugin.Interface;

public interface Plugin {
    public boolean start();
    public boolean run();
    public boolean stop();

    public void setPluginManager();
    public void callTest();
}
