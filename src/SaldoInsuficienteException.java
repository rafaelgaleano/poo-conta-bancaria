/**
 * Exceção de negócio: o "aviso do caixa eletrônico".
 * É checked (estende Exception): o compilador OBRIGA quem chama sacar() a tratá-la.
 */
public class SaldoInsuficienteException extends Exception {
    public SaldoInsuficienteException(double saldo, double valor) {
        super(String.format("Saldo insuficiente: saldo R$ %.2f, saque de R$ %.2f", saldo, valor));
    }
}
