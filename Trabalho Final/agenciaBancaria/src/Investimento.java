import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

class Investimento {
    private String tipo;
    private List<Cliente> clientes;

    // Construtor
    public Investimento(String tipo) {
        this.tipo = tipo;
        this.clientes = new ArrayList<>();
    }

    // Método para adicionar um cliente ao investimento
    public void adicionarCliente(Cliente cliente) {
        if (!clientes.contains(cliente)) {
            clientes.add(cliente);
            JOptionPane.showMessageDialog(null, "Cliente " + cliente.getNome() + " adicionado ao investimento " + tipo);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente já está associado a esse investimento.");
        }
    }

    // Método para remover um cliente do investimento
    public void removerCliente(Cliente cliente) {
        if (clientes.contains(cliente)) {
            clientes.remove(cliente);
            JOptionPane.showMessageDialog(null, "Cliente " + cliente.getNome() + " removido do investimento " + tipo);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado no investimento.");
        }
    }

    // Método para listar os clientes de um investimento
    public void listarClientes() {
        StringBuilder listaClientes = new StringBuilder("Clientes no Investimento " + tipo + ":\n");
        if (clientes.isEmpty()) {
            listaClientes.append("Nenhum cliente associado a este investimento.");
        } else {
            for (Cliente cliente : clientes) {
                listaClientes.append(cliente.getNome()).append(" (Conta: ").append(cliente.getConta().getNumeroConta()).append(")\n");
            }
        }
        JOptionPane.showMessageDialog(null, listaClientes.toString());
    }

    // Getter para o tipo de investimento
    public String getTipo() {
        return tipo;
    }
}
