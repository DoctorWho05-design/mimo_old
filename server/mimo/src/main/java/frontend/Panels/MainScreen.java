package frontend.Panels;

import java.awt.Color;
import java.awt.Dimension;

public class MainScreen extends javax.swing.JPanel {

    public MainScreen() {
        initComponents();
        initMainScreen();
    }

    private void initMainScreen() {
        this.setSize(new Dimension(1400, 700));
        this.setBackground(Color.darkGray);
    }

    //! Generated Code (Do not change!)
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
