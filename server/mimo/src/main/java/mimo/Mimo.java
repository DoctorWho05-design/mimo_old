package mimo;

import mimo.Controller.Controller;
import debug.ControllerDebug;

public class Mimo {
    
    private Controller mController;
    public static final ControllerDebug DEBUGER = new ControllerDebug(false);

    public Mimo() {
        initMimo();
    }

    //* initMethod (Only run once)
    private void initMimo() {
        mController = new Controller(); 
    }

    //! Main Method
    public static void main(String[] args) {
        new Mimo();
    }
}