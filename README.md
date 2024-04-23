# API de Consulta do IBGE

Este projeto é uma simples aplicação Java que utiliza a API do IBGE para consultar informações sobre estados brasileiros.

## Funcionalidades

- Consulta informações de um estado específico com base na sigla do estado.

## Como Usar

### Requisitos

- Java 8 ou superior
- Maven

### Clonando o Repositório

```bash
git clone https://github.com/PauloRobert/ApiConsultaIBGE.git
```

### Importando o Projeto

Este projeto pode ser importado em qualquer IDE Java, como Eclipse, IntelliJ IDEA ou NetBeans.

### Dependências do Projeto

Este projeto utiliza as seguintes dependências:

- `org.json:json`: para manipulação de JSON.
- `org.junit.jupiter:junit-jupiter`: para testes unitários.
- `org.mockito:mockito-junit-jupiter`: para testes com Mockito.

Certifique-se de incluir essas dependências no arquivo `pom.xml` do seu projeto Maven.

### Exemplo:

```xml
<dependencies>
    <!-- Dependência para manipulação de JSON -->
    <dependency>
        <groupId>org.json</groupId>
        <artifactId>json</artifactId>
        <version>20240303</version>
    </dependency>
    
    <!-- Dependência para JUnit 5 -->
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-engine</artifactId>
        <version>5.7.1</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-params</artifactId>
        <version>5.7.1</version>
        <scope>test</scope>
    </dependency>
    
    <!-- Dependência para Mockito -->
    <dependency>
        <groupId>org.mockito</groupId>
        <artifactId>mockito-junit-jupiter</artifactId>
        <version>5.11.0</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

### Executando os Testes

Para executar os testes do projeto, basta utilizar o seguinte comando Maven:

```bash
mvn test
```

### Exemplo de Uso

Aqui está um exemplo simples de como usar a classe `ConsultaIBGE` para consultar informações de um estado:

```java
import java.io.IOException;

public class ExemploUso {
    public static void main(String[] args) {
        try {
            String estado = ConsultaIBGE.consultarEstado("SP");
            System.out.println("Informações do estado de São Paulo:");
            System.out.println(estado);
        } catch (IOException e) {
            System.err.println("Erro ao consultar informações do estado: " + e.getMessage());
        }
    }
}
```

## Postman

Na pasta 'Postman' na raiz do projeto, você encontrará uma collection com todas as chamadas da API. Essa collection pode ser importada no Postman para facilitar o teste das chamadas.

## Contribuindo

Se você deseja contribuir com este projeto, sinta-se à vontade para abrir uma issue ou enviar um pull request.
