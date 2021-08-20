package app;

import entity.Marca;
import entity.Modelo;
import entity.Veiculo;
import entity.Cliente;
import entity.Cor;
import entity.ECategoria;
import entity.EStatus;
import entity.ItemOS;
import entity.PessoaFisica;
import entity.PessoaJuridica;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import entity.Pontuacao;
import entity.Servico;
import exceptions.ExceptionLavacao;
import entity.Relatorio;
import entity.OrdemServico;

public class MainApp {
	
	private static Servico lavacao;
	private static Servico espelhamento;
	private static Servico polimento;

    public static void main(String[] args) throws Exception {
    	criarListaDeServicos();
    	

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dataNascimento = sdf.parse("08/04/1988");

        Date dataCadastro = sdf.parse("20/10/2020");

        Date dataAgendamento = sdf.parse("05/10/2020");

        Servico.setPontos(10);

        PessoaFisica p1 = new PessoaFisica("081.546.254-37", dataNascimento, 1, "Jorel", "(47)99965412", "jorel@hotmail.com", dataCadastro);
        PessoaJuridica p2 = new PessoaJuridica("04.489.555/4444-89", "SC", 2, "Automoveis LTDA", "(48)999954887", "joao@gmail.com", dataCadastro);
        p1.setPontuacao(new Pontuacao(100));
        p2.setPontuacao(new Pontuacao(200));
        
        
        
      
        try {

            p1.getPontuacao().subtrair(150);
        } catch (ExceptionLavacao ex) {
            System.out.println("Erro!" + ex.getMessage());

        }

        Veiculo veiculo1 = new Veiculo("KLMN", new Modelo("Onix", new Marca("Chevrolet")));
        veiculo1.getModelo().setId(2);
        veiculo1.getModelo().getMarca().setId(3);
        veiculo1.setCor(new Cor("Azul"));
        veiculo1.getCor().setId(4);
        veiculo1.setId(1);
        veiculo1.setObservacoes("Hatch");
        veiculo1.getModelo().setCategoria(ECategoria.MEDIO);
        

        Veiculo veiculo2 = new Veiculo("XXGP", new Modelo("Palio", new Marca("Fiat")));
        veiculo2.getModelo().setId(2);
        veiculo2.getModelo().getMarca().setId(3);
        veiculo2.setCor(new Cor("Branco"));
        veiculo2.getCor().setId(4);
        veiculo2.setId(1);
        veiculo2.setObservacoes("Hatch");

        p1.add(veiculo1);
        p2.add(veiculo2);

        OrdemServico ordem = new OrdemServico(2555l, 350.0, dataAgendamento, 0.0, veiculo1, EStatus.ABERTA);

        // try {                                              /Caso queira remover um veículo que não esteja na lista
        //     p2.remove(veiculo1);
        // } catch (ExceptionLavacao ex) {
        //    System.out.println("Erro!" + ex.getMessage());
        // }
        Relatorio rel = new Relatorio();
        System.out.println("Pessoa Física");
        System.out.println(rel.imprimir(p1)+ordem);
        System.out.println("\n");
        System.out.println("x-x-x-x-x-x-x-x-x-x-x-x");
        System.out.println("Pessoa Jurídica");
        System.out.println(rel.imprimir(p2));
        
        // ==========================================================================================
        imprimirSeparador();
        
        Veiculo chevetteDoJoao = new Veiculo("ABC12345", new Modelo("Chevette", new Marca("Chevrolet")));
        Cliente joao = new PessoaFisica("00000000191", sdf.parse("01/01/1950"), 1, "João", "2345678", "joao@empresa.com", sdf.parse("20/08/2020"));
        joao.setPontuacao(new Pontuacao(0));
        chevetteDoJoao.setCliente(joao);
        joao.add(chevetteDoJoao);
        
        OrdemServico banhoNoChevette = new OrdemServico(25278346, 0d, sdf.parse("30/08/2020"), 30d, chevetteDoJoao, EStatus.ABERTA);
        ItemOS itemBanhoNoChevette = new ItemOS();
        itemBanhoNoChevette.setServico(lavacao);
        itemBanhoNoChevette.setValorServico(lavacao.getValor());
        itemBanhoNoChevette.setObservacoes("O professor da manu é um idiota!");
        banhoNoChevette.add(itemBanhoNoChevette);
        joao.adicionarOrdemDeServicoAoHistorico(banhoNoChevette);
        
        Relatorio relatorioDoJoao = new Relatorio();
        System.out.println(relatorioDoJoao.imprimir(joao));

    }
    
    private static void criarListaDeServicos() {
    	Servico.setPontos(10);
    	
    	polimento = new Servico();
    	polimento.setDescricao("Polimento");
    	polimento.setCategoria(ECategoria.PADRAO);
    	polimento.setId(1);
    	polimento.setValor(50d);
    	
    	lavacao = new Servico();
    	lavacao.setDescricao("Lavação");
    	lavacao.setCategoria(ECategoria.PADRAO);
    	lavacao.setId(2);
    	lavacao.setValor(80d);
    	
    	espelhamento = new Servico();
    	espelhamento.setDescricao("Espelhamento");
    	espelhamento.setCategoria(ECategoria.PADRAO);
    	espelhamento.setId(3);
    	espelhamento.setValor(100d);
    }
    
    private static void imprimirSeparador() {
    	System.out.println("################################################################################");
    	System.out.println("################################################################################\n\n");
    }

}
