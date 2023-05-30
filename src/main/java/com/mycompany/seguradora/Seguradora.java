/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.seguradora;

import java.util.ArrayList;

public class Seguradora {
    private ArrayList<Seguro> seguros;
  
    public Seguradora() {
        seguros = new ArrayList<>();
    }
  
    public void registarSeguro(Seguro seguro) {
        seguros.add(seguro);
        System.out.println("Seguro registado com sucesso.");
    }
  
    public void consultarSeguro(int id) {
        for (Seguro seguro : seguros) {
            if (seguro.getId() == id) {
                System.out.println("Detalhes do Seguro:");
                System.out.println("ID: " + seguro.getId());
                System.out.println("Tipo: " + seguro.getTipo());
                System.out.println("Cliente: " + seguro.getCliente().getNome());
                if (seguro instanceof SeguroSaude) {
                    SeguroSaude seguroSaude = (SeguroSaude) seguro;
                    System.out.println("Plano de Saúde: " + seguroSaude.getPlanoSaude());
                } else if (seguro instanceof SeguroAutomovel) {
                    SeguroAutomovel seguroAutomovel = (SeguroAutomovel) seguro;
                    System.out.println("Modelo: " + seguroAutomovel.getModelo());
                    System.out.println("Placa: " + seguroAutomovel.getPlaca());
                }
                return;
            }
        }
        System.out.println("Seguro não encontrado.");
    }
  
    public void verListaSeguro() {
        System.out.println("Lista de Seguros:");
        for (Seguro seguro : seguros) {
            System.out.println("ID: " + seguro.getId());
            System.out.println("Tipo: " + seguro.getTipo());
            System.out.println("Cliente: " + seguro.getCliente().getNome());
            System.out.println("--------------------------");
        }
    }
  
    public void atualizarSeguro(int id, Seguro novoSeguro) {
        for (int i = 0; i < seguros.size(); i++) {
            Seguro seguro = seguros.get(i);
            if (seguro.getId() == id) {
                novoSeguro.setId(seguro.getId());
                novoSeguro.setCliente(seguro.getCliente());
                seguros.set(i, novoSeguro);
                System.out.println("Seguro atualizado com sucesso.");
                return;
            }
        }
        System.out.println("Seguro não encontrado.");
    }
    
    public String tipoSeguro(int id) {
        for (int i = 0; i < seguros.size(); i++) {
            Seguro seguro = seguros.get(i);
            if (seguro.getId() == id) {
                return seguro.getTipo();
            }
        }
//        System.out.println("Seguro não encontrado.");
        return "";
    }
  
    public void removerSeguro(int id) {
        for (int i = 0; i < seguros.size(); i++) {
            Seguro seguro = seguros.get(i);
            if (seguro.getId() == id) {
                seguros.remove(i);
                System.out.println("Seguro removido com sucesso.");
                return;
            }
        }
        System.out.println("Seguro não encontrado.");
    }
  
    public int obterNumeroSegurosRegistrados() {
        return seguros.size();
    }
    
    
}
