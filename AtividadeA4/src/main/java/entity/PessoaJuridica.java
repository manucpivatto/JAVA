package entity;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

public class PessoaJuridica extends Cliente {

    private String cnpj;
    private String inscricaoEstadual;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public PessoaJuridica(String cnpj, String inscricaoEstadual, int id, String nome, String celular, String email, Date dataCadastro) {
        super(id, nome, celular, email, dataCadastro);
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getDados() {
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        sb.append("\n");
        sb.append("Id do Cliente:");
        sb.append(this.getId());
        sb.append("\n");
        sb.append("Nome: ");
        sb.append(this.getNome());
        sb.append("\n");
        sb.append("Celular: ");
        sb.append(this.getCelular());
        sb.append("\n");
        sb.append("Email: ");
        sb.append(this.getEmail());
        sb.append("\n");
        sb.append("Data de Cadastro: ");
        sb.append(sdf1.format(this.getDataCadastro()));
        sb.append("\n");
        sb.append("Cnpj: ");
        sb.append(this.getCnpj());
        sb.append("\n");
        sb.append("Inscrição Estadual: ");
        sb.append(this.getInscricaoEstadual());
        sb.append("\n");
        sb.append("Veículos do cliente: ");
        sb.append(this.getVeiculos());
        sb.append("\n");
        
        

        return sb.toString();
    }

}
