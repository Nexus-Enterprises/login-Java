package Discos;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Discos {

    int i = 0;
    int j = 0;

    public String disco() throws IOException {
        Looca looca = new Looca();
        DiscoGrupo discoGrupo = new Looca().getGrupoDeDiscos();

        int size =  discoGrupo.getDiscos().size();
        DadosDisco[] disk = new DadosDisco[size];

        for (int i = 0; i < disk.length; i++){
            String nome = discoGrupo.getDiscos().get(i).getModelo();
            String montagem = discoGrupo.getDiscos().get(i).getNome();
            Double discTotal = Double.valueOf(discoGrupo.getDiscos().get(i).getTamanho());
            Double total = ((discTotal / 1024) / 1024) / 1024;
            Double discUsado = 16384.0;
            Double usado = ((discUsado / 1024) / 1024) / 1024;
            Double discLivre = total - usado;
            disk[i] = new DadosDisco(nome, montagem, total, discLivre, usado);
        }

        String mensagem = """
                        *---------------------------------------------------* 
                                              Discos
                        *---------------------------------------------------* 
                        """;

        for (DadosDisco dadosDisco : disk) {
            mensagem += """
                    Nome:                                       %s
                    Espaco Total:                               %.2f Gb
                    Espaco Usado:                               %.2f Gb
                    Espaco Livre:                               %.2f Gb
                    *---------------------------------------------------*                 
                    """.formatted(dadosDisco.nome, dadosDisco.espTotal, dadosDisco.espUsado, dadosDisco.espLivre);
        }
        return mensagem;
    }
}

