import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Investimento> investimentos = new ArrayList<>();

    public static void main(String[] args) {
        Investimento investimentoA = new Investimento("CDB");
        Investimento investimentoB = new Investimento("LCI");
        Investimento investimentoC = new Investimento("LCA");

        investimentos.add(investimentoA);
        investimentos.add(investimentoB);
        investimentos.add(investimentoC);

        while (true) {
            String opcao = JOptionPane.showInputDialog("Menu:\n1. Cadastrar Cliente\n2. Depositar\n3. Sacar\n4. Cadastrar Financiamento\n5. Consultar Cliente\n6. Investimentos\n7. Sair");
            switch (opcao) {
                case "1": cadastrarCliente(); break;
                case "2": realizarDeposito(); break;
                case "3": realizarSaque(); break;
                case "4": cadastrarFinanciamento(); break;
                case "5": consultarCliente(); break;
                case "6": menuInvestimentos(); break;
                case "7": System.exit(0);
                default: JOptionPane.showMessageDialog(null, "Opção inválida");
            }
        }
    }

    // Menu para gerenciar investimentos
    private static void menuInvestimentos() {
        while (true) {
            String opcaoInvestimento = JOptionPane.showInputDialog("Menu Investimentos:\n1. Vincular Cliente\n2. Remover Cliente\n3. Consultar Clientes\n4. Voltar ao Menu Principal");
            switch (opcaoInvestimento) {
                case "1": vincularClienteInvestimento(); break;
                case "2": removerClienteInvestimento(); break;
                case "3": consultarClientesInvestimento(); break;
                case "4": return; // Volta para o menu principal
                default: JOptionPane.showMessageDialog(null, "Opção inválida");
            }
        }
    }

    // Vincular cliente a um investimento
    private static void vincularClienteInvestimento() {
        Cliente cliente = buscarCliente();
        if (cliente != null) {
            String tipoInvestimento = JOptionPane.showInputDialog("Digite o tipo de investimento (CDB, LCI, LCA):");
            Investimento investimento = buscarInvestimento(tipoInvestimento);
            if (investimento != null) {
                cliente.adicionarInvestimento(investimento); // Vincula o investimento ao cliente
                JOptionPane.showMessageDialog(null, "Cliente " + cliente.getNome() + " vinculado ao investimento " + tipoInvestimento);
            } else {
                JOptionPane.showMessageDialog(null, "Tipo de investimento inválido!");
            }
        }
    }

    // Remover cliente de um investimento
    private static void removerClienteInvestimento() {
        Cliente cliente = buscarCliente();
        if (cliente != null) {
            String tipoInvestimento = JOptionPane.showInputDialog("Digite o tipo de investimento (CDB, LCI, LCA):");
            Investimento investimento = buscarInvestimento(tipoInvestimento);
            if (investimento != null) {
                cliente.getInvestimentos().remove(investimento); // Remove o investimento do cliente
                JOptionPane.showMessageDialog(null, "Cliente " + cliente.getNome() + " removido do investimento " + tipoInvestimento);
            } else {
                JOptionPane.showMessageDialog(null, "Tipo de investimento inválido!");
            }
        }
    }

    // Consultar clientes em um investimento
    private static void consultarClientesInvestimento() {
        String tipoInvestimento = JOptionPane.showInputDialog("Digite o tipo de investimento (CDB, LCI, LCA):");
        Investimento investimento = buscarInvestimento(tipoInvestimento);
        if (investimento != null) {
            StringBuilder listaClientes = new StringBuilder("Clientes no investimento " + tipoInvestimento + ":\n");
            for (Cliente cliente : clientes) {
                if (cliente.getInvestimentos().contains(investimento)) {
                    listaClientes.append(cliente.getNome()).append("\n");
                }
            }
            JOptionPane.showMessageDialog(null, listaClientes.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Tipo de investimento inválido!");
        }
    }

    // Buscar um investimento pelo tipo
    private static Investimento buscarInvestimento(String tipo) {
        return investimentos.stream()
                .filter(i -> i.getTipo().equalsIgnoreCase(tipo))
                .findFirst()
                .orElse(null);
    }

    // Métodos já existentes do seu código (sem modificações)
    private static void cadastrarCliente() {
        String nome;
        do {
            nome = JOptionPane.showInputDialog("Nome do Cliente:");
        } while (nome == null || nome.trim().isEmpty());

        String numeroConta;
        boolean contaValida;
        do {
            contaValida = true;
            numeroConta = JOptionPane.showInputDialog("Número da Conta:");
            for (Cliente cliente : clientes) {
                if (cliente.getConta().getNumeroConta().equals(numeroConta)) {
                    contaValida = false;
                    JOptionPane.showMessageDialog(null, "Este número de conta já existe! Por favor, insira um número de conta único.");
                    break;
                }
            }
        } while (numeroConta == null || numeroConta.trim().isEmpty() || !contaValida);

        double saldo = 0;
        String depositoInicial = JOptionPane.showInputDialog("Deseja realizar um depósito inicial? (S/N):");
        if (depositoInicial.equalsIgnoreCase("S")) {
            boolean valido = false;
            while (!valido) {
                try {
                    saldo = Double.parseDouble(JOptionPane.showInputDialog("Valor do Depósito Inicial:"));
                    if (saldo > 0) {
                        valido = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "O depósito inicial deve ser maior que zero.");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira um valor numérico válido.");
                }
            }
        }

        Conta conta = (saldo > 0) ? new Conta(numeroConta, saldo) : new Conta(numeroConta);

        Cliente cliente = new Cliente(nome, numeroConta, conta);
        clientes.add(cliente);
        JOptionPane.showMessageDialog(null, cliente.consultarInformacoes() + "\nCadastrado com sucesso!");
    }

    private static void realizarDeposito() {
        Cliente cliente = buscarCliente();
        if (cliente != null) {
            double valor = 0;
            boolean valido = false;
            while (!valido) {
                try {
                    valor = Double.parseDouble(JOptionPane.showInputDialog("Valor do depósito:"));
                    valido = true;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira um valor numérico válido.");
                }
            }
            cliente.getConta().depositar(valor);
            JOptionPane.showMessageDialog(null, "Depósito realizado com sucesso!\nCliente: " + cliente.getNome() + "\n" + cliente.getConta().consultarInformacoes());
        }
    }

    private static void realizarSaque() {
        Cliente cliente = buscarCliente();
        if (cliente != null) {
            double valor = 0;
            boolean valido = false;
            while (!valido) {
                try {
                    valor = Double.parseDouble(JOptionPane.showInputDialog("Valor do saque:"));
                    valido = true;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira um valor numérico válido.");
                }
            }
            try {
                cliente.getConta().sacar(valor);
                JOptionPane.showMessageDialog(null, "Saque realizado com sucesso!\nCliente: " + cliente.getNome() + "\n" + cliente.getConta().consultarInformacoes());
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }

    private static Cliente buscarCliente() {
        String numeroConta = JOptionPane.showInputDialog("Número da Conta:");
        Cliente cliente = clientes.stream()
                .filter(c -> c.getConta().getNumeroConta().equals(numeroConta))
                .findFirst()
                .orElse(null);
        if (cliente == null) {
            JOptionPane.showMessageDialog(null, "Número de conta não encontrado. Por favor, verifique e tente novamente.");
        }
        return cliente;
    }

    private static void cadastrarFinanciamento() {
        Cliente cliente = buscarCliente();
        if (cliente != null) {
            double valor = 0;
            boolean valido = false;
            while (!valido) {
                try {
                    valor = Double.parseDouble(JOptionPane.showInputDialog("Valor do financiamento:"));
                    valido = true;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira um valor numérico válido.");
                }
            }
            int parcelas = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de parcelas:"));
            cliente.getConta().adicionarFinanciamento(valor, parcelas);
            JOptionPane.showMessageDialog(null, "Financiamento cadastrado com sucesso!\nNúmero da Conta: " + cliente.getConta().getNumeroConta() + "\nNome: " + cliente.getNome() + "\n" + cliente.getConta().getFinanciamento().toString());
        }
    }

    private static void consultarCliente() {
        Cliente cliente = buscarCliente();
        if (cliente != null) {
            JOptionPane.showMessageDialog(null, cliente.consultarInformacoes());
        }
    }
}