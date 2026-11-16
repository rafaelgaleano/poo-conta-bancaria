import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== 1. Classe x objeto + 2. Construtor ===");
        Conta contaIsacio = new Conta("isacio", 600);
        Conta ana   = new ContaCorrente("Ana", 1000, 15);    // um objeto
        Conta bruno = new ContaPoupanca("Bruno", 2000, 0.005); // outro objeto, mesma "forma"
        System.out.println(ana);
        System.out.println(bruno);

//        System.out.println("\n=== 3. Encapsulamento ===");
//        //ana.saldo = 1_000_000;   // NÃO COMPILA: saldo é private
//        ana.depositar(200);
//        System.out.println(ana);
////
//        System.out.println("\n=== 4. Sobrecarga: pagar(valor) x pagar(valor, chavePix) ===");
//        try {
//            ana.pagar(50);
//            ana.pagar(80, "loja@pix.com");
//        } catch (SaldoInsuficienteException e) {
//            System.out.println("Erro: " + e.getMessage());
//        }
//
//        System.out.println("\n=== 5. Tratamento de exceções (o caixa sempre devolve o cartão) ===");
//        try {
//            ana.sacar(5000);
//            System.out.println("Saque realizado");             // não executa
//        } catch (SaldoInsuficienteException e) {
//            System.out.println("Erro tratado: " + e.getMessage());
//        } finally {
//            System.out.println("finally: cartão devolvido");    // executa SEMPRE
//        }
//
//        System.out.println("\n=== 6. Herança + 7. polimorfismo: a mesma ordem, respostas diferentes ===");
//        List<Conta> contas = List.of(ana, bruno);
//        for (Conta c : contas) {
//            c.fecharMes();          // qual fecharMes()? decidido em EXECUÇÃO, pelo tipo real
//        }
//        contas.forEach(System.out::println);
//
//        System.out.println("\n===  \"Destrutor\": try-with-resources chama close() automaticamente ===");
//        try (Conta temporaria = new Conta("Carla", 100)) {
//            System.out.println(temporaria);
//        } // close() é chamado aqui, mesmo se ocorrer exceção
//    }
}
