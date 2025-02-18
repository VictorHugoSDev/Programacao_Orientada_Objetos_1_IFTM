import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String numeroConta;
    private Conta conta;
    private List<Investimento> investimentos;  // Lista de investimentos

    public Cliente(String nome, String numeroConta, Conta conta) {
        this.nome = nome;
        this.numeroConta = numeroConta;
        this.conta = conta;
        this.investimentos = new ArrayList<>();  // Inicializando a lista de investimentos
    }

    public String getNome() {
        return nome;
    }

    public Conta getConta() {
        return conta;
    }

    public List<Investimento> getInvestimentos() {
        return investimentos;
    }

    public void adicionarInvestimento(Investimento investimento) {
        if (!investimentos.contains(investimento)) {
            investimentos.add(investimento);
        }
    }

    public String consultarInformacoes() {
        StringBuilder informacoes = new StringBuilder("Nome: " + nome + "\n" + conta.consultarInformacoes());

        if (investimentos.isEmpty()) {
            informacoes.append("\nNenhum investimento associado.");
        } else {
            informacoes.append("\nInvestimentos: ");
            for (Investimento investimento : investimentos) {
                informacoes.append(investimento.getTipo()).append(" ");
            }
        }

        return informacoes.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cliente cliente = (Cliente) obj;
        return numeroConta.equals(cliente.numeroConta);  // Compara o número da conta
    }

    @Override
    public int hashCode() {
        return numeroConta.hashCode();  // Gera o hashCode baseado no número da conta
    }
}
