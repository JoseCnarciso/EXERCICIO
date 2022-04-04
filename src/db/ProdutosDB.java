package db;
import Models.Produto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProdutosDB {
    private Map<Integer,Produto> produtosMap = new HashMap<>();

    public List<Produto> getProdutosList() {
        // cria-se uma lista para adicionar cada entrada de produto no HashMap
        List<Produto>produtos = new ArrayList<>();
        // cria-se  um map (lista de produtos) chamada entrySet que percorre todas as listas
       for (Map.Entry<Integer,Produto>produto : produtosMap.entrySet()){
           produtos.add(produto.getValue());

       }
       return produtos;
    }
    public void addNovoProduto( Produto produto){
        produtosMap.put(produto.getId(),produto);
    }

    public Produto getProdutoPorID(int id){
       return produtosMap.get(id);

    }

}
