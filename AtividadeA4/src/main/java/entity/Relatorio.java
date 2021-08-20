package entity;

import java.text.SimpleDateFormat;

public class Relatorio {

    public String imprimir(Cliente cliente) {

        StringBuilder sb = new StringBuilder();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");

        sb.append("Relatório: ");
        sb.append("\n");
        sb.append("Id do Cliente:");
        sb.append(cliente.getId());
        sb.append("\n");
        sb.append("Nome: ");
        sb.append(cliente.getNome());
        sb.append("\n");
        sb.append("Celular: ");
        sb.append(cliente.getCelular());
        sb.append("\n");
        sb.append("Email: ");
        sb.append(cliente.getEmail());
        sb.append("\n");
        sb.append("Data de Cadastro: ");
        sb.append(sdf.format(cliente.getDataCadastro()));
        sb.append("\n");
        sb.append("Veículos do cliente: ");
        sb.append(cliente.getVeiculos());
        sb.append("\n");
        sb.append("Pontuação: ");
        sb.append(cliente.getPontuacao().getQuantidade());

        if (cliente instanceof PessoaFisica) {
            sb.append("Cpf: ");
            sb.append(((PessoaFisica) cliente).getCpf());
            sb.append("\n");
            sb.append("Data de Nascimento: ");
            sb.append(sdf.format(((PessoaFisica) cliente).getDataNascimento()));
            sb.append("\n");

        } else {
            sb.append("Cnpj: ");
            sb.append(((PessoaJuridica)cliente).getCnpj());
            sb.append("\n");
            sb.append("Inscrição Estadual: ");
            sb.append(((PessoaJuridica)cliente).getInscricaoEstadual());
            sb.append("\n");

        }
        
        for (OrdemServico ordemServico : cliente.getHistoricoCliente()) {
        	// para cada uma das ordens de serviço no histórico do cliente, vai iterar e imprimir os dados da ordem
        	sb.append("\n\n");
        	
        	sb.append("=== Ordem de Serviço nro ").append(ordemServico.getNumero()).append(" ===\n\n");
        	sb.append("Veiculo: ").append(ordemServico.getVeiculo().getModelo().getDescricao());
        	sb.append(" | Placa ").append(ordemServico.getVeiculo().getPlaca());
        	
        	sb.append("\n\n= Itens da OS:\n\n");
        	int i = 1;
        	
        	for (ItemOS item : ordemServico.getItem()) {
        		sb.append(i).append(". ").append(item.getServico().getDescricao());
        		sb.append(" -> valor unitário: R$").append(item.getValorServico()).append("\n");
        	}
        	
        	sb.append("\n");
        	sb.append("Total (sem descontos): R$ ").append(ordemServico.getTotal()).append("\n");
        	sb.append("Descontos: R$ ").append(ordemServico.getDesconto()).append("\n");
        	sb.append("Total: R$ ").append(ordemServico.getTotal() - ordemServico.getDesconto()).append("\n");
        	
        	
        }
        return sb.toString();
    }
}
