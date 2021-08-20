package entity;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import exceptions.ExceptionLavacao;

public abstract class Cliente {

    private int id;
    private String nome;
    private String celular;
    private String email;
    private Date dataCadastro;
    private List<Veiculo> veiculos;
    private List<OrdemServico> historicoCliente;

	private Pontuacao pontuacao;

    public Cliente(int id, String nome, String celular, String email, Date dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.celular = celular;
        this.email = email;
        this.dataCadastro = dataCadastro;
        this.veiculos = new ArrayList<>();
        this.historicoCliente = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;

    }
    
    public Pontuacao getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Pontuacao pontuacao) {
        this.pontuacao = pontuacao;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public void add(Veiculo veiculo) {
        veiculos.add(veiculo);

    }

    public void remove(Veiculo veiculo) throws ExceptionLavacao {

        if (!veiculos.contains(veiculo)) {

            throw new ExceptionLavacao("Não há veículos para remover");
        }

        veiculos.remove(veiculo);

    }
    
    public List<OrdemServico> getHistoricoCliente() {
		return historicoCliente;
	}
    
    public void adicionarOrdemDeServicoAoHistorico(OrdemServico ordemServico) {
    	historicoCliente.add(ordemServico);
    }

}
