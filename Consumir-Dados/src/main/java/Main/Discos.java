package Main;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;

import java.util.List;

public class Discos {
    public String disco() {
        Looca   looca        = new Looca();
        Integer qtdDiscos    = looca.getGrupoDeDiscos().getQuantidadeDeDiscos();
        Double  discTamTotal = Double.valueOf(looca.getGrupoDeDiscos().getTamanhoTotal());

        Double  tamanhoTotal = ((discTamTotal / 1024) / 1024) / 1024;;
        List<Disco> disc     = looca.getGrupoDeDiscos().getDiscos();

        return """
                            Discos
                Quantidade de Discos:         %d
                Total:                        %.2f
                Discos:                       %s
                """.formatted(qtdDiscos, tamanhoTotal, disc);
    }
}
