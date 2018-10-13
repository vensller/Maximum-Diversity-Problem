package model;

public class Instancia {
    
    public int n;
    public static int m;
    public static double[][] matriz = new double[1][1];

    public Instancia(int n, int m) {
        this.n = n;
        this.m = m;
        this.matriz = new double[n][n];
    }
}
