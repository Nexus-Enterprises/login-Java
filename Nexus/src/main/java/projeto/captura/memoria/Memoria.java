package projeto.captura.memoria;

import com.github.britooo.looca.api.core.Looca;
import projeto.conexao.Conectar;
import projeto.Logs;
import java.text.DecimalFormat;
import java.lang.Math;
public class Memoria {
    public String memoria(String email) {
        String montagem = null;
        Integer fkAlerta;
        Integer fkComponente = 2;

        // Cria a instacia da API Looca
        Looca looca = new Looca();
        // pega a quantidade de memoria em uso e faz o calculo para Gb
        Double memEmUso = Double.valueOf(looca.getMemoria().getEmUso());
        Double usoAtual = ((memEmUso / 1024) / 1024) / 1024;
        // pega a quantidade de memoria disponivel e faz o calculo para Gb
        Double memDisponivel = Double.valueOf(looca.getMemoria().getDisponivel());
        Double disponivel = ((memDisponivel / 1024) / 1024) / 1024;

        // pega a quantidade de memoria total e faz o calculo para Gb
        Double memTotal = Double.valueOf(looca.getMemoria().getTotal());
        Double capMax = ((memTotal / 1024) / 1024) / 1024;

        String modelo = """
                RAM %.2f
                """.formatted(capMax);

        Double porcentage = (usoAtual * 100) / capMax;
        if (porcentage <= 50) {
            fkAlerta = 10;
        } else if (porcentage > 50 && porcentage <= 75) {
            fkAlerta = 4;
        } else if (porcentage > 75 && porcentage <= 90) {
            fkAlerta = 5;
            Logs logs = new Logs();
            logs.gravar("ALERT - Memoria Utilizada %s%".formatted(porcentage.toString()));
        } else {
            fkAlerta = 6;
            Logs logs = new Logs();
            logs.gravar("ALERT - Memoria Utilizada %s%".formatted(porcentage.toString()));
        }
        String endIPV4 = looca.getRede().getGrupoDeInterfaces().getInterfaces().get(0).getEnderecoIpv4().get(0);

        Conectar conectar = new Conectar();

        Logs logs = new Logs();

        logs.gravar("Memoria Utilizada %s%".formatted(porcentage.toString()));

        conectar.inserirMemoria(modelo, capMax, usoAtual, montagem, endIPV4, fkAlerta, fkComponente, email);
        // retorna a mensgem para ser impressa na Main
        return """
                *------------------------------------------------------------*
                |                           Memoria                          |
                *------------------------------------------------------------*
                | Uso:                                       %.2f Gb
                | Disponivel:                                %.2f Gb
                | Total:                                     %.2f Gb
                """.formatted(usoAtual, disponivel, capMax);


    }

}