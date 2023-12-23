package mimo;

import mimo.Controller.Controller;

public class Mimo {
    private Controller mController;

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