package projeto;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Logs {
    private LocalDateTime dataAtual = LocalDateTime.now();

    // Criando um arquivo dentro dessa pasta
    private File file = new File(".\\Nexus\\src\\main\\log\\%d-%s-%d.txt".formatted(dataAtual.getYear(), dataAtual.getMonth(), dataAtual.getDayOfMonth()));

    public void gravar(String info){
    // verificacao se o arquivo ja existe
        if (file.exists()) {
            escreverArquivo(info);
        }else {

            try {
                file.createNewFile();
                escreverArquivo(info);
                System.out.println("Texto inserido no arquivo com sucesso.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void escreverArquivo(String texto){
        try(
                FileWriter buscar = new FileWriter(file,true)
        ){
            buscar.write(texto);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Logs teste = new Logs();
        teste.gravar("oiii");

    }


}
