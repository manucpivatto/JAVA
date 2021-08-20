package entity;

public class Modelo {

    private int id;
    private String descricao;
    private Marca marca;
    private ECategoria categoria;

    public Modelo() {
        this.categoria = ECategoria.PADRAO;
    }

    public Modelo(String descricao, Marca marca) {
        this.descricao = descricao;
        this.marca = marca;
        this.categoria = ECategoria.PADRAO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public ECategoria getCategoria() {
        return categoria;
    }

    public void setCategoria(ECategoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Modelo{" + "id=" + id + ", descricao=" + descricao + ", marca=" + marca + ", categoria=" + categoria + '}';
    }

    
} 
