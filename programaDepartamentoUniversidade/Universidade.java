import java.util.ArrayList;

public class Universidade {

    private String nome;
    private ArrayList<Departamento> departamentos;

    public Universidade(String nome) {
        this.nome = nome;
        this.departamentos = new ArrayList<>();
    }

    public Departamento criaDepartamento(String nome, String localizacao) {
        Departamento departamento = new Departamento(nome, localizacao);
        this.departamentos.add(departamento);
        return departamento;
    }

    public ArrayList<Departamento> getDepartamentos() {
        return departamentos;
    }

    @Override
    public String toString() {
        return "Universidade{" +
                "nome='" + nome + '\'' +
                ", departamentos=" + departamentos.size() + " departamentos" +
                '}';
    }
}
