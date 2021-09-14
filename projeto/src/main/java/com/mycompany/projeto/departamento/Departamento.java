package com.mycompany.projeto.departamento;

import java.io.Serializable;

public enum Departamento implements Serializable{
  TI("TI"),
  RH("RH"),
  COMERCIAL("Comercial"),
  ADMNISTRATIVO("Administrativo");
  

  private String nome;

  Departamento(String nome){
    this.nome = nome;
  }

  public String getNome(){
    return this.nome;
  }
}