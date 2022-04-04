package Models;

public class Cliente extends Usuario{
    public Cliente(String nome){
        super(nome,TipoUsuario.CLIENTE);
    }
}
