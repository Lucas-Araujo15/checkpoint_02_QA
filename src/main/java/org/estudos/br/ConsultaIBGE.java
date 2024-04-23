package org.estudos.br;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Classe para consulta de informações de estados brasileiros e distritos na API do IBGE.
 */
public class ConsultaIBGE {

    // URL base da API do IBGE para estados
    private static final String ESTADOS_API_URL = "https://servicodados.ibge.gov.br/api/v1/localidades/estados/";

    // URL base da API do IBGE para distritos
    private static final String DISTRITOS_API_URL = "https://servicodados.ibge.gov.br/api/v1/localidades/distritos/";

    /**
     * Método para consultar informações de um estado específico.
     *
     * @param uf A sigla do estado a ser consultado.
     * @return Uma string contendo a resposta da API.
     * @throws IOException Se houver algum erro de conexão ou leitura.
     */
    public static String consultarEstado(String uf) throws IOException {
        // Monta a URL completa para consulta do estado específico
        URL url = new URL(ESTADOS_API_URL + uf);

        // Abre uma conexão HTTP com a URL
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        // Define o método da requisição como GET
        connection.setRequestMethod("GET");

        // Prepara para ler a resposta da conexão
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        // Lê cada linha da resposta e a adiciona ao StringBuilder
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // Retorna a resposta da API como uma string
        return response.toString();
    }

    /**
     * Método para consultar informações de um distrito específico.
     *
     * @param id O ID do distrito a ser consultado.
     * @return Uma string contendo a resposta da API.
     * @throws IOException Se houver algum erro de conexão ou leitura.
     */
    public static String consultarDistrito(int id) throws IOException {
        // Monta a URL completa para consulta do distrito específico
        URL url = new URL(DISTRITOS_API_URL + id);

        // Abre uma conexão HTTP com a URL
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        // Define o método da requisição como GET
        connection.setRequestMethod("GET");

        // Prepara para ler a resposta da conexão
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        // Lê cada linha da resposta e a adiciona ao StringBuilder
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // Retorna a resposta da API como uma string
        return response.toString();
    }
}
