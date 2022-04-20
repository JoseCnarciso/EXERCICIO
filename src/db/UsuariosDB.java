package db;

import Models.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuariosDB {
    private List<Usuario>usuarioList = new ArrayList<>();

    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }
    // cria se o método getUsuariosPorId para procurarmos os usuarios por id
    public Usuario getUsuariosPorId(int id){
        // retorna a busca da lista de usuários usando a api strean
       return  usuarioList.stream()
               // na api usamos o filtro para procurar somente usuários que digitamos a ID
                .filter(usuario -> usuario.getId() == id)
                .findFirst()
                .get();
    }
    public void addNovoUsuario(Usuario usuario) {
        //cria-se a variavel "id" que sempre adiciona o novo "dado" item a lista
        int id = usuarioList.size() + 1;
        usuario.setId(id);
        usuarioList.add(usuario);
    }

}
