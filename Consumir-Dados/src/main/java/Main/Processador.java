package Main;

import com.github.britooo.looca.api.core.Looca;

public class Processador {
    public String processador() {

        Looca looca = new Looca();

        String modelo = looca.getProcessador().getNome();
        String fabricante = looca.getProcessador().getFabricante();
        Double uso = looca.getProcessador().getUso();

        return """
                                
                            Processador
                Fabricante:                   %s
                Modelo:                       %s
                Uso:                          %.2f%%
                """.formatted(fabricante, modelo, uso);

    }
}
