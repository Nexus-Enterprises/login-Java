package Main;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.temperatura.Temperatura;

public class Sistemas {
    public String sistema() {
        Looca looca = new Looca();

        String sisOper = looca.getSistema().getSistemaOperacional();
        String fabricante = looca.getSistema().getFabricante();
        Integer arquiterura = looca.getSistema().getArquitetura();
        Boolean permissoes = looca.getSistema().getPermissao();

        return """
                    Sistema Operacional
                Sistema:                %s
                Fabricante:             %s
                Arquitetura:            %dBits
                Permissões Root:        %b
                """.formatted(sisOper, fabricante, arquiterura, permissoes);
    }
}
