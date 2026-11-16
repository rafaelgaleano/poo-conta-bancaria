/** HERANÇA: ContaCorrente "é uma" Conta — herda tudo e especializa. */
public class ContaCorrente extends Conta {
    private final double tarifaMensal;

    public ContaCorrente(String titular, double depositoInicial, double tarifaMensal) {
        super(titular, depositoInicial);   // chama o construtor da superclasse
        this.tarifaMensal = tarifaMensal;
    }

    @Override   // SOBRESCRITA: mesma assinatura, comportamento próprio
    public void fecharMes() {
        debitar(tarifaMensal);
        System.out.printf("  %s: tarifa de R$ %.2f cobrada%n", getTitular(), tarifaMensal);
    }
}
