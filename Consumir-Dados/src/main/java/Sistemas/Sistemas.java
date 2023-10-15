package Sistemas;

import com.github.britooo.looca.api.core.Looca;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

public class Sistemas {
    public String sistema() {
        // Criacao de variaveis
        String perSO = "";
        // Cria uma instacia da OPMX para puxar diversos dados do sistema
        OperatingSystemMXBean sistema = ManagementFactory.getOperatingSystemMXBean();
        // Cria a instacia da API Looca
        Looca looca = new Looca();

        // Pega em qual sistema esta rodando o Programa
        String system = looca.getSistema().getSistemaOperacional();

        // Quem e a fabricante da versao do SO
        String brand = looca.getSistema().getFabricante();

        // Pega a permissao root do sistema
        Boolean permission = looca.getSistema().getPermissao();
        // faz a alteracao da permissao para portugues
        if (permission.equals("false")){
            perSO = "Nao Autorizado";
        } else {
            perSO = "Autorizado";
        }

        // Pega a arquitetura do Sistema Operacional montado
        String arch = sistema.getArch().replaceAll("[^0-9X]", "");
        // Faz o replace apagando todas as letras deixando apenas os numeros

        return """
                *------------------------------------------------------------*
                |                    Sistema Operacional                     |
                *------------------------------------------------------------*
                | Sistema:                                    %s
                | Fabricante:                                 %s
                | Arquitetura:                                %s Bits
                | Permissões Root:                            %s
                """.formatted(system, brand, arch, perSO);
    }
}
