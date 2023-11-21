package projeto.captura.PrimeiroPlano;

import com.github.britooo.looca.api.core.Looca;
import projeto.captura.disco.DadosDisco;

public class PrimeiroPlano {
    Looca looca = new Looca();
    private Integer pid;
    private String name;
    private Double usoCPU;
    private Double usoMem;
    private Double usoDisk;

    public String dadosPrimeiro(String email) {
        // define o tamnho da lista do getDisco
        int size = looca.getGrupoDeProcessos().getProcessos().size();

        DadosPrimeiroPlano[] primeiroPlano = new DadosPrimeiroPlano[size];

        for (int i = 0; i < primeiroPlano.length; i++) {
            pid = looca.getGrupoDeProcessos().getProcessos().get(i).getPid();
            name = looca.getGrupoDeProcessos().getProcessos().get(i).getNome();
            usoCPU = looca.getGrupoDeProcessos().getProcessos().get(i).getUsoCpu();
            usoMem = looca.getGrupoDeProcessos().getProcessos().get(i).getUsoMemoria();
            usoDisk = ((Double.valueOf(looca.getGrupoDeProcessos().getProcessos().get(i).getBytesUtilizados()) / 1024) / 1024) / 1024;

            primeiroPlano[i] = new DadosPrimeiroPlano(pid, name, usoMem, usoDisk, usoCPU, email);
        }

        String mensagem = """
                *------------------------------------------------------------*
                |                 Procesos em Primeiro Plano                 |
                *------------------------------------------------------------*
                """;

        for (DadosPrimeiroPlano dadosPrimeiroPlano : primeiroPlano) {
            mensagem += """
                | Pid: %d
                | Nome: %s
                | Uso de CPU: %.2f
                | Uso de RAM: %.2f
                | Uso de Disco: %.2f
                """.formatted(dadosPrimeiroPlano.pid, dadosPrimeiroPlano.name, dadosPrimeiroPlano.usoCPU, dadosPrimeiroPlano.usoMem, dadosPrimeiroPlano.usoDisk);
        }
        return mensagem;
    }
}