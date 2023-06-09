/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package equiscero;

import java.awt.Color;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Jorge Hernandez
 */
public class JuegoGUI extends javax.swing.JFrame {

    UsuarioManager userManager;
    /**
     * Creates new form JuegoGUI
     */
    
    JButton casillas[][] = new JButton[3][3];
    boolean turnoX = true;
    public JuegoGUI(UsuarioManager manager) {
        userManager = manager;
        initComponents();
        
        for (int row =0;row<3;row++){
            for(int col = 0; col < 3;col++) {
                JButton boton = new JButton();
                //boton.setFont(new Font("Sans-Serif", Font.PLAIN, (int) (boton.getWidth() / 0.2)));
                //boton.setForeground(Color.BLACK);
                boton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        botonPresionado(e);
                    }
                });
                casillas[row][col] = boton;
                gameGrid.add(boton);
            }
        }
        
        gameGrid.repaint();
    }
    
    public void botonPresionado(ActionEvent e) {
        // Encontrar el boton presionado
        for (int row = 0; row<3;row++){
            for (int col = 0; col<3;col++) {
                if (casillas[row][col] == e.getSource()) {
                    if (!casillas[row][col].getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Seleccione una casilla vacia");
                        return;
                    }
                    
                    if (turnoX) casillas[row][col].setText("X");
                    else casillas[row][col].setText("0");
                };
            }
        }
        
        boolean ganador = comprobarGanador();
        String turno = (turnoX) ?"X":"0";
        if (ganador) {
            JOptionPane.showMessageDialog(null, "El ganador es jugador: " + turno);
            new menuDeJuego(userManager).setVisible(true);
            this.dispose();
        }
        
        if (estaLleno()) {
            JOptionPane.showMessageDialog(null, "El juego ha terminado en empate.");
            new menuDeJuego(userManager).setVisible(true);
            this.dispose();
        }
        turnoX = !turnoX;
    }
    
    public boolean estaLleno() {
        int apariciones = 0;
        for (int i = 0; i<3;i++) {
            for (int j =0; j<3;j++) {
                if (!casillas[i][j].getText().equals("")) apariciones++;
            }
        }
        
        if (apariciones == 9) return true;
        return false;
    }
    
    public boolean comprobarGanador() {
        // Comprobar columna 1
        
        String turnoActual = (turnoX) ?"X":"0";
        int apariciones = 0;
        
        for (int row = 0;row<3;row++){
            if (casillas[row][0].getText().equals(turnoActual)) apariciones++;
        }
        
        if (apariciones == 3) return true;
        
        // Comprobar coluna 2
        
        apariciones = 0;
        for (int row = 0;row<3;row++) {
            if (casillas[row][1].getText().equals(turnoActual)) apariciones++;
        }
        
        // Comprobar columna 3
        
        if (apariciones == 3) return true;
        apariciones = 0;
        for (int row = 0;row<3;row++) {
            if (casillas[row][2].getText().equals(turnoActual)) apariciones++;
        }
        
        if (apariciones == 3) return true;
                
        // Verificar horizontalmente
        
        apariciones = 0;
        
        for (int col = 0;col<3;col++){
            if (casillas[0][col].getText().equals(turnoActual)) apariciones++;
        }
        
        if (apariciones == 3) return true;
        
        apariciones= 0;
        
        for (int col = 0;col<3;col++){
            if (casillas[1][col].getText().equals(turnoActual)) apariciones++;
        }
        
        if (apariciones == 3) return true;
        
        apariciones = 0;
        
        for (int col = 0;col<3;col++){
            if (casillas[2][col].getText().equals(turnoActual)) apariciones++;
        }
     
        if (apariciones == 3) return true;
        
        // Comprobar diagonal
        
        apariciones = 0;
        
        for (int pos = 0; pos<3;pos++){
            if(casillas[pos][pos].getText().equals(turnoActual)) apariciones++;
        }
        
        if (apariciones == 3) return true;
        
        apariciones = 0;
        
        for (int row = 2; row>=0;row--){
            int col = Math.abs(row - 2);
            if(casillas[row][col].getText().equals(turnoActual)) apariciones++;
            
        }
        
        if (apariciones == 3) return true;
        
        return false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        gameGrid = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Equis Cero - Levi Ruiz | Jorge Hernandez");
        setMinimumSize(new java.awt.Dimension(800, 500));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("TURNO DE X");

        gameGrid.setLayout(new java.awt.GridLayout(3, 3, 1, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gameGrid, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(362, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(354, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(gameGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JuegoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JuegoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JuegoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JuegoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JuegoGUI(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel gameGrid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
