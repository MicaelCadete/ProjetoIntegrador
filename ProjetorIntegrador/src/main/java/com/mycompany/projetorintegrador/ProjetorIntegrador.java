package com.mycompany.projetorintegrador;

import java.text.Normalizer;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.Random;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author micael.cscosme
 */
public class ProjetorIntegrador {

    public static String tudoMinusculo(String str) {
        str.toLowerCase();
        return str;
    }

    public static String removeAcentos(String str) {
        String input = str;
        String output = input.replaceAll("[áàâãäå]", "a")
                .replaceAll("[éèêë]", "e")
                .replaceAll("[íìîï]", "i")
                .replaceAll("[óòôõö]", "o")
                .replaceAll("[úùûü]", "u");
        System.out.println(output);
        return output;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao = 0;

        do {
            System.out.println("===== MENU =====");
            System.out.println("1. Instruções");
            System.out.println("2. Jogar");
            System.out.println("3. Créditos");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("=== INSTRUÇÕES ===");
                    System.out.println("Este é um jogo de quiz. Você terá que responder perguntas corretamente para ganhar pontos.");
                    break;
                case 2:
                    System.out.println("=== JOGAR ===");

                    // Criando as perguntas e respostas
                    String[] perguntas = {
                        "1. Qual o maior planeta do sistema solar?",
                        "2. Qual é o animal terrestre mais rápido do mundo?",
                        "3. Qual é a capital do Brasil?",
                        "4. Quem foi o primeiro presidente do Brasil?",
                        "5. Qual é a fórmula química da água?"
                    };
                    String[] respostas = {
                        "jupiter",
                        "guepardo",
                        "brasilia",
                        "deodoro da fonseca",
                        "h20"
                    };

                    Random embaralhar = new Random();
                    for (int i = perguntas.length - 1; i > 0;) {
                        int x = embaralhar.nextInt(i + 1);
                        // Troca a posição da pergunta
                        String PerguntaPronta = perguntas[i];
                        perguntas[i] = perguntas[x];
                        perguntas[x] = PerguntaPronta;
                        // Troca a posição da resposta
                        String RespostaPronta = respostas[i];
                        respostas[i] = respostas[x];
                        respostas[x] = RespostaPronta;
                        i--;
                    }

                    boolean[] corretas = new boolean[perguntas.length];
                    int acertos = 0;

                    // Exibindo as perguntas e validando as respostas
                    for (int i = 0; i < perguntas.length; i++) {
                        System.out.println(perguntas[i]);
                        String resposta = sc.nextLine();
                        // deixando todas as letras minusculas
                        resposta = tudoMinusculo(resposta);
                        resposta = removeAcentos(resposta);
                        if (resposta.equalsIgnoreCase(respostas[i])) {
                            System.out.println("Resposta correta!");
                            corretas[i] = true;
                            acertos++;
                        } else {
                            System.out.println("Resposta incorreta!");
                            corretas[i] = false;
                        }
                    }

                    // Exibindo a pontuação final e as respostas corretas/erradas
                    System.out.println("");
                    System.out.println("========================================================");
                    System.out.println("");
                    System.out.println("Você acertou " + acertos + " de " + perguntas.length + " perguntas.");
                    System.out.println("Respostas corretas:");
                    for (int i = 0; i < perguntas.length; i++) {
                        if (corretas[i]) {
                            System.out.println(perguntas[i] + " - " + respostas[i]);
                        }
                    }
                    System.out.println("Respostas incorretas:");
                    for (int i = 0; i < perguntas.length; i++) {
                        if (!corretas[i]) {
                            System.out.println(perguntas[i] + " - " + respostas[i]);
                        }
                    }
                    System.out.println("========================================================");
                    break;
                case 3:
                    System.out.println("=== CRÉDITOS ===");
                    System.out.println("Desenvolvido por: Luiz Augusto, Gabriel Nicolau, Micael Cadete e Geovanna Novaes!");
                    break;
                case 4:
                    System.out.println("=== SAIR ===");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }

            System.out.println();
        } while (opcao != 4);
    }

}
