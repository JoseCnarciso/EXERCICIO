package Models;
import java.util.Date;

public class Produto {
    private int id;
    private String descrição;
    private double preco;
    private Date dataValidade;

    public Produto( int id, String descrição, double preco, Date dataValidade ) {
        this.id = id;
        this.descrição = descrição;
        this.preco = preco;
        this.dataValidade = dataValidade;

    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição( String descrição ) {
        this.descrição = descrição;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco( double preco ) {
        this.preco = preco;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade( Date dataValidade ) {
        this.dataValidade = dataValidade;
    }
}
