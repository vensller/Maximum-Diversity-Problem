
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
    private String textoLatex;
    private List<Tupla> listaTuplas;
    private Map<String, List<Tupla> > hashMapTuplas = new HashMap<>();

    private String pasta;
    private String arquivoEstadoDaArte;
    private final String ARQ1 = "LogDeResultados1.txt";
    private final String ARQ2 = "LogDeResultados2.txt";
    private final String ARQ_FINAL = "resultados.csv";

    private final String ARQUIVO = "Arquivo: ";
    private final String TEMPO = "Tempo total: ";
    private final String SOLUCAO = "Melhor solução: ";
    private final String LOG1 = "LogDeResultados1";
    private final String LOG2 = "LogDeResultados2";

    public LeitorLog(String arquivo, String arquivoEstadoDaArte) {
        super();
        this.pasta = arquivo;
        this.arquivoEstadoDaArte = arquivoEstadoDaArte;
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
        texto = "Instancia;"
                + "Estado da Arte;"
                + "Melhor Solucao;"
                + "Desvio para o melhor;"
                + "Tempo da melhor solucao;"
                + "Solucao Media;"
                + "Desvio medio;"
                + "Tempo Medio;";
        
        textoLatex += texto + "\n";
        for (int i = 1; i <= 20; i++) {
            texto += "#"+i+"T;#"+i+"S;";
        }
        texto += "\n";
        
        double tempoMedio, melhorSolucao, tempoDoMelhor = 0, solucaoMedia, aux;
        String linha;
        for( String chave: hashMapTuplas.keySet() ){
            tempoMedio = 0;
            melhorSolucao = Double.MIN_NORMAL;
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
            
            solucaoMedia /= 20;
            tempoMedio /= 20;
            
            String estadoDaArte = buscarEstadoDaArte(chave).replaceAll(",", ".");
            
            if( estadoDaArte.isEmpty() ){
                linha = chave + ";-;"+ melhorSolucao + ";-;" + tempoDoMelhor + ";"
                    + solucaoMedia + ";-;" + tempoMedio;
            }else{
                linha = chave + ";" + estadoDaArte + ";"+ melhorSolucao + ";" + 
                    (Double.parseDouble(estadoDaArte)-melhorSolucao) +";" + 
                    tempoDoMelhor + ";" + solucaoMedia + ";" + 
                    (Double.parseDouble(estadoDaArte)-solucaoMedia) + ";" + tempoMedio;
            }
            textoLatex += linha + "\n";
            for( Tupla t: hashMapTuplas.get( chave ) ){
                linha += t.getTempo() + ";" + t.getSolucao() + ";";
            }
            texto += linha + "\n";
        }
    }
    
    private String buscarEstadoDaArte(String buscado){
        String retorno = "";
        try {
            String linha;
            String[] valores;
            BufferedReader br = new BufferedReader(new FileReader(arquivoEstadoDaArte));
            while ((linha = br.readLine()) != null) {
                if( !linha.startsWith("Instance")){
                    valores = linha.split(";");
                    linha = valores[0].substring(0, valores[0].indexOf("."));
                    if( buscado.equals( linha ) ){
                        retorno = valores[1];
                    }
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
            writer = new FileWriter(pasta + ARQ_FINAL, false);
            writer.write(texto);
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void excreverLatex(){
        FileWriter writer;
        try {
            writer = new FileWriter(pasta + "l.txt", false);
            writer.write(textoLatex.replaceAll(";", "&").replaceAll("_", "\\_").replaceAll("\n", "\\\\\n"));
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
