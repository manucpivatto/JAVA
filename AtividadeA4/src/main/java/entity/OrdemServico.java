package entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdemServico {

    private long numero;
    private double total;
    private Date agenda;
    private double desconto;
    private Veiculo veiculo;
    private EStatus status;
    private List<ItemOS> item;
    private Servico servico;

    public OrdemServico(long numero, double total, Date agenda, double desconto, Veiculo veiculo, EStatus status) {
        this.numero = numero;
        this.total = total;
        this.agenda = agenda;
        this.desconto = desconto;
        this.veiculo = veiculo;
        this.status = status;
        this.item = new ArrayList<>();
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getAgenda() {
        return agenda;
    }

    public void setAgenda(Date agenda) {
        this.agenda = agenda;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public EStatus getStatus() {
        return status;
    }

    public void setStatus(EStatus status) {
        this.status = status;
    }

    public List<ItemOS> getItem() {
        return item;
    }

    public void setItem(List<ItemOS> item) {
        this.item = item;
    }

    public double CalcularServico() {
        this.total = servico.getValor() - (servico.getValor() * desconto / 100);
        return total;
    }

    public void add(ItemOS itemOS) {
        item.add(itemOS);
        this.total += itemOS.getValorServico();
    }

    public void remove(ItemOS itemOS) {
        item.remove(itemOS);
        this.total -= itemOS.getValorServico();
    }
    
    public String getDados() {
        StringBuilder sb = new StringBuilder();
        
        SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy");
        
        sb.append("Número ordem serviço: ");
        sb.append(this.numero);
        sb.append("\n");
        sb.append("Valor Total: ");
        sb.append(this.total);
        sb.append("\n");
        sb.append("Agendamento: ");
        sb.append(this.agenda);
        sb.append("\n");
        sb.append("Veiculo: ");
        sb.append(this.veiculo);
        sb.append("\n");
        sb.append("Status: ");
        sb.append(this.status);
        sb.append("\n");
        sb.append("Lista de itens: ");
        sb.append(this.item);
        sb.append("\n");
        sb.append("Serviço: ");
        sb.append(this.servico);
        sb.append("\n");
        
        
        return toString();
    }

    @Override
    public String toString() {
        return "OrdemServico{" + "numero=" + numero + ", total=" + total + ", agenda=" + agenda + ", desconto=" + desconto + ", veiculo=" + veiculo + ", status=" + status + ", item=" + item + ", servico=" + servico + '}';
    }
    
    

}
