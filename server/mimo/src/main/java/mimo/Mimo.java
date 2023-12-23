package mimo;

import debug.ControllerDebug;
import mimo.Controller.Controller;

public class Mimo {
    private Controller mController;
    private ControllerDebug mControllerDebug;

    public Mimo() {
        initMimo();
    }

    private void initMimo() {
        mController = new Controller();
        mControllerDebug = new ControllerDebug(true);
    }


    //! Main Method
    public static void main(String[] args) {
        new Mimo();
    }
}