package com.mycompany.projeto.cadastro;
import com.mycompany.projeto.pessoa.Pessoa;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

public class CadastroPessoa implements Serializable{
  private List<Pessoa> pessoas = new ArrayList<>();

  public void inserir(Pessoa pessoa) throws Exception {
    int i = 0;
    try{
        
      buscarPorCpf(pessoa.getCpf());
    }
    catch(Exception e){
      
      pessoas.add(pessoa);

      i = 1;
    }
    if(i == 0){
      throw new Exception("PESSOA JÁ EXISTE!");
    }
    
  }

  public Pessoa buscarPorCpf(String cpf)throws Exception{
    for(Pessoa pes: pessoas){
      if(pes.getCpf().equals(cpf)){
        return pes;
      }
    }
    throw new Exception("PESSOA NÃO EXISTE!");
  }

  public void remover(Pessoa pessoa)throws Exception{
    try{
      Pessoa pes = buscarPorCpf(pessoa.getCpf());
      pessoas.remove(pes);
    }
    catch(Exception e){
      throw e;
    }
  }
}