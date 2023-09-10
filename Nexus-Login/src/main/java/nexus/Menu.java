package nexus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Menu {
    private final List<String> user = new ArrayList<String>();
    private final List<String> pass = new ArrayList<String>();
    private final List<String> token = new ArrayList<String>();
    boolean sair = false;

    String username = "";
    String password = "";
    String tokens = "";

    void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        Prints.menu();


        int opcao = scanner.nextInt();

        while (!sair) {
            switch (opcao) {
                case 1:
                    login();
                    break;
                case 2:
                    cadastro();
                    break;
                case 0:
                    Prints.sair();
                    sair = true;
                    break;
                default:
                    break;
            }
        }
    }

    void login() {
        if (user.isEmpty()) {
            System.out.println("Não Existe usuario cadastrado no Sistema");
            exibirMenu();
        }

        Scanner scanner = new Scanner(System.in);

        boolean logado = false;
        if (user.size() > 0) {
            while (!logado) {
                Prints.username();
                username = scanner.nextLine();
                Prints.password();
                password = scanner.nextLine();
                Prints.token();
                tokens = scanner.nextLine();

                for (int i = 0; i < user.size(); i++) {
                    if (username.equals(user.get(i))) {
                        if (password.equals(pass.get(i)) && tokens.equals(token.get(i))) {
                            Prints.autenticado();
                            System.out.printf("\nSeja Bem-Vindo %s!!\n", user.get(i));
                            sair = true;
                            logado = true;
                        } else if (!password.equals(pass.get(i)) && tokens.equals(token.get(i))) {
                            Prints.erroPass();
                        } else if (password.equals(pass.get(i)) && !tokens.equals(token.get(i))) {
                            Prints.erroToken();
                        } else {
                            Prints.erroUser();
                        }
                    }
                }
            }
        }
    }


    private void cadastro() {
        Scanner scanner = new Scanner(System.in);
        boolean dia = false;
        boolean meses = false;
        boolean ano = false;
        int day = 0;

        Prints.user();
        String username = scanner.nextLine();
        user.add(username);

        Prints.pass();
        String password = scanner.nextLine();

        pass.add(password);
        while (dia != true) {
            Prints.day();
            int dias = scanner.nextInt();
            if (dias > 0 && dias <= 31) {
                day = dias;
                dia = true;
            } else {
                Prints.dayError();
            }
        }


        int month = 0;
        while (meses != true) {
            Prints.month();

            String mes = scanner.nextLine();
            mes = scanner.nextLine();
            month = 0;

            // Verificando se o mês inserido é válido ou não
            if (mes.equalsIgnoreCase("janeiro") || mes.equals("1") || mes.equals("01")) {
                month = 1;
                meses = true;
            } else if (mes.equalsIgnoreCase("feveriro") || mes.equals("2") || mes.equals("02")) {
                month = 2;
                meses = true;
            } else if (mes.equalsIgnoreCase("marco") || mes.equals("3") || mes.equals("03")) {
                month = 3;
                meses = true;
            } else if (mes.equalsIgnoreCase("abril") || mes.equals("4") || mes.equals("04")) {
                month = 4;
                meses = true;
            } else if (mes.equalsIgnoreCase("maio") || mes.equals("5") || mes.equals("05")) {
                month = 5;
                meses = true;
            } else if (mes.equalsIgnoreCase("junho") || mes.equals("6") || mes.equals("06")) {
                month = 6;
                meses = true;
            } else if (mes.equalsIgnoreCase("julho") || mes.equals("7") || mes.equals("07")) {
                month = 7;
                meses = true;
            } else if (mes.equalsIgnoreCase("agosto") || mes.equals("8") || mes.equals("08")) {
                month = 8;
                meses = true;
            } else if (mes.equalsIgnoreCase("setembro") || mes.equals("9") || mes.equals("09")) {
                month = 9;
                meses = true;
            } else if (mes.equalsIgnoreCase("outubro") || mes.equals("10")) {
                month = 10;
                meses = true;
            } else if (mes.equalsIgnoreCase("novembro") || mes.equals("11")) {
                month = 11;
                meses = true;
            } else if (mes.equalsIgnoreCase("dezembro") || mes.equals("12")) {
                month = 12;
                meses = true;
            } else {
                System.out.println("Mês inválido");
            }
        }

        int year = 0;

        while (!ano) {
            Prints.year();
            year = scanner.nextInt();

            if (year >= 1900 && year <= 2023) {
                ano = true;
            } else {
                Prints.anoError();
            }
        }
        int num = ThreadLocalRandom.current().nextInt(1, 100001);

        String tokenF = String.valueOf((year + month + day) * num);

        tokenF = ((((((((tokenF.replace("1", "A").replace("3", "B").replace("5", "C").replace("7", "D").replace("9", "E")))))))));

        System.out.printf("|    Seu Token foi Gerado: %s    |\n", tokenF);
        token.add(tokenF);

        exibirMenu();

    }
}
// Realizado Pela Nexus Enterprises :)