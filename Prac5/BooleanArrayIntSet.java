public class BooleanArrayIntSet implements IntSet {
    private int size;
    private boolean [] elem;

    BooleanArrayIntSet(int max_num){
        size = 0;
        elem = new boolean[max_num + 1];

        for (int i = 0; i < max_num; i++) {
            elem[i]=false;
        }
    }

    public boolean contains(int x){ // Retorna true se x esta no conjunto
        if (x > elem.length-1) {
            return false;
            //throw new RuntimeException(x+" outside of range 0.."+(elem.length-1));         
        }

       return elem[x];
    }     

    public boolean add(int x){      // Adiciona x ao conjunto (devolve true se conseguir)
        if (x > elem.length-1) {
            return false;
            //throw new RuntimeException("Maximum size of set reached");         
        }

        elem[x] = true;
        size++;
        return true;
    }        

    public boolean remove(int x){        // Remove x do conjunto (devolve true se conseguir)
        if (contains(x)) {
            elem[x] = false; 
            size--;
            return true;            
        }
        return false;
    }

    public int size(){              // Num elem in set
        return size;
    }

    public void clear(){
        for (int i = 0; i < elem.length; i++) {
            elem[i]=false;
        }
        size=0;
    }              // Limpa o conjunto (torna-o vazio)

    // Metodos a adicionar (nao existentes na classe base)

    public boolean equals(IntSet s){        // Retorna true se ambos os conjuntos sao iguais
        for (int i = 0; i < elem.length; i++) {
            if(this.contains(i) != s.contains(i)){
                return false;
            }
        }

        return true;
    }    

    public IntSet intersection(IntSet s){
        BooleanArrayIntSet res = new BooleanArrayIntSet(this.elem.length);

        for (int i = 0; i < this.elem.length; i++) {
            if(this.contains(i) && s.contains(i)) res.add(i);
        }

        return res;
    }


    // public static void main(String[] args) {
    //     int n = 1000000;                      
    //     IntSet s = new BooleanArrayIntSet(n); // Criar array de booleanos para numeros no intervalo [1,n]
    //     boolean tmp;
            
    //     System.out.println("Adicionando todos os numeros entre 1 e " + n + "...");
    //     for (int i=1; i<=n; i++)
    //         tmp = s.add(i);
    
    //     System.out.println("Adicionando novamente todos os numeros entre 1 e " + n + "...");
    //     for (int i=1; i<=n; i++)
    //         tmp = s.add(i);
    
    //     System.out.println("Verificando se todos os numeros entre 1 e " + n + " existem...");
    //     for (int i=1; i<=n; i++)
    //         tmp = s.contains(i);
    
    //     System.out.println("Removendo todos os numeros entre 1 e " + n + "...");
    //     for (int i=1; i<=n; i++)
    //         tmp = s.remove(i);
    //     }
}
