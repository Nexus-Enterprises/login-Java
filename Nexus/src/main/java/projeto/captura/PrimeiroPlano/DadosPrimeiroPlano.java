package projeto.captura.PrimeiroPlano;

import projeto.conexao.Conectar;

public class DadosPrimeiroPlano {
    Integer pid;
    String name;
    Double usoCPU;
    Double usoMem;
    Double usoDisk;
    String email;
    public DadosPrimeiroPlano(Integer pid, String name, Double usoCPU, Double usoMem, Double usoDisk, String email) {
        this.pid = pid;
        this.name = name;
        this.usoCPU = usoCPU;
        this.usoMem = usoMem;
        this.usoDisk = usoDisk;
        this.email = email;

        Conectar conectar = new Conectar();
        conectar.inserirProcessos(this.pid, this.name, this.usoCPU, this.usoMem, this.usoDisk, this.email);
    }
}
