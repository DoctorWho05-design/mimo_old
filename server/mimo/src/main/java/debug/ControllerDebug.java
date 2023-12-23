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
    }
}
