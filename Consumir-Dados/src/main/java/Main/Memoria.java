package Main;

import com.github.britooo.looca.api.core.Looca;
import java.text.NumberFormat;
import java.util.Locale;

public class Memoria {
    Looca looca = new Looca();

    public String memoria() {
        Double memEmUso = Double.valueOf(looca.getMemoria().getEmUso());
        Double emUso = memEmUso / 1000000000;
        Double memDisponivel = Double.valueOf(looca.getMemoria().getDisponivel());
        Double disponivel = memDisponivel / 1000000000;
        Double memTotal = Double.valueOf(looca.getMemoria().getTotal());
        Double total = memTotal / 1000000000;

        return """
                            Memoria
                Uso:                    %.2f Gb
                Disponivel:             %.2f Gb
                Total:                  %.2f Gb
                """.formatted(emUso, disponivel, total);
    }
}
