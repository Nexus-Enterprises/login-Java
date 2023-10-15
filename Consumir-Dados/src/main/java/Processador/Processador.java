package Processador;

import com.github.britooo.looca.api.core.Looca;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;

public class Processador {
    public String processador() {

        // Cria uma instacia para puxar dados do processador
        CentralProcessor processador = new SystemInfo().getHardware().getProcessor();

        //
        String nomeCpu = processador.getProcessorIdentifier().getName();
        nomeCpu = nomeCpu.replaceAll("R|CPU|TM|Gen|U9400|8265U|1.60GHz|-|@|1.40GHz", "").replace("(","").replace(")","");


        Double freq = Double.valueOf(processador.getMaxFreq());
        Double freqProcessador = ((freq / 1000)/ 1000)/ 1000;

        System.out.println();

        Looca looca = new Looca();

        String modelo = looca.getProcessador().getNome();
        String fabricante = looca.getProcessador().getFabricante().replace("Genuine","");
        Double uso = looca.getProcessador().getUso();

        return """
                *--------------------------------------------------* 
                |                   Processador                    |
                *--------------------------------------------------* 
                | Fabricante:                               %s
                | Nome:                                     %s
                | Modelo:                                   %s
                | Uso:                                      %.2f%%
                | Frequencia:                               %.2fGhz
                """.formatted(fabricante, nomeCpu, modelo, uso, freqProcessador);

    }
}
