package Main;

import com.github.britooo.looca.api.core.Looca;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HardwareAbstractionLayer;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.util.List;

public class Processador {
    public String processador() {

        CentralProcessor processador = new SystemInfo().getHardware().getProcessor();

        String nomeCpu = processador.getProcessorIdentifier().getName();
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
                | Modelo:                              %s
                | Uso:                                      %.2f%%
                | Frequencia:                               %.2fGhz
                """.formatted(fabricante, modelo, uso, freqProcessador);

    }
}
