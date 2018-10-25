package Utilities;

import Estrategias.Aleatorio;
import Estrategias.AlfaGuloso;
import Estrategias.AlfaGulosoProbabilistico;
import Estrategias.ConstructionStrategy;
import Estrategias.Guloso;
import Estrategias.GulosoPonderado;
import Estrategias.KGuloso;
import Estrategias.KGulosoProbabilistico;
import SearchStrategy.BestImprovementSearch;
import SearchStrategy.FirstImprovementSearch;
import SearchStrategy.SearchStrategy;

public class LeitorArgumentos {
    
    private String argumentos[];
    
    private String caminhoArquivo;
    private ConstructionStrategy constructionStrategy;
    private SearchStrategy searchStrategy;
    private int numeroRepeticoes;
    
    public LeitorArgumentos(String[] argumentos) {
        if( argumentos.length != 7 && argumentos.length != 9 ){
            throw new IllegalArgumentException("Número de parâmetros errado: " + argumentos.length );
        }
        this.argumentos = argumentos;
    }
    
    public void processarArgumentos(){
        caminhoArquivo = argumentos[ 0 ];
        for (int i = 1; i < argumentos.length; i++) {
            if( argumentos[ i ].equals( "--nr" ) ){
                try{
                    numeroRepeticoes = Integer.parseInt( argumentos[ i+1 ] );
                }catch (NumberFormatException ex){
                    System.out.println("Valor após --nr não é um valor númerico inteiro.");
                }
            }else if( argumentos[ i ].equals( "--const" ) ){
                constructionStrategy = buscarConstructionStrategy( i+1 );
            }else if( argumentos[ i ].equals( "--search" ) ){
                searchStrategy = buscarSearchStrategy( i+1 );
            }
        }
    }

    private SearchStrategy buscarSearchStrategy(int i) {
        SearchStrategy ssLocal;
        switch ( argumentos[ i ] ){
            case "bis":
                ssLocal = new BestImprovementSearch();
                break;
            case "fis":
                ssLocal = new FirstImprovementSearch();
                break;
            default:
                throw new IllegalArgumentException("Valor para --search não encontrado");
        }
        return ssLocal;
    }

    private ConstructionStrategy buscarConstructionStrategy(int i) {
        ConstructionStrategy csLocal;
        switch ( argumentos[ i ] ){
            case "a":
                csLocal = new Aleatorio( 0 );
                break;
                
            case "g":
                csLocal = new Guloso( 0 );
                break;
                
            case "gp":
                csLocal = new GulosoPonderado( 0 , buscarArgumentoP( i+1 ) );
                break;
                
            case "kg":
                csLocal = new KGuloso( 0 , buscarArgumentoK(i+1) );
                break;
                
            case "kgp":
                csLocal = new KGulosoProbabilistico( 0 , buscarArgumentoK( i+1 ) );
                break;
                
            case "ag":
                csLocal = new AlfaGuloso( 0 , buscarArgumentoP( i+1 ) );
                break;
                
            case "agp":
                csLocal = new AlfaGulosoProbabilistico( 0 , buscarArgumentoP( i+1 ) );
                break;
                
            default:
                throw new IllegalArgumentException("Valor para --const não encontrado");
        }
        return csLocal;
    }

    public String getCaminhoArquivo() {
        return caminhoArquivo;
    }

    public ConstructionStrategy getConstructionStrategy() {
        return constructionStrategy;
    }

    public SearchStrategy getSearchStrategy() {
        return searchStrategy;
    }

    public int getNumeroRepeticoes() {
        return numeroRepeticoes;
    }

    private double buscarArgumentoP(int posicao) {
        double d;
        if( argumentos[posicao].equals("--p") ){
            try{
                d = Double.parseDouble(argumentos[posicao+1]);
            }catch (NumberFormatException ex ){
                throw new IllegalArgumentException("Valor após --p não é númerico");
            }
        }else{
            throw new IllegalArgumentException("Argumento --p não foi encontrado");
        }
        return d;
    }
    
    private int buscarArgumentoK(int posicao) {
        int i;
        if( argumentos[posicao].equals("--k") ){
            try{
                i = Integer.parseInt(argumentos[posicao+1]);
            }catch (NumberFormatException ex ){
                throw new IllegalArgumentException("Valor após --k não é númerico");
            }
        }else{
            throw new IllegalArgumentException("Argumento --k não foi encontrado");
        }
        return i;
    }
    
}
