package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.*;

public class PrincipalComListas {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("O Poderoso Chefão", 1970);
        meuFilme.avalia(10);
        var filmeGilvan = new  Filme("Gilvan", 2006);
        filmeGilvan.avalia(8);
        Filme outroFilme = new Filme("Avatar", 2023);
        outroFilme.avalia(6);
        Serie serie = new Serie("Lost", 2000);

        ArrayList<Titulo> lista = new ArrayList<Titulo>();
        lista.add(meuFilme);
        lista.add(filmeGilvan);
        lista.add(outroFilme);
        lista.add(serie);

        for (Titulo item : lista) {
            System.out.println("Nome do Filme/Série: "+item.getNome());

            //VERIFICAR SE O ITEM É UM FILME E FAZER ALGO COM ISSO
            if(item instanceof Filme filme){
                System.out.println("Classificação: "+ filme.getClassificacao());
            }

        }

        List<String> buscaArtista = new LinkedList<>();
        buscaArtista.add("Adam Sandler");
        buscaArtista.add("Katy Parry");
        buscaArtista.add("Apricot");
        buscaArtista.add("Obkatiecat");

        System.out.println("\n"+buscaArtista);

        //ORDENAR EM ORDEM ALFABÉTICA
        Collections.sort(buscaArtista);
        System.out.println(buscaArtista);

        Collections.sort(lista);
        System.out.println("\n"+lista);

        //ORDENANDO POR ANO
        lista.sort(Comparator.comparing(Titulo::getAnoLancamento));
        System.out.println(lista);
    }


}
