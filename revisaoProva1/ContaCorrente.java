package prova1_VictorHugo_q1;

public class ContaCorrente {

    private String nome;
    private String numeroConta;
    private double saldo;
    private String tipoConta;

    public ContaCorrente(String nome, String numeroConta, double saldo) {
        this.nome = nome;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.tipoConta = "comum";
    }

    public ContaCorrente(String nome, String numeroConta, double saldo, String tipoConta ) {
        this.nome = nome;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.tipoConta = tipoConta.equalsIgnoreCase("especial") ? "Especial" : "Comum";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public Boolean sacar(double valor) {
        double taxa = valor * 0.001;
        double saque = valor + taxa;

        if(saldo >= saque) {
            saldo -= saque;
            return true;
        }
        return false;
    }

    public Boolean sacar(double valor, double limiteEspecial) {
        if(tipoConta.equals("especial")){
            double saldoTotal = saldo + limiteEspecial;
            double taxa = valor * 0.002;
            double saque = valor + taxa;

            if(saldoTotal >= saque) {
                saldo -= saque;
                return true;
            }
        }
        return false;
    }

    public void Depositar(double valor) {
        double taxa = valor * 0.001;
        double deposito = valor - taxa;

        saldo += deposito;
    }
}
