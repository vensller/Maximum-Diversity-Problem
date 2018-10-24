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
        if( argumentos.length != 8 && argumentos.length != 9 ){
            throw new IllegalArgumentException("Número de parâmetros errado: " + argumentos.length );
        }
        this.argumentos = argumentos;
    }
    
    public void processarArgumentos(){
        for (int i = 0; i < argumentos.length; i++) {
            if( argumentos[ i ].equals( "--arq" ) ){
                caminhoArquivo = argumentos[ i+1 ];
            }else if( argumentos[ i ].equals( "--nr" ) ){
                try{
                    numeroRepeticoes = Integer.parseInt( argumentos[ i+1 ] );
                }catch (NumberFormatException ex){
                    System.out.println("Valor após --nr não um valor númerico inteiro.");
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
                try{
                    csLocal = new GulosoPonderado(
                         0 , Double.parseDouble( argumentos[i+1] )
                    );
                }catch (NumberFormatException ex ){
                    throw new IllegalArgumentException("Valor após --const gp não é númerico");
                }
                break;
            case "kg":
                try{
                    csLocal = new KGuloso(
                         0 , Integer.parseInt(argumentos[i+1])
                    );
                }catch (NumberFormatException ex ){
                    throw new IllegalArgumentException("Valor após --const kp não é númerico");
                }
                break;
            case "kgp":
                try{
                    csLocal = new KGulosoProbabilistico(
                         0 , Integer.parseInt(argumentos[i+1])
                    );
                }catch (NumberFormatException ex ){
                    throw new IllegalArgumentException("Valor após --const kgp não é númerico");
                }
                break;
            case "ag":
                try{
                    csLocal = new AlfaGuloso(
                         0 , Double.parseDouble(argumentos[i+1])
                    );
                }catch (NumberFormatException ex ){
                    throw new IllegalArgumentException("Valor após --const ag não é númerico");
                }
                break;
            case "agp":
                try{
                    csLocal = new AlfaGulosoProbabilistico(
                         0 , Double.parseDouble(argumentos[i+1])
                    );
                }catch (NumberFormatException ex ){
                    throw new IllegalArgumentException("Valor após --const agp não é númerico");
                }
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
    
}
