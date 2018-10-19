package Utilities;

public class QuickSort {
    
    public static void ordenar(double[][] matriz, int inicio, int fim) {
        int posicaoPivo;
        if (inicio < fim) {
            posicaoPivo = separar(matriz, inicio, fim);
            ordenar(matriz, inicio, posicaoPivo - 1);
            ordenar(matriz, posicaoPivo + 1, fim);
        }
    }

    private static int separar(double[][] matriz, int inicio, int fim) {
        double indicePivo = matriz[inicio][0];
        double pivo = matriz[inicio][1];
        int i = inicio + 1, f = fim;
        
        while (i <= f) {
            if (matriz[i][1] >= pivo) {
                i++;
            } else if (pivo > matriz[f][1]) {
                f--;
            } else {
                double troca;
                troca = matriz[i][0];
                matriz[i][0] = matriz[f][0];
                matriz[f][0] = troca;
                
                troca = matriz[i][1];
                matriz[i][1] = matriz[f][1];
                matriz[f][1] = troca;
                
                i++;
                f--;
            }
        }
        matriz[inicio][0] = matriz[f][0];
        matriz[f][0] = indicePivo;
        matriz[inicio][1] = matriz[f][1];
        matriz[f][1] = pivo;
        return f;
    }
}
