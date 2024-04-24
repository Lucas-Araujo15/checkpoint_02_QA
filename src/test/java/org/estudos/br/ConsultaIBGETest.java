package org.estudos.br;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConsultaIBGETest {
    private static final String ESTADOS_API_URL = "https://servicodados.ibge.gov.br/api/v1/localidades/estados/";


    @Test
    @DisplayName("Teste para consulta única de um estado")
    public void testConsultarEstado() throws IOException {
        // Arrange
        String uf = "SP"; // Define o estado a ser consultado

        // Act
        String resposta = ConsultaIBGE.consultarEstado(uf); // Chama o método a ser testado

        // Assert
        // Verifica se a resposta não está vazia
        assert !resposta.isEmpty();

        // Verifica se o status code é 200 (OK)
        HttpURLConnection connection = (HttpURLConnection) new URL(ESTADOS_API_URL + uf).openConnection();

        int statusCode = connection.getResponseCode();
        assertEquals(200, statusCode, "O status code da resposta da API deve ser 200 (OK)");
    }

    @Test
    @DisplayName("Verifica itens obrigatórios na resposta de consulta de estado")
    public void testStateRequiredFields() throws IOException {
        String uf = "SP";

        String response = ConsultaIBGE.consultarEstado(uf);

        assert !response.isEmpty();

        JSONObject jsonResponse = new JSONObject(response);

        List<String> expectedFields = Arrays.asList("id", "sigla", "nome", "regiao");

        for (String field : expectedFields) {
            assertTrue(jsonResponse.has(field), "Campo '" + field + "' não encontrado");
        }
    }

    @Test
    @DisplayName("Verifica itens obrigatórios na resposta de consulta de distrito")
    public void testDistrictRequiredFields() throws IOException {
        int id = 160030312;

        String response = ConsultaIBGE.consultarDistrito(id);

        assert !response.isEmpty();

        JSONArray jsonArray = new JSONArray(response);

        JSONObject jsonObject = jsonArray.getJSONObject(0);

        List<String> expectedFields = Arrays.asList("id", "municipio", "nome");

        for (String field : expectedFields) {
            assertTrue(jsonObject.has(field), "Campo '" + field + "' não encontrado");
        }
    }

    @Test
    @DisplayName("Verifica retorno com estado inválido")
    public void testInvalidState() throws IOException {
        String uf = "FFF";

        int emptyArray = 0;

        String response = ConsultaIBGE.consultarEstado(uf);

        assert !response.isEmpty();

        JSONArray jsonArrayResponse = new JSONArray(response);

        assertEquals(emptyArray, jsonArrayResponse.length(), "Deve retornar um array vazio");
    }

    @Test
    @DisplayName("Verifica retorno com distrito inválido")
    public void testInvalidDistrict() throws IOException {
        int id = 123456789;

        int emptyArray = 0;

        String response = ConsultaIBGE.consultarDistrito(id);

        assert !response.isEmpty();

        JSONArray jsonArrayResponse = new JSONArray(response);

        assertEquals(emptyArray, jsonArrayResponse.length(), "Deve retornar um array vazio");
    }

    @Test
    @DisplayName("Verifica se retorna todos os 26 estados e 1 distrito federal")
    public void testNumberOfStates() throws IOException {
        String uf = "";

        int brazilStateQuantity = 27;

        String response = ConsultaIBGE.consultarEstado(uf);

        assert !response.isEmpty();

        JSONArray jsonArrayResponse = new JSONArray(response);

        assertEquals(brazilStateQuantity, jsonArrayResponse.length(), "A resposta deve retornar uma lista de 27 itens");
    }
}