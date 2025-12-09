package br.com.alura.screenmatch.modelos;

public class Serie extends Titulo {
    private int temporadas;
    private boolean ativa;
    private int eposodiosTemporada;
    private int minutosEpisodios;

    public Serie(String titulo, int anoLancamento) {
        super(titulo, anoLancamento);
    }

    public int getTemporadas() {
        return temporadas;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public int getEposodiosTemporada() {
        return eposodiosTemporada;
    }

    public int getMinutosEpisodios() {
        return minutosEpisodios;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public void setMinutosEpisodios(int minutosEpisodios) {
        this.minutosEpisodios = minutosEpisodios;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public void setEposodiosTemporada(int eposodiosTemporada) {
        this.eposodiosTemporada = eposodiosTemporada;
    }

    @Override
    public int getDuracaoMinutos(){
        return temporadas * eposodiosTemporada * minutosEpisodios;
    }

    @Override
    public String toString() {
        return "Série: " + this.getNome() + "(" + this.getAnoLancamento() + ")";
    }
}
