package AK_NN_3D;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Principal extends JFrame {
    private Object[][] xyC = {
        {1.0, 1.0, 1.0, "Rojo"},
        {1.1, 1.1, 1.1, "Rojo"},
        {1.2, 1.2, 1.2, "Rojo"},
        {1.3, 1.3, 1.3, "Rojo"},
        {2.0, 2.0, 2.0, "Azul"},
        {2.1, 2.1, 2.1, "Azul"},
        {2.2, 2.2, 2.2, "Azul"},
        {2.3, 2.3, 2.3, "Azul"},
        {3.0, 3.0, 3.0, "Verde"},
        {3.1, 3.1, 3.1, "Verde"},
        {3.2, 3.2, 3.2, "Verde"},
        {3.3, 3.3, 3.3, "Verde"},
        {4.0, 4.0, 4.0, "Rosa"},
        {4.1, 4.1, 4.1, "Rosa"},
        {4.2, 4.2, 4.2, "Rosa"},
        {4.3, 4.3, 4.3, "Rosa"},
        {5.0, 5.0, 5.0, "Naranja"},
        {5.1, 5.1, 5.1, "Naranja"},
        {5.2, 5.2, 5.2, "Naranja"},
        {5.3, 5.3, 5.3, "Naranja"}
    };
    private String s;

    public Principal(String s) {
        this.s = s;
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    public Principal(){
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    private void menuPrincipal(){
        if(s.equals("Euclidiana"))
            menuEuclidiana("Euclidiana");
        else if(s.equals("Manhattan"))
            menuManhattan("Manhattan");
        else if(s.equals("Minkowski"))
            menuMinkowski("Minkowski");
        else
            menuChebyshev("Chebyshev");
    }
    
    private void menuChebyshev(String s){
        String c = combo.getSelectedItem().toString();
        //System.out.println(s);
        switch(c){
            case "Muestra por defecto":
                new Plano(xyC, s);
                this.dispose();
            break;
            case "Muestra aleatoria":
                new PrincipalAleatorios(s);
                this.dispose();
            break;
            default:
                this.dispose();
            break;
        }
    }
    
    private void menuMinkowski(String s){
        String c = combo.getSelectedItem().toString();
        //System.out.println(s);
        switch(c){
            case "Muestra por defecto":
                new Plano(xyC, s);
                this.dispose();
            break;
            case "Muestra aleatoria":
                new PrincipalAleatorios(s);
                this.dispose();
            break;
            default:
                this.dispose();
            break;
        }
    }
    
    private void menuEuclidiana(String s){
        String c = combo.getSelectedItem().toString();
        //System.out.println(s);
        switch(c){
            case "Muestra por defecto":
                new Plano(xyC, s);
                this.dispose();
            break;
            case "Muestra aleatoria":
                new PrincipalAleatorios(s);
                this.dispose();
            break;
            default:
                this.dispose();
            break;
        }
    }
    
    private void menuManhattan(String s){
        String c = combo.getSelectedItem().toString();
        //System.out.println(s);
        switch(c){
            case "Muestra por defecto":
                new Plano(xyC, s);
                this.dispose();
            break;
            case "Muestra aleatoria":
                new PrincipalAleatorios(s);
                this.dispose();
            break;
            default:
                this.dispose();
            break;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl1 = new javax.swing.JPanel();
        txtT = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnGenerar = new javax.swing.JButton();
        combo = new javax.swing.JComboBox<>();
        btnRe = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu principal");

        pnl1.setBackground(new java.awt.Color(255, 204, 153));

        txtT.setText("Algoritmo KNN");
        txtT.setMinimumSize(new java.awt.Dimension(82, 40));
        txtT.setPreferredSize(new java.awt.Dimension(82, 40));
        pnl1.add(txtT);

        jPanel1.setBackground(new java.awt.Color(255, 255, 102));

        btnGenerar.setBackground(new java.awt.Color(153, 255, 204));
        btnGenerar.setText("Generar");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Muestra aleatoria", "Muestra por defecto" }));
        combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActionPerformed(evt);
            }
        });

        btnRe.setText("Regresar");
        btnRe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRe))
                    .addComponent(combo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGenerar)
                    .addComponent(btnRe))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboActionPerformed

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        menuPrincipal();
    }//GEN-LAST:event_btnGenerarActionPerformed

    private void btnReActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReActionPerformed
        new Principal3D();
        this.dispose();
    }//GEN-LAST:event_btnReActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerar;
    private javax.swing.JButton btnRe;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pnl1;
    private javax.swing.JLabel txtT;
    // End of variables declaration//GEN-END:variables
}
