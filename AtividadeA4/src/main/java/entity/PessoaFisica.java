package entity;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

public class PessoaFisica extends Cliente {

    private String cpf;
    private Date DataNascimento;
  

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String Cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(Date DataNascimento) {
        this.DataNascimento = DataNascimento;
    }

    public PessoaFisica(String cpf, Date DataNascimento, int id, String nome, String celular, String email, Date dataCadastro) {
        super(id, nome, celular, email, dataCadastro);
        this.cpf = cpf;
        this.DataNascimento = DataNascimento;
        

    }

    //public String getDados() {
       // StringBuilder sb = new StringBuilder();
       // SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
       // SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
      //  sb.append("\n");
      //  sb.append("Id do Cliente:");
      //  sb.append(this.getId());
      //  sb.append("\n");
     //   sb.append("Nome: ");
     //   sb.append(this.getNome());
     //   sb.append("\n");
     //   sb.append("Celular: ");
     //   sb.append(this.getCelular());
     //   sb.append("\n");
     //   sb.append("Email: ");
     //   sb.append(this.getEmail());
      //  sb.append("\n");
      //  sb.append("Data de Cadastro: ");
      //  sb.append(sdf.format(this.getDataCadastro()));
      //  sb.append("\n");
      //  sb.append("Cpf: ");
      //  sb.append(this.getCpf());
      //  sb.append("\n");
      //  sb.append("Data de Nascimento: ");
      //  sb.append(sdf.format(this.getDataNascimento()));
      //  sb.append("\n");
      //  sb.append("Veículos do cliente: ");
      //  sb.append(getVeiculos());
     //   sb.append("\n");
        
        

       // return sb.toString();
   // }

}
