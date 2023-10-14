package Main;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.temperatura.Temperatura;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

public class Sistemas {
    public String sistema() {
        OperatingSystemMXBean sistema = ManagementFactory.getOperatingSystemMXBean();
        Looca looca = new Looca();

        String sisOper = looca.getSistema().getSistemaOperacional();
        String fabricante = looca.getSistema().getFabricante();
        Boolean permissoes = looca.getSistema().getPermissao();
        String arqSistema = sistema.getArch();

        return """
                               Sistema Operacional
                *-------------------------------------------------* 
                Sistema:                                    %s
                Fabricante:                                 %s
                Arquitetura:                                %s
                Permissões Root:                            %b
                """.formatted(sisOper, fabricante, arqSistema, permissoes);
    }
}
