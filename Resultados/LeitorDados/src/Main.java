
public class Main {

    public static void main(String[] args) {
        LeitorLog ll = new LeitorLog(args[0]);
        ll.ler();
        ll.separar();
        ll.calcular();
        ll.escrever();
    }

}
