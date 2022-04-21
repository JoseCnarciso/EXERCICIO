package db;

import Models.Estoque;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EstoqueDB {
    private Map<String,Estoque> estoqueDBMap = new HashMap<>();


    public Map<String, Estoque> getEstoqueDBMap() {
        return estoqueDBMap;
    }
    // cria-se uma lista de estoque para armazenar os dados cadastrados no estoque
    public  List<Estoque>getEstoques(){
        List<Estoque>estoques = new ArrayList<>();
        for (Map.Entry<String, Estoque> estoque : estoqueDBMap.entrySet()) {
            estoques.add((estoque.getValue()));
        }
        return estoques;
    }
    // cria se um novo método para retornar o getEstoqueById
    public Estoque getEstoqueById(String id){
       return estoqueDBMap.get(id);
    }

    //cria-se um novo objeto para receber os dados cadastrados
    public void addNovoEstoque( Estoque estoque){
        estoqueDBMap.put(estoque.getId(),estoque);
    }
}

