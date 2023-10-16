package nexus;

import java.sql.*;
import java.util.Scanner;

public class Login {
    private String username;
    private String token;
    private boolean logado = false;
    Menu menu = new Menu();

    public void login() {
        Scanner scanner = new Scanner(System.in);

        while (!logado) {
            Prints.username();
            username = scanner.nextLine();
            Prints.token();
            token = scanner.nextLine();

            Logar();
        }
    }

    public void Logar() {
        String url = "jdbc:mysql://localhost:3306/NEXUS";
        String user = "root";
        String passwd = "01032002";

        try {
            Connection conexao = DriverManager.getConnection(url, user, passwd);

            Statement statement = conexao.createStatement();

            String sqlSelect = "SELECT email, token FROM Usuario;";

            ResultSet resposta = statement.executeQuery(sqlSelect);

            while (resposta.next()) {
                String usernameR = resposta.getString("email");
                String tokenR = resposta.getString("token");

                if (username.equals(usernameR) && token.equals(tokenR)){
                    logado = true;
                    System.out.println("Login Realizado com Sucesso!");
                    menu.sair = true;
                    break;
                }


            }

            resposta.close();
            statement.close();
            conexao.close();
        } catch (SQLException throwables) {
            System.out.println("Nenhum Usuario cadastro com esse login");
        }
    }
}