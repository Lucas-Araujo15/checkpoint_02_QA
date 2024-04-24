package org.estudos.br;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class ConsultaIBGEMockTest {
    @Mock
    private HttpURLConnection connectionMock;

    private static final String JSON_RESPONSE = "{\"id\":35,\"sigla\":\"SP\",\"nome\":\"São Paulo\",\"regiao\":{\"id\":3,\"sigla\":\"SE\",\"nome\":\"Sudeste\"}}";

    @BeforeEach
    public void setup() throws IOException {
        MockitoAnnotations.openMocks(this);

        InputStream inputStream = new ByteArrayInputStream(JSON_RESPONSE.getBytes(StandardCharsets.UTF_8));
        when(connectionMock.getInputStream()).thenReturn(inputStream);
    }

    @Test
    @DisplayName("Verifica se as informações de estado estão corretas")
    public void testStateContentResponse() throws IOException {
        try (MockedStatic<ConsultaIBGE> consultaIBGE = Mockito.mockStatic(ConsultaIBGE.class)) {
            consultaIBGE.when(() -> ConsultaIBGE.consultarEstado(anyString()))
                    .thenReturn(JSON_RESPONSE);

            String uf = "SP";

            String response = ConsultaIBGE.consultarEstado(uf);

            System.out.println(response);

            assertTrue(response.contains("São Paulo"), "Deve retornar São Paulo");
            assertTrue(response.contains("SP"), "Deve retornar SP");
            assertTrue(response.contains("Sudeste"), "Deve retornar Sudeste");
        }
    }
}
