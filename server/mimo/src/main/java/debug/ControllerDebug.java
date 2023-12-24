package debug;

public class ControllerDebug {
    private boolean mDebugMode;
    private DebugFrame mDebugFrame;

    public ControllerDebug(boolean mDebugMode) {
        initControllerDebug(mDebugMode);
    }

    private void initControllerDebug(boolean mDebugMode) {
        this.mDebugMode = mDebugMode;
        mDebugFrame = new DebugFrame();

        if (!mDebugMode) return;
        //! Start Debug Mode
        mDebugFrame.setVisible(true);
    }

    public void startMethod(String mMethodName) {
        if (!mDebugMode) return;
        System.out.println("Start Method: "+ mMethodName);
    }

    public void printToken(String mPluginName, String mTokenName, String mToken) {
        if (!mDebugMode) return;
        System.out.println(mPluginName + " " +mTokenName + "Token: " + mToken);
    }
}
