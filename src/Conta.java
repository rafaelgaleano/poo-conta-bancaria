/**
 * CLASSE = a estrutura, o molde. Descreve o que toda conta TEM e FAZ.
 * */
public class Conta implements AutoCloseable {

    // ATRIBUTOS (o que a conta tem) — private = ENCAPSULAMENTO: ninguém mexe no "cofre"
    private final String titular;
    private double saldo;
    private boolean ativa;

    // CONSTRUTOR: a conta só "nasce" válida, com titular informado
    public Conta(String titular) {
        if (titular == null || titular.isBlank()) {
            throw new IllegalArgumentException("Titular é obrigatório");
        }
        this.titular = titular;
        this.saldo = 0.0;
        this.ativa = true;
        System.out.println("[construtor] Conta aberta para " + titular);
    }

    // SOBRECARGA de construtor: mesmo nome, parâmetros diferentes
    public Conta(String titular, double depositoInicial) {
        this(titular);              // reaproveita o construtor acima
        depositar(depositoInicial);
    }

    // MÉTODOS (o que a conta faz) — a "interface do caixa eletrônico"
    public void depositar(double valor) {
        validarValor(valor);
        saldo += valor;
    }

    public void sacar(double valor) throws SaldoInsuficienteException {
        validarValor(valor);
        if (valor > saldo) {
            throw new SaldoInsuficienteException(saldo, valor);   // TRATAMENTO DE EXCEÇÕES
        }
        saldo -= valor;
    }

    // SOBRECARGA de método: "pagar" em dinheiro/débito...
    public void pagar(double valor) throws SaldoInsuficienteException {
        sacar(valor);
        System.out.printf("Pagamento de R$ %.2f no débito%n", valor);
    }

    // ...ou "pagar" via Pix: mesmo nome, assinatura diferente (resolvida em COMPILAÇÃO)
    public void pagar(double valor, String chavePix) throws SaldoInsuficienteException {
        sacar(valor);
        System.out.printf("Pix de R$ %.2f para %s%n", valor, chavePix);
    }

    // Comportamento padrão; as subclasses SOBRESCREVEM (polimorfismo, resolvido em EXECUÇÃO)
    public void fecharMes() {
        // conta simples: nada acontece no fim do mês
    }

    // Acesso controlado para as subclasses (herança sem quebrar o encapsulamento)
    protected void creditar(double valor) { saldo += valor; }
    protected void debitar(double valor)  { saldo -= valor; }

    public double getSaldo()   { return saldo; }     // leitura permitida...
    public String getTitular() { return titular; }   // ...mas NÃO existe setSaldo()

    private void validarValor(double valor) {
        if (valor <= 0) throw new IllegalArgumentException("Valor deve ser positivo");
    }

    // "DESTRUTOR" em Java: não existe ~Conta() como em C++.
    // A memória é liberada pelo Garbage Collector; recursos são liberados com close().
    @Override
    public void close() {
        ativa = false;
        System.out.println("[close] Conta de " + titular + " encerrada");
    }

    @Override
    public String toString() {
        return String.format("%s de %s | saldo R$ %.2f%s",
                getClass().getSimpleName(), titular, saldo, ativa ? "" : " (encerrada)");
    }
}
