package nexus;

import java.util.Scanner;

public class Login {
    String user(){
        Scanner scanner = new Scanner(System.in);
        Prints.username();
        String username = scanner.nextLine();


        return username;
    }
    String password(){
        Scanner scanner = new Scanner(System.in);
        Prints.password();
        String password = scanner.nextLine();
        return password;

    }
    String tokens(){
        Scanner scanner = new Scanner(System.in);
        Prints.token();
        String tokens = scanner.nextLine();
        return tokens;
    }
}
