package debug;

import javax.swing.JFrame;
import java.awt.Dimension;

public class DebugFrame extends JFrame{
    private PluginTestPanel mPluginTestPanel;
    private Dimension mFrameSize;

    public DebugFrame() {
        initDebugFrame();
    }

    private void initDebugFrame() {
        mPluginTestPanel = new PluginTestPanel();
        mFrameSize = new Dimension(600, 400);

        this.add(mPluginTestPanel);
        this.setVisible(true);
        this.setSize(mFrameSize);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
