package projeto.captura.processador;

import com.github.britooo.looca.api.core.Looca;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import projeto.conexao.Conectar;
import projeto.Logs;

public class Processador {
    public String processador(String email) {
        // Cria uma instacia para puxar dados do processador
        CentralProcessor processador = new SystemInfo().getHardware().getProcessor();
        Conectar conectar = new Conectar();

        // Criacao das variaveis
        String name = "";
        String modelo = "";
        String montagem = "";
        Integer fkAlerta;
        Integer fkComponente = 2;


        // Pega a Frequencia e faz calculo de GHz
        Double frequency = Double.valueOf(processador.getMaxFreq());
        Double capMax = ((frequency / 1000)/ 1000)/ 1000;

        // Cria instancia da API Looca
        Looca looca = new Looca();

        // Retira a Informacao de Genuine ou Authenthic dos processadores
        String brand = looca.getProcessador().getFabricante().replace("Genuine","").replace("Authentic","");

        // Verifica qual a fabricante do Processador
        if (brand.equals("AMD")){
            // Pega o nome do Processador e remove os Dados nao imporantes para o cadastro
            name = processador.getProcessorIdentifier().getName();
            name = name.replaceAll("Processor| 6-Core ", "");

            // Pega o nome do Processador por extenso e tira apenas o modelo
            modelo = looca.getProcessador().getNome();
            modelo = modelo.replaceAll("AMD | Processor","");

        } else if (brand.equals("Intel")){
            // Pega o nome do Processador e remove os Dados nao imporantes para o cadastro
            name = processador.getProcessorIdentifier().getName();
            name = name.replaceAll("CPU|TM|Gen|1.60GHz|@|1.40GHz", "").replace("(","").replace(")","");

            // Pega o nome do Processador por extenso e tira apenas o modelo
            modelo = looca.getProcessador().getNome();
            modelo = modelo.replaceAll("TM|CPU|@ |1.40GHz|1.60GHz|1.50GHz|1.80GHz","").replace("()","").replace("     ","");
        }
        Double usoAtual = looca.getProcessador().getUso();

        Double porcentage = (usoAtual * 100) / capMax;
        if (porcentage <= 50) {
            fkAlerta = 10;
        } else if (porcentage > 50 && porcentage <= 75) {
            fkAlerta = 1;
        } else if (porcentage > 75 && porcentage <= 90) {
            fkAlerta = 2;
        } else {
            fkAlerta = 3;
        }
        String endIPV4 = looca.getRede().getGrupoDeInterfaces().getInterfaces().get(0).getEnderecoIpv4().get(0);
        String nameBD = """
                %s %s
                """.formatted(brand, modelo);
        conectar.inserirProcessador(modelo, capMax, usoAtual, montagem, endIPV4, fkAlerta, fkComponente, email);

        Logs logs = new Logs();

        logs.gravar("CPU Utilizada %s".formatted(usoAtual.toString()));

        return """
                *------------------------------------------------------------*
                |                           Processador                      |
                *------------------------------------------------------------*
                | Fabricante:                               %s
                | Nome:                                     %s
                | Modelo:                                   %s
                | Uso:                                      %.2f%%
                | Frequencia:                               %.2fGhz
                """.formatted(brand, name, capMax, usoAtual, capMax);

    }
}