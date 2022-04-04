package db;

import Models.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuariosDB {
    private List<Usuario>usuarioList = new ArrayList<>();

    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }
    public void addNovoUsuario(Usuario usuario) {
        //cria-se a variavel "id" que sempre adiciona o novo "dado" item a lista
        int id = usuarioList.size() + 1;
        usuario.setId(id);
        usuarioList.add(usuario);
    }
}
