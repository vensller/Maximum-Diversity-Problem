
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeitorLog {
    
    private String texto;
    private List<Tupla> listaTuplas;
    private Map<String, List<Tupla> > hashMapTuplas = new HashMap<>();
    
    private int numeroRepiticoes;

    private String pasta;
    private String arquivoEstadoDaArte;
    private final String ARQ1 = "LogDeResultados1.csv";
    private final String ARQ2 = "LogDeResultados2.csv";
    private final String ARQ_FINAL = "tabela%.tex";
    private String sufixoArqFinal;

    public LeitorLog(String arquivo, int numeroRepiticoes, String arquivoEstadoDaArte, String sufixoArqFinal) {
        super();
        this.numeroRepiticoes = numeroRepiticoes;
        this.pasta = arquivo;
        this.arquivoEstadoDaArte = arquivoEstadoDaArte;
        this.sufixoArqFinal = sufixoArqFinal;
    }

    public void ler() {
        try {
            String linha;
            String[] valores;
            listaTuplas = new ArrayList<>();
            
            BufferedReader br = new BufferedReader(new FileReader(pasta+ARQ1));
            while ((linha = br.readLine()) != null) {
                valores = linha.split(";");
                listaTuplas.add(
                    new Tupla(
                        valores[0].substring( valores[0].lastIndexOf("/")+1, valores[0].length()),
                        Double.parseDouble(valores[1]),
                        Double.parseDouble(valores[2])
                    )
                );
            }
            br.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void separar(){
        hashMapTuplas = new HashMap<>();
        for( Tupla t: listaTuplas ){
            if( !hashMapTuplas.containsKey( t.getInstancia() ) ){
                List<Tupla> l = new ArrayList<>();
                l.add( t );
                hashMapTuplas.put(t.getInstancia(), l );
            }else{
                List<Tupla> l = hashMapTuplas.get( t.getInstancia() );
                l.add( t );
                hashMapTuplas.put( t.getInstancia(), l );
            }
        }
    }
    
    public void processar(){
        final String cabecalho =
            "\\begin{landscape}\n" +
            "\t\\begin{table}[ht]\n" +
            "\t\\centering\n" +
            "\t\\begin{tabular}{| c | r | r | r | r | r | r | r |  }\n" +
            "\\hline\n";
        
        final String rodape =
            "\\hline\n" +
            "\t\\end{tabular}\n" +
            "\t\\caption{Legenda da tabela}\n" +
            "\t\\label{seu_label}\n" +
            "\t\\end{table}\n" +
            "\\end{landscape}\n";
        
        texto = "Instancia&"
                + "Estado da Arte&"
                + "Melhor Solucao&"
                + "Desvio melhor&"
                + "Tempo do melhor&"
                + "Solucao Media&"
                + "Desvio medio&"
                + "Tempo Medio\\\\ \\hline \n";
        
        double estadoDaArte, melhorSolucao, desvioMelhor, 
            tempoDoMelhor = 0, solucaoMedia, desvioMedio, tempoMedio, aux;
        double[] medias = new double[7];
        String linha;
        for( String chave: hashMapTuplas.keySet() ){
            estadoDaArte = Double.parseDouble( 
                buscarEstadoDaArte(chave).replaceAll(",", ".") );
            
            melhorSolucao = Double.MIN_NORMAL;
            tempoMedio = 0;
            solucaoMedia = 0;
            linha = "";
            
            for( Tupla t: hashMapTuplas.get( chave ) ){
                aux = t.getSolucao();
                if( aux > melhorSolucao ){
                    melhorSolucao = aux;
                    tempoDoMelhor = t.getTempo();
                }
                solucaoMedia += aux;
                
                aux = t.getTempo();
                tempoMedio += aux;
            }
            medias[1] += melhorSolucao;
            medias[3] += tempoDoMelhor;
            medias[4] += solucaoMedia;
            
            solucaoMedia /= numeroRepiticoes;
            tempoMedio /= numeroRepiticoes;
            
            String f = "%.2f";
                linha = 
                    substiruirUnderscore(chave, "\\_") + "&" +
                    String.format(f, estadoDaArte ) + "&" +
                    String.format(f, melhorSolucao) + "&" + 
                    String.format(f, estadoDaArte-melhorSolucao) +"&" + 
                    String.format(f, tempoDoMelhor) + "&" +
                    String.format(f, solucaoMedia) + "&" + 
                    String.format(f, estadoDaArte-solucaoMedia) + "&" +
                    String.format(f, tempoMedio);
            texto += "\t\t" + linha + "\\\\\n";
        }
        texto = cabecalho + texto + rodape;
    }
    
    private String substiruirUnderscore(String s, String p){
        char c;
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt( i );
            if( c == '_'){
                str += p;
            }else{
                str += c;
            }
        }
        return str;
    }
    
    private String buscarEstadoDaArte(String buscado){
        String retorno = "";
        try {
            String linha;
            String[] valores;
            BufferedReader br = new BufferedReader(new FileReader(arquivoEstadoDaArte));
            while ((linha = br.readLine()) != null) {
                linha = linha.replaceAll(",", ";");
                valores = linha.split(";");
                if( buscado.equals( valores[0] ) ){
                    retorno = valores[1];
                    break;
                }
            }
            br.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return retorno;
    }
    
    public void escrever(){
        FileWriter writer;
        try {
            writer = new FileWriter(pasta + 
                ARQ_FINAL.replaceAll("%", "_" + sufixoArqFinal), false);
            writer.write(texto);
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private class Tupla {

        private String instancia;
        private double tempo;
        private double solucao;

        public Tupla() {
            super();
        }

        public Tupla(String instancia, double tempo, double solucao) {
            super();
            this.instancia = instancia;
            this.tempo = tempo;
            this.solucao = solucao;
        }

        public String getInstancia() {
            return instancia;
        }

        public void setInstancia(String instancia) {
            this.instancia = instancia;
        }

        public double getTempo() {
            return tempo;
        }

        public void setTempo(double tempo) {
            this.tempo = tempo;
        }

        public double getSolucao() {
            return solucao;
        }

        public void setSolucao(double solucao) {
            this.solucao = solucao;
        }

        @Override
        public String toString() {
            return "Tupla{" + "instancia=" + instancia + ", tempo=" + tempo + ", solucao=" + solucao + '}';
        }

    }

}
