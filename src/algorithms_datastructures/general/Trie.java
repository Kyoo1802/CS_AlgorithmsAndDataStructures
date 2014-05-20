package algorithms_datastructures.general;

public class Trie {

    Nodo root;
    Nodo max;

    public Trie() {
        root = new Nodo(' ');
    }

    class Nodo {

        char c;
        int num;
        Nodo padre, nodos[];

        public Nodo(char c) {
            this.c = c;
            nodos = new Nodo[256];
        }
    }

    private int getIdx(char charAt) {
        return (int) charAt;
    }

    void insert(StringBuilder s) {
        Nodo insertado = insert(s, 0, root);
        max = max == null ? insertado : max;
        max = max.num > insertado.num ? max : insertado;
    }

    private Nodo insert(StringBuilder s, int idx, Nodo n) {
        if (idx >= s.length()) {
            n.num++;
            return n;
        }
        char c = s.charAt(idx);
        int idxChar = getIdx(c);
        if (n.nodos[idxChar] == null) {
            n.nodos[idxChar] = new Nodo(c);
            n.nodos[idxChar].padre = n;
        }
        return insert(s, idx + 1, n.nodos[idxChar]);
    }
}
