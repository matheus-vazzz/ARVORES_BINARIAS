public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();
        arvoreBinaria.inserir(0);
        arvoreBinaria.inserir(-3);
        arvoreBinaria.inserir(-5);
        arvoreBinaria.inserir(-4);
        arvoreBinaria.inserir(5);
        arvoreBinaria.inserir(3);
        arvoreBinaria.inserir(4);
        arvoreBinaria.inserir(10);
        arvoreBinaria.inserir(7);
        arvoreBinaria.inserir(9);
        arvoreBinaria.exibir("Pos");
        System.out.println();

        // removendo nó folha
        arvoreBinaria.remover(-4);
        System.out.println("Árvore após remoção do nó folha");
        arvoreBinaria.exibir("Em");
        System.out.println();

        // removendo nó com um filho
        arvoreBinaria.remover(10);
        System.out.println("Árvore após remoção do nó com um filho");
        arvoreBinaria.exibir("Em");
        System.out.println();

        //removendo nó com dois filhos
        arvoreBinaria.remover(5);
        System.out.println("Árvore após remoção do nó com dois filhos");
        arvoreBinaria.exibir("Em");
        System.out.println();

        arvoreBinaria.exibir("Pós");
    }
}
