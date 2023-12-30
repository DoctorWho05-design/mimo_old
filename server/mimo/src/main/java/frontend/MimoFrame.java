package frontend;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import frontend.Panels.MainScreen;
import java.awt.Dimension;

public class MimoFrame extends JFrame{

    public MimoFrame() {
        initMimoFrame();
    }

    private void initMimoFrame() {
        this.setIconImage(new ImageIcon("/public/Mimo.png").getImage());
        this.setTitle("Mimo");
        this.setSize(new Dimension(1400, 700));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        setStartScreen();
    }

    public void setStartScreen() {
        this.setContentPane(new MainScreen());
    }
}
