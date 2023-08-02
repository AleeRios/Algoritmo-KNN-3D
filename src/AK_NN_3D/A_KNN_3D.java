package AK_NN_3D;

import java.util.Arrays;

public class A_KNN_3D{
    private Object[][] xyC;
    private int k;
    private Object[][] dis = null;
    
    public A_KNN_3D(Object[][] xyC, int k){
        this.xyC = xyC;
        this.k = k;
    }
    
    public Object[][] getXYC(){
        return this.xyC;
    }
    
    private double mayor(double x, double y, double z){
        if(x > y && x > z)
            return x;
        else if(y > x && y > z)
            return y;
        else
            return z;
    }
    
    private double distanciaChebyshev(double xi, double xj, double yi, double yj, double zi, double zj){
        double x = Math.abs(xj - xi);
        double y = Math.abs(yj - yi);
        double z = Math.abs(zj - zi);
        return mayor(x, y, z);
    }
    
    private Object[][] agregarDistanciaChebyshev(Object[][] dist, double xi, double xj, double yi, double yj, double zi, double zj, String c){
        double d;
        if(dist == null){
            d = distanciaChebyshev(xi, xj, yi, yj, zi, zj);
            Object[][] aux = {{d,c}};
            return aux;
        }else{
            Object[][] aux = new Object[dist.length+1][dist[0].length];
            for(int i=0; i<dist.length; i++)
                for(int j=0; j<dist[0].length; j++)
                    aux[i][j] = dist[i][j];
            //d = distancia(xi, xj, yi, yj);
            aux[aux.length-1][0] = distanciaChebyshev(xi, xj, yi, yj, zi, zj);
            aux[aux.length-1][1] = c;
            return aux;
        }
    }
    
    public void calcularDistanciasChebyshev(double xi, double yi, double zi){
        for(int i=0; i<xyC.length; i++){
            double xj = (double)xyC[i][0];
            double yj = (double)xyC[i][1];
            double zj = (double)xyC[i][2];
            String c = (String)xyC[i][3];
            dis = agregarDistanciaChebyshev(dis, xi, xj, yi, yj, zi, zj, c);
        }
        System.out.println(Arrays.deepToString(dis));
    }
    
    private double distanciaMinkowski(double xi, double xj, double yi, double yj, double zi, double zj, double pow){
        return Math.cbrt(Math.pow(Math.abs(xj - xi), pow) + Math.pow(Math.abs(yj - yi), pow) + Math.pow(Math.abs(zj - zi), pow));
    }
    
    private Object[][] agregarDistanciaMinkowski(Object[][] dist, double xi, double xj, double yi, double yj, double zi, double zj, double pow, String c){
        double d;
        if(dist == null){
            d = distanciaMinkowski(xi, xj, yi, yj, zi, zj, pow);
            Object[][] aux = {{d,c}};
            return aux;
        }else{
            Object[][] aux = new Object[dist.length+1][dist[0].length];
            for(int i=0; i<dist.length; i++)
                for(int j=0; j<dist[0].length; j++)
                    aux[i][j] = dist[i][j];
            //d = distancia(xi, xj, yi, yj);
            aux[aux.length-1][0] = distanciaMinkowski(xi, xj, yi, yj, zi, zj, pow);
            aux[aux.length-1][1] = c;
            return aux;
        }
    }
    
    public void calcularDistanciasMinkowski(double xi, double yi, double zi, double pow){
        for(int i=0; i<xyC.length; i++){
            double xj = (double)xyC[i][0];
            double yj = (double)xyC[i][1];
            double zj = (double)xyC[i][2];
            String c = (String)xyC[i][3];
            dis = agregarDistanciaMinkowski(dis, xi, xj, yi, yj, zi, zj, pow, c);
        }
        System.out.println(Arrays.deepToString(dis));
    }
    
    private double distanciaManhattan(double xi, double xj, double yi, double yj, double zi, double zj){
        return Math.abs(xj - xi) + Math.abs(yj - yi) + Math.abs(zj - zi);
    }
    
    private Object[][] agregarDistanciaManhattan(Object[][] dist, double xi, double xj, double yi, double yj, double zi, double zj, String c){
        double d;
        if(dist == null){
            d = distanciaManhattan(xi, xj, yi, yj, zi, zj);
            Object[][] aux = {{d,c}};
            return aux;
        }else{
            Object[][] aux = new Object[dist.length+1][dist[0].length];
            for(int i=0; i<dist.length; i++)
                for(int j=0; j<dist[0].length; j++)
                    aux[i][j] = dist[i][j];
            //d = distancia(xi, xj, yi, yj);
            aux[aux.length-1][0] = distanciaManhattan(xi, xj, yi, yj, zi, zj);
            aux[aux.length-1][1] = c;
            return aux;
        }
    }
    
    public void calcularDistanciasManhattan(double xi, double yi, double zi){
        for(int i=0; i<xyC.length; i++){
            double xj = (double)xyC[i][0];
            double yj = (double)xyC[i][1];
            double zj = (double)xyC[i][2];
            String c = (String)xyC[i][3];
            dis = agregarDistanciaManhattan(dis, xi, xj, yi, yj, zi, zj, c);
        }
        System.out.println(Arrays.deepToString(dis));
    }

    private double distanciaEuclidiana(double xi, double xj, double yi, double yj, double zi, double zj){
        return Math.sqrt(Math.pow(xj - xi, 2) + Math.pow(yj - yi, 2) + Math.pow(zj - zi, 2));
    }
    
    private Object[][] agregarDistanciaEuclidiana(Object[][] dist, double xi, double xj, double yi, double yj, double zi, double zj, String c){
        double d;
        if(dist == null){
            d = distanciaEuclidiana(xi, xj, yi, yj, zi, zj);
            Object[][] aux = {{d,c}};
            return aux;
        }else{
            Object[][] aux = new Object[dist.length+1][dist[0].length];
            for(int i=0; i<dist.length; i++)
                for(int j=0; j<dist[0].length; j++)
                    aux[i][j] = dist[i][j];
            //d = distancia(xi, xj, yi, yj);
            aux[aux.length-1][0] = distanciaEuclidiana(xi, xj, yi, yj, zi, zj);
            aux[aux.length-1][1] = c;
            return aux;
        }
    }
    
    public void calculaDistanciasEuclidiana(double xi, double yi, double zi){
        //System.out.println(Arrays.deepToString(xyC));
        for(int i=0; i<xyC.length; i++){
            double xj = (double)xyC[i][0];
            double yj = (double)xyC[i][1];
            double zj = (double)xyC[i][2];
            String c = (String)xyC[i][3];
            dis = agregarDistanciaEuclidiana(dis, xi, xj, yi, yj, zi, zj, c);
        }
        System.out.println(Arrays.deepToString(dis));
    }
    
    private double[] disMenores(){
        double[] aux = new double[dis.length];
        for(int i=0; i<dis.length; i++){
            aux[i] = (double)dis[i][0];
        }
        Arrays.sort(aux);
        return Arrays.copyOfRange(aux, 0, k);
    }
    
    public String identificarClase(){
        String[] c = new String[k];
        double[] menores = disMenores();
        System.out.println(Arrays.toString(menores));
        for(int i=0; i<dis.length; i++){
            for(int j=0; j<menores.length; j++){
                double d = (double)dis[i][0];
                if(menores[j] == d){
                   c[j] = (String)dis[i][1]; 
                }
            }
        }
        System.out.println(Arrays.toString(c));
        return moda(c);
    }
    
    private String moda(String[] arr){
        int azul = 0, verde = 0, rojo = 0, rosa = 0, naranja = 0;
        for(int i=0; i<arr.length; i++){
            switch(arr[i]){
                case "Azul" -> azul++;
                case "Verde" -> verde++;
                case "Rojo" -> rojo++;
                case "Rosa" -> rosa++;
                case "Naranja" -> naranja++;
                default -> System.exit(0);
            }
        }

        if(azul > verde && azul > rojo && azul > rosa && azul > naranja)
            return "Azul";
        else if(verde > azul && verde > rojo && verde > rosa && verde > naranja)
            return "Verde";
        else if(rojo > verde && rojo > azul && rojo > rosa && rojo > naranja)
            return "Rojo";
        else if(rosa > verde && rosa > azul && rosa > rojo && rosa > naranja)
            return "Rosa";
        else 
            return "Naranja";
    }
}