public class Filme {

    String nome;
    int anoLancamento;
    boolean incluidoNoPlano;
    double somaAvaliacao;
    int totalAvaliacao;
    int duracaoMinutos;

    void exibirFixaTecnica(){
        System.out.println("Nome do Filme: " + nome);
        System.out.println("Ano de Lancamento: " + anoLancamento);
    }

    void avalia(double nota){
        somaAvaliacao += nota;
        totalAvaliacao ++;
    }

    double mediaAvaliacao(){
        return somaAvaliacao/totalAvaliacao;
    }
}
