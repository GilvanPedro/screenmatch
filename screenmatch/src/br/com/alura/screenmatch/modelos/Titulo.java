package br.com.alura.screenmatch.modelos;

public class Titulo {
    private String nome;
    private int anoLancamento;
    private int duracaoMinutos;
    private boolean incluidoNoPlano;
    private double somaAvaliacao;
    private int totalAvaliacao;

    public int getTotalAvaliacao(){
        return totalAvaliacao;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public void setDuracaoMinutos(int duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }

    public void exibirFixaTecnica(){
        System.out.println("Nome: " + nome);
        System.out.println("Ano de Lancamento: " + anoLancamento);
    }

    public void avalia(double nota){
        somaAvaliacao += nota;
        totalAvaliacao ++;
    }

    public double mediaAvaliacao(){
        return somaAvaliacao/totalAvaliacao;
    }
}
