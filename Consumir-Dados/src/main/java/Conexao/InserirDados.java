//package Conexao;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//public class InserirDados {
//
//
//
//    public InserirDados(){
//        String url = "jdbc:mysql://localhost:3306/NEXUS";
//        String user = "root";
//        String passwd = "01032002";
//
//        try {
//            Connection conexao = DriverManager.getConnection(url, user, passwd);
//            System.out.println("Conexao estabelecida");
//
//            String cadastro = "INSERT INTO Componente VALUES (NULL, ?, ?, ?);";
//
//            PreparedStatement instrucao = conexao.prepareStatement(cadastro);
//
//            instrucao.setString(1, "CPU");
//            instrucao.setString(2, "i3");
//            instrucao.setDouble(3, 1.40);
//
//            instrucao.execute();
//
//            instrucao.close();
//            conexao.close();
//        } catch (SQLException throwables) {
//            System.err.println("conexao nao estabelecida");
//            throwables.printStackTrace();
//        }
//    }
//}