import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculos.FiltroRecomendacao;
import br.com.alura.screenmatch.modelos.Episodio;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;

public class Principal {
    public static void main(String[] args) {
        Filme meuFilme = new Filme();
        meuFilme.setNome("O Poderoso Chefão");
        meuFilme.setAnoLancamento(1970);
        meuFilme.setDuracaoMinutos(180);
        System.out.println("Duração do Filme: "+meuFilme.getDuracaoMinutos());
        meuFilme.exibirFixaTecnica();
        meuFilme.avalia(8);
        meuFilme.avalia(5);
        meuFilme.avalia(10);

        Filme outroFilme = new Filme();
        outroFilme.setNome("Avatar");
        outroFilme.setAnoLancamento(2023);
        outroFilme.setDuracaoMinutos(200);

        System.out.println("Total de Avaliações: "+meuFilme.getTotalAvaliacao()+"\n");
        // System.out.println(meuFilme.mediaAvaliacao());

        Serie serie = new Serie();
        serie.setNome("Lost");
        serie.setAnoLancamento(2000);
        serie.exibirFixaTecnica();
        serie.setTemporadas(10);
        serie.setEposodiosTemporada(10);
        serie.setMinutosEpisodios(50);
        System.out.println("Duração para maratonar Lost: "+serie.getDuracaoMinutos()+"\n");

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(meuFilme);
        calculadora.inclui(outroFilme);
        calculadora.inclui(serie);
        System.out.println("Tempo de minutos para maratonar os escolhidos: "+calculadora.getTempoTotal());

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(meuFilme);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(serie);
        episodio.setTotalVisualizacoes(300);
        filtro.filtra(episodio);
    }
}