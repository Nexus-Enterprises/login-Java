package Discos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DadosDisco {
    String nome;
    String modelo = "NULL";
    String montagem;
    Double espTotal;
    Double espLivre;
    Double espUsado;

    public DadosDisco(String nome, String montagem, Double discTotal, Double discLivre, Double discUsado) {
        this.nome = nome;
        this.montagem = montagem;
        this.espTotal = discTotal;
        this.espLivre = discLivre;
        this.espUsado = discUsado;

        String url = "jdbc:mysql://localhost:3306/NEXUS";
        String user = "root";
        String passwd = "01032002";

        try {
            Connection conexao = DriverManager.getConnection(url, user, passwd);

            String cadastro = "INSERT INTO Componente VALUES (NULL, ?, ?, ?, ?, ?);";

            PreparedStatement instrucao = conexao.prepareStatement(cadastro);

            instrucao.setString(1, this.nome);
            instrucao.setString(2, this.modelo);
            instrucao.setDouble(3, this.espTotal);
            instrucao.setString(4, this.montagem);
            instrucao.setInt(5, 1);

            instrucao.execute();

            instrucao.close();
            conexao.close();
        } catch (
                SQLException throwables) {
            System.err.println("conexao nao estabelecida");
            throwables.printStackTrace();
        }
    }
}
