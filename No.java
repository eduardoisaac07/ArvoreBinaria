import java.util.Scanner;

class No {
    int valor;
    No esquerda, direita;

    public No(int valor) {
        this.valor = valor;
        esquerda = null;
        direita = null;
    }
}

class ArvoreBinaria {
    private No raiz;

    public ArvoreBinaria() {
        raiz = null;
    }

    public void adicionarNo(int valor) {
        raiz = adicionarNoRecursivo(raiz, valor);
    }

    private No adicionarNoRecursivo(No atual, int valor) {
        if (atual == null) {
            return new No(valor);
        }

        if (valor < atual.valor) {
            atual.esquerda = adicionarNoRecursivo(atual.esquerda, valor);
        } else if (valor > atual.valor) {
            atual.direita = adicionarNoRecursivo(atual.direita, valor);
        } else {
            // valor já existe
            return atual;
        }

        return atual;
    }

    public void removerNo(int valor) {
        raiz = removerNoRecursivo(raiz, valor);
    }

    private No removerNoRecursivo(No atual, int valor) {
        if (atual == null) {
            return null;
        }

        if (valor == atual.valor) {
            // Nó a ser removido encontrado

            // Caso 1: Sem filho ou apenas um filho
            if (atual.esquerda == null) {
                return atual.direita;
            } else if (atual.direita == null) {
                return atual.esquerda;
            }

            // Caso 3: Nó folha
            if (atual.esquerda == null && atual.direita == null) {
                return null;
            }

            // Caso 2: Nó com dois filhos
            atual.valor = valorMinimo(atual.direita);
            atual.direita = removerNoRecursivo(atual.direita, atual.valor);

        } else if (valor < atual.valor) {
            atual.esquerda = removerNoRecursivo(atual.esquerda, valor);
        } else {
            atual.direita = removerNoRecursivo(atual.direita, valor);
        }
        return atual;
    }

    private int valorMinimo(No no) {
        int minValor = no.valor;
        while (no.esquerda != null) {
            minValor = no.esquerda.valor;
            no = no.esquerda;
        }
        return minValor;
    }

    public void exibirArvore() {
        exibirArvoreRecursivo(raiz, 0);
    }

    private void exibirArvoreRecursivo(No atual, int nivel) {
        if (atual != null) {
            exibirArvoreRecursivo(atual.direita, nivel + 1);
            for (int i = 0; i < nivel; i++) {
                System.out.print("\t");
            }
            System.out.println(atual.valor);
            exibirArvoreRecursivo(atual.esquerda, nivel + 1);
        }
    }
}
