package Main;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;

import java.util.List;

public class Discos {
    public String disco() {
        Looca   looca        = new Looca();
        Integer qtdDiscos    = looca.getGrupoDeDiscos().getQuantidadeDeDiscos();
        Long    discTamTotal = looca.getGrupoDeDiscos().getTamanhoTotal();
        Double  tamanhoTotal = discTamTotal / 1073741824.415;
        List<Disco> disc     = looca.getGrupoDeDiscos().getDiscos();

        return """
                            Discos
                Quantidade de Discos:   %d
                Tamanho Total:          %.2f
                Discos:                 %s
                """.formatted(qtdDiscos, tamanhoTotal, disc);
    }
}
