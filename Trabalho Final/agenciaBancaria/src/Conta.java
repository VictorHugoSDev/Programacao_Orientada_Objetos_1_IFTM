
import java.text.NumberFormat;
import java.util.Locale;

class   Conta {
    private String numeroConta;
    private double saldo;
    private double limiteCartao;
    private Financiamento financiamento;
    private static final NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

    // Construtor com saldo inicial
    public Conta(String numeroConta, double saldo) {
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.limiteCartao = saldo / 2;
    }

    // Construtor sem saldo inicial (saldo = 0 por padrão)
    public Conta(String numeroConta) {
        this.numeroConta = numeroConta;
        this.saldo = 0; // Saldo inicial 0
        this.limiteCartao = 0; // Limite do cartão será zero
    }

    public String getNumeroConta() { return numeroConta; }

    public double getSaldo() {
        return saldo;
    }

    public Financiamento getFinanciamento() {
        return financiamento;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            limiteCartao = saldo / 2;
        } else {
            throw new IllegalArgumentException("Valor de depósito inválido");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            limiteCartao = saldo / 2;
        } else {
            throw new IllegalArgumentException("Saldo insuficiente ou valor inválido");
        }
    }

    public void adicionarFinanciamento(double valor, int parcelas) {
        this.financiamento = new Financiamento(valor, parcelas);
    }

    public String consultarInformacoes() {
        String info = "Número da Conta: " + numeroConta + "\nSaldo: " + formatoMoeda.format(saldo) + "\nLimite do Cartão: " + formatoMoeda.format(limiteCartao);
        if (financiamento != null) {
            info += "\nFinanciamento Ativo:\n" + financiamento;
        }
        return info;
    }
}
