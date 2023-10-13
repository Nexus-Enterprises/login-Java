package Main;

import com.github.britooo.looca.api.core.Looca;
import java.text.NumberFormat;
import java.util.Locale;

public class Memoria {

    public String memoria() {
        Looca looca = new Looca();
        Double memEmUso = Double.valueOf(looca.getMemoria().getEmUso());
        Double emUso = memEmUso / 931322574.615;
        Double memDisponivel = Double.valueOf(looca.getMemoria().getDisponivel());
        Double disponivel = memDisponivel / 931322574.615;
        Double memTotal = Double.valueOf(looca.getMemoria().getTotal());
        Double total = memTotal / 931322574.615;

        return """
                            Memoria
                Uso:                    %.2f Gb
                Disponivel:             %.2f Gb
                Total:                  %.2f Gb
                """.formatted(emUso, disponivel, total);
    }
}
