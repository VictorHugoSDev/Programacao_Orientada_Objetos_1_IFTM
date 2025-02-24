public class App {
    public static void main(String[] args) {

        Universidade universidade = new Universidade("Universidade A");

        Departamento dept1 = universidade.criaDepartamento("Administração", "Andar A");
        Departamento dept2 = universidade.criaDepartamento("Contabilidade", "Andar C");

        Pessoa pessoa1 = new Pessoa("João", 30, "Masculino");
        Pessoa pessoa2 = new Pessoa("José", 28, "Masculino");
        Pessoa pessoa3 = new Pessoa("Joana", 30, "Feminino");
        Pessoa pessoa4 = new Pessoa("Julia", 28, "Feminino");

        pessoa1.setDepartamento(dept1);
        pessoa2.setDepartamento(dept2);
        pessoa3.setDepartamento(dept1);
        pessoa4.setDepartamento(dept2);

        System.out.println(pessoa1);
        System.out.println(pessoa2);
        System.out.println(pessoa3);
        System.out.println(pessoa4);
    }
}
