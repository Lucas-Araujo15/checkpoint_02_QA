package org.estudos.br;

import java.io.IOException;
import java.util.Scanner;

/**
 * Classe principal para interação com o usuário e consulta de informações de estados brasileiros e distritos.
 */
public class Main {

    /**
     * Método principal para execução do programa.
     *
     * @param args Argumentos da linha de comando (não utilizados neste programa).
     */
    public static void main(String[] args) {
        // Cria um objeto Scanner para ler entrada do usuário a partir do console
        Scanner scanner = new Scanner(System.in);

        // Variável para controlar o loop do menu
        boolean continuar = true;

        // Loop do menu
        while (continuar) {
            // Imprime um menu para o usuário escolher qual API consultar
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Consultar informações de um estado");
            System.out.println("2. Consultar informações de um distrito");
            System.out.println("3. Sair");

            System.out.print("Opção: ");

            // Lê a opção do usuário
            int opcao = scanner.nextInt();

            try {
                // Verifica a opção do usuário e executa a ação correspondente
                switch (opcao) {
                    case 1:
                        consultarEstado(scanner);
                        break;
                    case 2:
                        consultarDistrito(scanner);
                        break;
                    case 3:
                        continuar = false;
                        System.out.println("\n Obrigado por usar nossos serviços!");// Sair do loop do menu
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (IOException e) {
                // Trata exceção caso ocorra um erro durante a consulta
                System.err.println("Ocorreu um erro ao realizar a consulta: " + e.getMessage());
            }
        }

        // Fecha o objeto Scanner para liberar recursos
        scanner.close();
    }

    /**
     * Método para consultar informações de um estado.
     *
     * @param scanner O Scanner para ler a entrada do usuário.
     * @throws IOException Se houver algum erro de conexão ou leitura.
     */
    private static void consultarEstado(Scanner scanner) throws IOException {
        // Imprime uma mensagem de instrução para o usuário
        System.out.println("Digite a sigla do estado a ser consultado: ");

        // Lê a sigla do estado fornecida pelo usuário
        String uf = scanner.next().toUpperCase();

        // Chama o método consultarEstado da classe ConsultaIBGE para obter informações do estado
        String resultado = ConsultaIBGE.consultarEstado(uf);

        // Imprime o resultado da consulta
        System.out.println("Resultado da consulta: ");
        System.out.println(resultado);
    }

    /**
     * Método para consultar informações de um distrito.
     *
     * @param scanner O Scanner para ler a entrada do usuário.
     * @throws IOException Se houver algum erro de conexão ou leitura.
     */
    private static void consultarDistrito(Scanner scanner) throws IOException {
        // Imprime uma mensagem de instrução para o usuário
        System.out.println("Digite o ID do distrito a ser consultado: ");

        // Lê o ID do distrito fornecido pelo usuário
        int id = scanner.nextInt();

        // Chama o método consultarDistrito da classe ConsultaIBGE para obter informações do distrito
        String resultado = ConsultaIBGE.consultarDistrito(id);

        // Imprime o resultado da consulta
        System.out.println("Resultado da consulta: ");
        System.out.println(resultado);
    }
}
