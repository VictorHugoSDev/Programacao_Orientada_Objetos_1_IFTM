public class Formacao {
    public String nivel;
    public Boolean concluido;
    public String instituicao;
    public int ano;

    public Formacao(String nivel, Boolean concluido, String instituicao, int ano) {
        this.nivel = nivel;
        this.concluido = concluido;
        this.instituicao = instituicao;
        this.ano = ano;
    }

    public String exibe(){
        String status = concluido ? "concluído" :  "não concluído";
        return "O nível é " + nivel + ", " + status + " na instituição " + instituicao + " no ano " + ano;
    }
}
