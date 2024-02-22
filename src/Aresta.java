
public class Aresta {
    private final double custo;
    private final No alvo;

    public Aresta(double custo, No alvo) {
        this.custo = custo;
        this.alvo = alvo;
    }

    public double getCusto() {
        return custo;
    }

    public No getAlvo() {
        return alvo;
    }
}
