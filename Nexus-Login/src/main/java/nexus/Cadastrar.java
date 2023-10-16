package nexus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Cadastrar {
    private String email;
    private String token;

    public void cadastro() {
        Scanner scanner = new Scanner(System.in);
        Prints.user();

        email = scanner.nextLine();

        int num1 = ThreadLocalRandom.current().nextInt(1, 100001);
        int num2 = ThreadLocalRandom.current().nextInt(1, 100001);
        int num3 = ThreadLocalRandom.current().nextInt(1, 100001);

        String tokenF = String.valueOf((num1 * num2 * num3) / num1);

        tokenF = ((((((((tokenF.replace("1", "A").replace("3", "B").replace("5", "C").replace("7", "D").replace("9", "E")))))))));

        token = tokenF;

        System.out.printf("\n\n|    Seu Token foi Gerado: %s    |\n", tokenF);

        realizarCadastro();
    }

    private void realizarCadastro() {
        Menu menu = new Menu();
        String url = "jdbc:mysql://localhost:3306/NEXUS";
        String user = "root";
        String passwd = "01032002";

        try {
            Connection conexao = DriverManager.getConnection(url, user, passwd);
            String cadastro = "INSERT INTO Usuario VALUES (NULL, ?, ?, ?);";
            PreparedStatement instrucao = conexao.prepareStatement(cadastro);

            instrucao.setString(1, this.email);
            instrucao.setString(2, this.token);
            instrucao.setInt(3, 1);

            instrucao.execute();
            instrucao.close();
            menu.exibirMenu();
            conexao.close();
        } catch (SQLException throwables) {
            System.err.println("Cadastro Nao realizado\nUsuario ja existente");
            throwables.printStackTrace();
        }
    }
}

