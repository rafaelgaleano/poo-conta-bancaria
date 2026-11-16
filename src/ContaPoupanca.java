/** HERANÇA: ContaPoupanca "é uma" Conta. */
public class ContaPoupanca extends Conta {
    private final double taxaRendimento;   // ex.: 0.005 = 0,5% ao mês

    public ContaPoupanca(String titular, double depositoInicial, double taxaRendimento) {
        super(titular, depositoInicial);
        this.taxaRendimento = taxaRendimento;
    }

    @Override
    public void fecharMes() {
        double rendimento = getSaldo() * taxaRendimento;
        creditar(rendimento);
        System.out.printf("  %s: rendimento de R$ %.2f creditado%n", getTitular(), rendimento);
    }
}
