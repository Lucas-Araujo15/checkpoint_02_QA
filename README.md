# [2º Checkpoint] - Quality Assurance & Compliance

Este projeto é uma simples aplicação Java que utiliza a API do IBGE para consultar informações sobre estados brasileiros.

## Funcionalidades 

- Consulta informações de um estado específico com base na sigla do estado.
- Consulta informações de um distrito específico com base no id do distrito.

## Testes unitários implementados

- Verificação dos itens obrigatórios na resposta de consulta de estado
- Verificação dos itens obrigatórios na resposta de consulta de distrito
- Verificação do retorno quando um estado inválido é passado
- Verificação do retorno quando um distrito inválido é passado
- Verifica se retorna todos os 26 estados e 1 distrito federal
- Verifica se as informações de estado estão corretas

## Extras
- [X] Incluir um Action (Java with Maven By GitHub Actions) no projeto.
- [X] Incluir a lib e o Plugin do Jacoco e gerar na pasta target o report html do Jacoco com a cobertura de testes unitários.
- [X] Incluir o projeto adequadamente no Sonarcloud.

[Link do projeto no Sonarcloud](https://sonarcloud.io/project/overview?id=Lucas-Araujo15_checkpoint_02_QA)

## Cobertura de testes unitários
<img src="https://github.com/Lucas-Araujo15/checkpoint_02_QA/blob/main/report_jacoco_01.PNG">
<img src="https://github.com/Lucas-Araujo15/checkpoint_02_QA/blob/main/report_jacoco_02.PNG">
