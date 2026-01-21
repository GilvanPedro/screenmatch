package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.excecao.ErroDeConversaoDeAnoException;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBuscas {
    private static String API_KEY = "SUA CHAVE API";

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        var nomeFilme = "";
        List<Titulo> titulos = new ArrayList<>();
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();

        while (!nomeFilme.equalsIgnoreCase("sair")) {

            if(nomeFilme.equalsIgnoreCase("sair")){
                break;
            }

            System.out.print("Digite o nome do filme para buscar: ");
            nomeFilme = sc.nextLine();

            // CRIANDO O URL COM AS INFORMAÇÕES E JÁ TRATANDO OS ESPAÇOS
            String endereco = "https://www.omdbapi.com/?t=" + nomeFilme.replace(" ", "+") + "&apikey=" + API_KEY;

            try{
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                System.out.println(json);

                // "TRADUZINDO" E ARUMANDO A NOMECLATURA DO GSON PRA UPPER CAMEL CASE
                TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
                System.out.println(meuTituloOmdb);

                // TÍTULO CONVERTIDO
                Titulo meuTitulo = new Titulo(meuTituloOmdb);
                System.out.println(meuTitulo);

                titulos.add(meuTitulo);

            } catch(NumberFormatException e){
                System.out.println("Erro de Formatação "+ e.getMessage());
            } catch(IllegalArgumentException e){
                System.out.println("Erro de argumento na busca: "+ e.getMessage());
            } catch(ErroDeConversaoDeAnoException e){
                System.out.println(e.getMessage());
            }
        }

        FileWriter escrita = new FileWriter("filmes.json");
        escrita.write(gson.toJson(titulos));
        escrita.close();
    }

}
