import java.awt.geom.Area;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Criando os nós
        No a = new No("A", 5);
        No b = new No("B", 3);
        No c = new No("C", 2);
        No d = new No("D", 7);
        No e = new No("E", 4);
        No f = new No("F", 8);

        // Definindo as arestas e seus custos
        a.setAdjacentes(new Aresta[]{new Aresta(3, b), new Aresta(4, c)});
        b.setAdjacentes(new Aresta[]{new Aresta(2, d), new Aresta(1, e)});
        c.setAdjacentes(new Aresta[]{new Aresta(2, e)});
        d.setAdjacentes(new Aresta[]{new Aresta(1, f)});
        e.setAdjacentes(new Aresta[]{new Aresta(5, f)});

        // Chamando o algoritmo de busca A*
        buscaEstrela(a, f);

        // Recuperando o caminho encontrado
        String caminho = percorreCaminho(f);
        System.out.println("Caminho encontrado: " + caminho);
    }

    public static String percorreCaminho(No alvo) {
        StringBuilder caminho = new StringBuilder(" ]");

        for (No no = alvo; no != null; no = no.getAdjacente()) {
            caminho.insert(0, ", " + no.getNome());
        }

        caminho = new StringBuilder("[" + caminho.subSequence(1, caminho.length()));

        return caminho.toString();
    }

    public static void buscaEstrela(No origem, No destino) {
        Set<No> nosExplorados = new HashSet<>();

        PriorityQueue<No> fila = new PriorityQueue<>(20, new Comparator<No>() {
            @Override
            public int compare(No i, No j) {
                return Double.compare(i.getValorFuncaoF(), j.getValorFuncaoF());
            }
        });

        origem.setValorFuncaoG(0);

        fila.add(origem);

        boolean encontrado = origem.equals(destino);

        while (!fila.isEmpty() && !encontrado) {
            No noAtual = fila.poll();

            nosExplorados.add(noAtual);

            if(noAtual.getNome().equals(destino.getNome())) {
                encontrado = true;
            }

            if (noAtual.getAdjacentes() != null)
                for (Aresta aresta: noAtual.getAdjacentes()) {
                No noFilho = aresta.getAlvo();
                double custo = aresta.getCusto();
                double funcaoGTemp = noAtual.getValorFuncaoG() + custo;
                double funcaoFTemp = funcaoGTemp + noFilho.getValorFuncaoH();

                if (nosExplorados.contains(noFilho) && funcaoFTemp >= noFilho.getValorFuncaoF()) {
                    continue;
                } else if (!fila.contains(noFilho) || funcaoFTemp < noFilho.getValorFuncaoF()) {
                    noFilho.setAdjacente(noAtual);
                    noFilho.setValorFuncaoG(funcaoGTemp);
                    noFilho.setValorFuncaoF(funcaoFTemp);

                    fila.remove(noFilho);

                    fila.add(noFilho);
                }
            }
        }
    }
}