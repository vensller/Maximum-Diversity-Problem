
public class Main {

    public static void main(String[] args) {
        LeitorLog ll = new LeitorLog(args[0], Integer.parseInt(args[1]), args[2], args[3]);
        ll.ler();
        ll.separar();
        ll.processar();
        ll.escrever();
    }

}
