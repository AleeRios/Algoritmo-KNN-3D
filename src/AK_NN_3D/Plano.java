package AK_NN_3D;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import org.math.plot.*;
import java.util.*;

public class Plano{
    private JFrame frame; 
    private double n1, n2, n3;
    private JTextField txtX, txtY, txtZ, txtK, txtP;
    private JLabel txtC;
    private JButton btnG, btnR;
    private Plot2DPanel plot = new Plot2DPanel();
    private Plot3DPanel plot2 = new Plot3DPanel();
    private A_KNN_3D knn;
    private Object[][] xyC; 
    private String s;
    
    public Plano(){
        initComponents();
    }
    
    public Plano(Object[][] xyC, String s){
        this.xyC = xyC;
        this.s = s;
        initComponents();
        //txtP.setEditable(false);
    }
    
    private JPanel panelSur(){
        JPanel pS = new JPanel();
        pS.add(new JLabel("X: "));
        pS.add(txtX);
        pS.add(new JLabel("Y: "));
        pS.add(txtY);
        pS.add(new JLabel("Z: "));
        pS.add(txtZ);
        pS.add(new JLabel("k: "));
        pS.add(txtK);
        pS.add(new JLabel("Pow: "));
        pS.add(txtP);
        pS.add(new JLabel("Clase: "));
        pS.add(txtC);
        pS.add(btnG);
        pS.add(btnR);
        return pS;
    }
    
    private JPanel panelPrincipal(){
        JPanel pPri = new JPanel();
        BorderLayout bl = new BorderLayout();
        pPri.setLayout(bl);
        pPri.add(plot2, bl.CENTER);
        pPri.add(panelSur(), bl.SOUTH);
        return pPri;
    }
    
    private void btnGActionPerformed(ActionEvent ev){
        n1 = Double.parseDouble(txtX.getText());
        n2 = Double.parseDouble(txtY.getText());
        n3 = Double.parseDouble(txtZ.getText());
        
        if(txtK.getText().equals(""))
            knn = new A_KNN_3D(xyC, 3);
        else
            knn = new A_KNN_3D(xyC, Integer.parseInt(txtK.getText()));
     
        menu(knn, n1, n2, n3);
    }
    
    private void menu(A_KNN_3D knn, double n1, double n2, double n3){
        String c;
        Object[][] arrXY;
        
        switch(this.s){
            case "Euclidiana":
                System.out.println("Distancia Euclidiana 3D");
                knn.calculaDistanciasEuclidiana(n1, n2, n3);
                c = knn.identificarClase();
                txtC.setText(c);
                System.out.println(c);
                arrXY = agregar(xyC, n1, n2, n3, c);
                xyC = arrXY;
                plot2.removeAllPlots();
                idetificarColor(xyC);
            break;
            case "Manhattan":
                System.out.println("Distancia Manhattan 3D");
                knn.calcularDistanciasManhattan(n1, n2, n3);
                c = knn.identificarClase();
                txtC.setText(c);
                System.out.println(c);
                arrXY = agregar(xyC, n1, n2, n3, c);
                xyC = arrXY;
                plot2.removeAllPlots();
                idetificarColor(xyC);
            break;
            case "Minkowski":
                System.out.println("Distancia Minkowski 3D");
                double pow = Double.parseDouble(txtP.getText());
                knn.calcularDistanciasMinkowski(n1, n2, n3, pow);
                c = knn.identificarClase();
                txtC.setText(c);
                System.out.println(c);
                arrXY = agregar(xyC, n1, n2, n3, c);
                xyC = arrXY;
                plot2.removeAllPlots();
                idetificarColor(xyC);
            break;
            case "Chebyshev":
                System.out.println("Distancia Chebyshev 3D");
                knn.calcularDistanciasChebyshev(n1, n2, n3);
                c = knn.identificarClase();
                txtC.setText(c);
                System.out.println(c);
                arrXY = agregar(xyC, n1, n2, n3, c);
                xyC = arrXY;
                plot2.removeAllPlots();
                idetificarColor(xyC);
            break;
            default:
                frame.dispose();
            break;
        }
    }
    
    private void btnRActionPermormed(ActionEvent ev){
        new Principal3D();
        frame.dispose();
    }
    
    private Object[][] agregar(Object[][] arr, double v1, double v2, double v3, String c){
        Object[][] aux = new Object[arr.length+1][arr[0].length];
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                //System.out.println(arr[i][j]);
                aux[i][j] = arr[i][j];
            }
        }
        aux[aux.length-1][0] = v1;
        aux[aux.length-1][1] = v2;
        aux[aux.length-1][2] = v3;
        aux[aux.length-1][3] = c;
        return aux;
    }
    
    private double[][] agregarColor(double[][] arr, double v1, double v2, double v3){
        double[][] aux = new double[arr.length+1][arr[0].length];
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                aux[i][j] = arr[i][j];
            }
        }
        aux[aux.length-1][0] = v1;
        aux[aux.length-1][1] = v2;
        aux[aux.length-1][2] = v3;
        return aux;
    }
    
    private double[][] actualizarColor(double[][] color, double v1, double v2, double v3){
        if(color == null){
            double[][] aux = {{v1, v2, v3}};
            return aux;
        }else
            return agregarColor(color, v1, v2, v3);
        
    }
    
    private void idetificarColor(Object[][] arr){
        double[][] rojo = null;
        double[][] azul = null;
        double[][] verde = null;
        double[][] rosa = null;
        double[][] naranja = null;
        for(int i=0; i<arr.length; i++){
            String s = (String)(arr[i][3]);
            //System.out.println(s);
            switch(s){
                case "Rojo":
                    double x = (double)arr[i][0];
                    double y = (double)arr[i][1];
                    double z = (double)arr[i][2];
                    rojo = actualizarColor(rojo, x, y, z);
                break;
                case "Azul": 
                    double x2 = (double)arr[i][0];
                    double y2 = (double)arr[i][1];
                    double z2 = (double)arr[i][2];
                    azul = actualizarColor(azul, x2, y2, z2);
                break;
                case "Verde":
                    double x3 = (double)arr[i][0];
                    double y3 = (double)arr[i][1];
                    double z3 = (double)arr[i][2];
                    verde = actualizarColor(verde, x3, y3, z3);
                break;
                case "Rosa":
                    double x4 = (double)arr[i][0];
                    double y4 = (double)arr[i][1];
                    double z4 = (double)arr[i][2];
                    rosa = actualizarColor(rosa, x4, y4, z4);
                break;
                case "Naranja":
                    double x5 = (double)arr[i][0];
                    double y5 = (double)arr[i][1];
                    double z5 = (double)arr[i][2];
                    naranja = actualizarColor(naranja, x5, y5, z5);
                break;
                default: 
                break;
            }
        }
        
        if(rojo != null)
            plot2.addScatterPlot("",Color.red, rojo);
        else System.out.println("");
        
        if(azul != null)
            plot2.addScatterPlot("",Color.blue, azul);
        else System.out.println("");
        
        if(verde != null)
            plot2.addScatterPlot("",Color.green, verde);
        else System.out.println("");
        
        if(rosa != null)
            plot2.addScatterPlot("",Color.pink, rosa);
        else System.out.println("");
        
        if(naranja != null)
            plot2.addScatterPlot("", Color.orange, naranja);
        else System.out.println("");
    }
    
    private void initComponents(){
        txtX = new JTextField(8);
        txtY = new JTextField(8);
        txtZ = new JTextField(8);
        txtK = new JTextField(5);
        txtP = new JTextField(3);
        txtC = new JLabel("");
        btnG = new JButton("Graficar");
        btnR = new JButton("Menu");
        
        //plot2.addScatterPlot("", Color.green, x, y, z);
        idetificarColor(xyC);
        
        btnG.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev){
                btnGActionPerformed(ev);
            }
        });
        
        btnR.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev){
                btnRActionPermormed(ev);
            }
        });
        
        frame = new JFrame("Algoritmo KNN");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(780, 580);
        frame.add(panelPrincipal());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
}