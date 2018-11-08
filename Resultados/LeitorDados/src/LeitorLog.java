
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

    private String pasta;
    private final String ARQ1 = "LogDeResultados1.txt";
    private final String ARQ2 = "LogDeResultados2.txt";
    private final String ARQ_FINAL = "resultados.csv";

    private final String ARQUIVO = "Arquivo: ";
    private final String TEMPO = "Tempo total: ";
    private final String SOLUCAO = "Melhor solução: ";
    private final String LOG1 = "LogDeResultados1";
    private final String LOG2 = "LogDeResultados2";

    public LeitorLog(String arquivo) {
        super();
        this.pasta = arquivo;
    }

    public void ler() {
        try {
            boolean gravouInstancia = false, gravouTempo = false, gravouSolucao = false;
            String linha;
            Tupla tupla = new Tupla();
            listaTuplas = new ArrayList<>();
            
            BufferedReader br = new BufferedReader(new FileReader(pasta+ARQ1));
            while ((linha = br.readLine()) != null) {
                if (linha.startsWith(ARQUIVO)
                        && !linha.contains(LOG1)
                        && !linha.contains(LOG2)) {
                    linha = linha.substring(linha.lastIndexOf("/")+1, linha.length() - 4);
                    tupla.setInstancia(linha);
                    gravouInstancia = true;
                    
                } else if (linha.startsWith(TEMPO)) {
                    linha = linha.substring(linha.lastIndexOf(" ")+1, linha.length()).trim();
                    tupla.setTempo(Double.parseDouble(linha));
                    gravouTempo = true;
                    
                } else if (linha.startsWith(SOLUCAO)) {
                    linha = linha.substring(linha.lastIndexOf(" ")+1, linha.length()).trim();
                    tupla.setSolucao(Double.parseDouble(linha));
                    gravouSolucao = true;
                    
                }

                if (gravouInstancia && gravouSolucao && gravouTempo) {
                    gravouInstancia = false;
                    gravouSolucao = false;
                    gravouTempo = false;
                    listaTuplas.add(tupla);
                    tupla = new Tupla();
                }
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
    
    public void calcular(){
        texto = "Instancia;Tempo Medio;Melhor Solucao;Solucao Media;";
        for (int i = 1; i <= 20; i++) {
            texto += "#"+i+"T;#"+i+"S;";
        }
        texto += "\n";
        
        double somaTempo, melhorSolucao, somaSolucao, aux;
        String linha;
        for( String chave: hashMapTuplas.keySet() ){
            somaTempo = 0;
            melhorSolucao = Double.MIN_NORMAL;
            somaSolucao = 0;
            linha = "";
            
            for( Tupla t: hashMapTuplas.get( chave ) ){
                aux = t.getSolucao();
                if( aux > melhorSolucao ){
                    melhorSolucao = aux;
                }
                somaSolucao += aux;
                
                aux = t.getTempo();
                somaTempo += aux;
            }
            
            somaSolucao /= 20;
            somaTempo /= 20;
            
            linha = chave + ";" + somaTempo + ";" + melhorSolucao + ";" + somaSolucao + ";";
            for( Tupla t: hashMapTuplas.get( chave ) ){
                linha += t.getTempo() + ";" + t.getSolucao() + ";";
            }
            texto += linha + "\n";
        }
    }
    
    public void escrever(){
        FileWriter writer;
        try {
            writer = new FileWriter(pasta + ARQ_FINAL, false);
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
