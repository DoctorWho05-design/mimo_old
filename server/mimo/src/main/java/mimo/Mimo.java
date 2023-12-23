package mimo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

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
        mControllerDebug = new ControllerDebug(false);
    }


    //! Main Method
    public static void main(String[] args) {
        new Mimo();
    }
}