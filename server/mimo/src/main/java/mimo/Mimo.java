package mimo;

import debug.ControllerDebug;
import mimo.Controller.Controller;

public class Mimo {
    private Controller mController;
    public static final ControllerDebug DEBUGER = new ControllerDebug(true);

    public Mimo() {
        initMimo();
    }

    private void initMimo() {
        mController = new Controller(); 
    }

    //! Main Method
    public static void main(String[] args) {
        new Mimo();
    }
}