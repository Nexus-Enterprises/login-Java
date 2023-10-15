package Discos;

public class DadosDisco {
    String nome;
    String montagem;
    Double espTotal;
    Double espLivre;
    Double espUsado;

    public DadosDisco(String nome, String montagem, Double discTotal, Double discLivre, Double discUsado) {
        this.nome = nome;
        this.montagem = montagem;
        this.espTotal = discTotal;
        this.espLivre = discLivre;
        this.espUsado = discUsado;
    }
}
