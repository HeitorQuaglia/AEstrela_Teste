public class No {
    private final String nome;
    private double valorFuncaoG;
    private final double valorFuncaoH;
    private final double valorFuncaoF = 0;
    private Aresta[] adjacentes;
    private No adjacente;

    public No(String nome, double valorFuncaoH) {
        this.nome = nome;
        this.valorFuncaoH = valorFuncaoH;
    }

    public String getNome() {
        return nome;
    }

    public double getValorFuncaoG() {
        return valorFuncaoG;
    }

    public void setValorFuncaoG(double valorFuncaoG) {
        this.valorFuncaoG = valorFuncaoG;
    }

    public double getValorFuncaoH() {
        return valorFuncaoH;
    }

    public double getValorFuncaoF() {
        return valorFuncaoF;
    }

    public Aresta[] getAdjacentes() {
        return adjacentes;
    }

    public void setAdjacentes(Aresta[] adjacentes) {
        this.adjacentes = adjacentes;
    }

    public No getAdjacente() {
        return adjacente;
    }

    public void setAdjacente(No adjacente) {
        this.adjacente = adjacente;
    }
}
