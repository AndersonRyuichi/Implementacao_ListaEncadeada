public class Main {
    public static void main(String[] args) throws Exception {
        ListaEncadeada lista = new ListaEncadeada();
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("=-=-=-=-=  Lista Encadeada  =-=-=-=-=");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        lista.inPrimeiro(4);
        lista.inUltimo(7);
        lista.inPrimeiro(1);

        lista.inOrdenado(3);
        lista.imprime();
        Node nodeSendoProcurado = lista.peNode(1);
        lista.reNode(nodeSendoProcurado);
        lista.imprime();
    }
}

public class Node {
    public int _info;
    public Node _prox;

    public Node(int info) { _info = info; }

    public Node(Node prox, int info) {
        _info = info;
        _prox = prox;
    }

    public Node(){} // Serve para o imprime
}

public class ListaEncadeada {
    private Node _primeiro;

    public ListaEncadeada(){
        _primeiro = null;
    }

    public boolean isVazia() { return _primeiro == null; }  // Verifica se esta vazia

    public Node peNode(int info) throws Exception{
        Node nodeFoco = _primeiro;
        while(true){
            if(nodeFoco._info == info){
                return nodeFoco;
            }
            else if(nodeFoco._prox == null){
                throw new Exception("O node procurado, nao foi encontrado!");
            }
            else{
                nodeFoco = nodeFoco._prox;
            }
        }
    }

    public void inPrimeiro(int info){
        if(isVazia()) { _primeiro = new Node(info); } // Se a lista nao apresentar nenhum node, ele vai somente criar um novo node;
        else {
            Node infoSalvo = _primeiro; // Salva os elementos da lista;
            _primeiro = new Node(info); // criacao do node;
            _primeiro._prox = infoSalvo; // Adiciona a lista somente apos do node criado na linha acima;
        }
    }

    public void inDepois(Node nodeSendoProcurado, int info) throws Exception{
        if(isVazia()){ throw new Exception("A lista esta vazia"); } // Lanca um exception de erro
        else {
            Node nodeQEstamos = _primeiro; //(infoSalvo.prox == null) ||
            while(nodeSendoProcurado != nodeQEstamos){
                if(nodeQEstamos._prox == null)
                    throw new Exception(""); // nao foi encontrado o node especificado
                nodeQEstamos = nodeQEstamos._prox;
            }
            Node nodeSalvo = nodeQEstamos._prox;
            nodeQEstamos._prox = new Node(info);
            nodeQEstamos._prox._prox = nodeSalvo;
            }
        }

    public void inUltimo(int info){
        if(isVazia()) { _primeiro = new Node(info); } //
        else {
            Node nodePrimeiros = _primeiro; // Salva os elementos da lista;
            while(nodePrimeiros._prox != null){ // Enquanto o proximo de um node for diferente de null, ele nao vai criar um novo node;
                nodePrimeiros = nodePrimeiros._prox;
            }
            nodePrimeiros._prox = new Node(info);
        }
    }

    public void inOrdenado(int info) throws Exception {
        if(isVazia()) { // Se a lista nao apresentar nenhum node, ele vai somente criar um novo node;
            _primeiro = new Node();
        }
        else {
            Node nodeFoco = _primeiro;
            while(true){
                if((nodeFoco._prox == null) || (nodeFoco._info < info && nodeFoco._prox._info > info)){
                    inDepois(nodeFoco,info);
                    break;
                }
                nodeFoco = nodeFoco._prox;
            }
        }
    }

    public void imprime() throws Exception{
        Node nodeFoco = _primeiro;
            while(nodeFoco != null){
                System.out.print("[");
                System.out.print(nodeFoco._info);
                System.out.print("]");
                if(nodeFoco._prox != null)
                    System.out.print(", ");
                else{
                    System.out.print(". ");
                }
                nodeFoco = nodeFoco._prox;
            }
    }

    public Node rePrimeiro() throws Exception{
        if(isVazia()) { System.out.println("A lista se encontra vazia, por isso nao e possivel retirar nenhuma valor"); }
        else{
            Node infoSalvo = _primeiro; // Salva os elementos da lista;
            _primeiro = _primeiro._prox;

            return infoSalvo;
        }
        return null;
    }
    
    public Node reUltimo() throws Exception{
        if(isVazia()) { System.out.println("A lista se encontra vazia, por isso nao e possivel retirar nenhuma valor"); }
        else{
            boolean umNode = _primeiro._prox == null;
            if(umNode)
                return rePrimeiro();
            else{
                Node penultimoNode = _primeiro; // Dar um jeito desse 'lista' pegar o penultimo
                Node ultimo = penultimoNode._prox;
                penultimoNode._prox = null;
                return ultimo;
            }
        }
        return null;
    }

    public Node reNode(Node no) throws Exception {
        if (isVazia()) {
            System.out.println("A lista se encontra vazia, por isso nao e possivel retirar nenhuma valor");
        }
        else {
            Node nodeFoco = _primeiro;

            while (nodeFoco._prox != no) {
                nodeFoco._prox = no._prox;
                if (nodeFoco._prox == null)
                    throw new Exception("Este node nao esta apresentado no caso!");
                nodeFoco = nodeFoco._prox;
            }
            Node nodeGuardado = nodeFoco._prox;
            nodeFoco._prox = null;
        }
        return no;
    }
}
