public class ArvoreBinaria {
    No raiz;

    public ArvoreBinaria() {
        this.raiz = new No(null);
        System.out.println("Árvore Binária criada com sucesso!");
    }

//    public void inserir(Integer conteudo) {
//        No novoNo = new No(conteudo);
//
//        if(estaVazia()) {
//            this.raiz = novoNo;
//        } else {
//            No aux = this.raiz;
//            while(true) {
//                if (aux.getConteudo() > novoNo.getConteudo()) {
//                    if (aux.getEsquerda() == null) {
//                        aux.setEsquerda(novoNo);
//                        return;
//                    } else {
//                        aux = aux.getEsquerda();
//                    }
//                } else if (aux.getConteudo() == novoNo.getConteudo()) {
//                    System.out.println("Não é possível informar nós repetidos.");
//                    return;
//                } else {
//                    if (aux.getDireita() == null) {
//                        aux.setDireita(novoNo);
//                        return;
//                    } else {
//                        aux = aux.getDireita();
//                    }
//                }
//            }
//        }
//    }

    public void inserir(Integer conteudo) {
        No novoNo = new No(conteudo);

        if(estaVazia()) {
            this.raiz = novoNo;
        } else {
            inserirRecursivo(novoNo, this.raiz);
        }
    }

    public void inserirRecursivo(No novoNo, No atual) {
        if (atual.getConteudo() > novoNo.getConteudo()) {
            if (atual.getEsquerda() == null) {
                atual.setEsquerda(novoNo);
                System.out.println("O nó " + novoNo.getConteudo() + " foi inserido na Árvore.");
                return;
            } else {
                inserirRecursivo(novoNo, atual.getEsquerda());
            }
        } else if (atual.getConteudo() == novoNo.getConteudo()) {
            System.out.println("Não é possível informar nós repetidos.");
            return;
        } else {
            if (atual.getDireita() == null) {
                atual.setDireita(novoNo);
                System.out.println("O nó " + novoNo.getConteudo() + " foi inserido na Árvore.");
                return;
            } else {
                inserirRecursivo(novoNo, atual.getDireita());
            }
        }
    }

    public boolean estaVazia() {
        if(this.raiz.getConteudo() == null) {
            return true;
        } else {
            return false;
        }
    }

    private void preOrdem(No no) {
        if(no == null) {
            return;
        }
        System.out.println(no.getConteudo());
        preOrdem(no.getEsquerda());
        preOrdem(no.getDireita());
    }

    private void emOrdem(No no) {
        if(no == null) {
            return;
        }
        emOrdem(no.getEsquerda());
        System.out.println(no.getConteudo());
        emOrdem(no.getDireita());
    }

    private void posOrdem(No no) {
        if(no == null) {
            return;
        }
        posOrdem(no.getEsquerda());
        posOrdem(no.getDireita());
        System.out.println(no.getConteudo());
    }

    public void exibir(String percurso) {
        switch (percurso){
            case("Pre"):
                preOrdem(this.raiz);
                break;
            case("Em"):
                emOrdem(this.raiz);
                break;
            case("Pos"):
                posOrdem(this.raiz);
                break;
        }
    }

    public void remover(Integer valor) {
        if (estaVazia()) return;    
        this.raiz = removerRecursivo(this.raiz, valor);
        if (this.raiz == null) this.raiz = new No(null);
    }

    private No removerRecursivo(No atual, Integer valor) {
        if (atual == null || atual.getConteudo() == null) return null;

        if (valor < atual.getConteudo()) {
            atual.setEsquerda(removerRecursivo(atual.getEsquerda(), valor));
        } else if (valor > atual.getConteudo()) {
            atual.setDireita(removerRecursivo(atual.getDireita(), valor));
        } else {
            if (atual.getEsquerda() == null && atual.getDireita() == null) return removerNoFolha(atual);
            if (atual.getEsquerda() == null || atual.getDireita() == null) return removerNoUmFilho(atual);
            return removerNoDoisFilhos(atual); 
        }
        return atual;
    }

    private No removerNoFolha(No no) {
        return null;
    }

    private No removerNoUmFilho(No no) {
        if (no.getEsquerda() != null) {
            return no.getEsquerda();
        } else {
            return no.getDireita();
        }
    }

    private No removerNoDoisFilhos(No no) {
        No sucessor = procurarSucessor(no.getDireita());
        no.setConteudo(sucessor.getConteudo());
        no.setDireita(removerRecursivo(no.getDireita(), sucessor.getConteudo())); 
        return no;
    }

    private No procurarSucessor(No no) {
        No atual = no;
        while (atual.getEsquerda() != null) {
            atual = atual.getEsquerda();
        }
        return atual;
    }
}
