package entity;

import exceptions.ExceptionLavacao;

public class Pontuacao {

    private int quantidade;

    public Pontuacao(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int adicionar(int quantidade) {
        this.quantidade = this.quantidade + quantidade;

        return quantidade;
    }

    public int subtrair(int quantidade) throws ExceptionLavacao {

        if (quantidade > this.quantidade) {

            throw new ExceptionLavacao("Não há pontos suficientes para realizar o procedimento!");

        } else {

            this.quantidade = this.quantidade - quantidade;

            return quantidade;
        }
        
    }

    public int saldo() {

        return quantidade;
    }

}
