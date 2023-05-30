/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.seguradora;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner ler = new Scanner(System.in);
        Seguradora seguradora = new Seguradora();
        int nSeguroSaude = 0, nSeguroAutomovel = 0;
        int clienteId = 1, seguroId = 1;
      
        int opcao = 0;
      
        while (opcao != 7) {
            System.out.println("----- Menu -----");
            System.out.println("1. Registar Seguro");
            System.out.println("2. Consultar Seguro");
            System.out.println("3. Ver Lista de Seguros");
            System.out.println("4. Atualizar Seguro");
            System.out.println("5. Remover Seguro");
            System.out.println("6. Estatistica");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = ler.nextInt();
          
            switch (opcao) {
                case 1:
                    System.out.println("\n--- Registar Seguro ---");
                    System.out.println("1. Seguro de Saúde");
                    System.out.println("2. Seguro Automóvel");
                    System.out.print("Escolha o tipo de seguro: ");
                    int tipoSeguro = ler.nextInt();
                  
                    Cliente cliente = new Cliente();
                    cliente.setId(clienteId++);
                    System.out.print("Nome: ");
                    cliente.setNome(ler.next());
                    System.out.print("BI: ");
                    cliente.setBI(ler.next());

                    Endereco endereco = new Endereco();
                    System.out.println("Endereço:");
                    System.out.print("Rua: ");
                    endereco.setRua(ler.next());
                    System.out.print("Cidade: ");
                    endereco.setCidade(ler.next());
                    System.out.print("Bairro: ");
                    endereco.setBairro(ler.next());
                    cliente.setEndereco(endereco);

                    Contacto contacto = new Contacto();
                    System.out.println("Contato:");
                    System.out.print("Telefone: ");
                    contacto.setTelefone(ler.next());
                    System.out.print("Email: ");
                    contacto.setEmail(ler.next());
                    cliente.setContacto(contacto);
                  
                    Seguro novoSeguro;
                  
                    if (tipoSeguro == 1) {
                        SeguroSaude seguroSaude = new SeguroSaude();
                        seguroSaude.setCliente(cliente);
                        System.out.println("Plano de Saude");
                        seguroSaude.setPlanoSaude(ler.next());
                        nSeguroSaude++;
                      
                        novoSeguro = seguroSaude;
                        novoSeguro.setId(seguroId++);
                    } else if (tipoSeguro == 2) {
                        SeguroAutomovel seguroAutomovel = new SeguroAutomovel();
                        seguroAutomovel.setCliente(cliente);
                        System.out.println("Modelo");
                        seguroAutomovel.setModelo(ler.next());
                        System.out.println("Placa");
                        seguroAutomovel.setPlaca(ler.next());
                        nSeguroAutomovel++;
                      
                        novoSeguro = seguroAutomovel;
                        novoSeguro.setId(seguroId++);
                    } else {
                        System.out.println("Opção inválida.");
                        break;
                    }
                  
                    // Registar o novo seguro na seguradora
                    seguradora.registarSeguro(novoSeguro);
                    break;
              
                case 2:
                    System.out.println("\n--- Consultar Seguro ---");
                    System.out.print("ID do Seguro: ");
                    int idSeguro = ler.nextInt();
                    seguradora.consultarSeguro(idSeguro);
                    break;
              
                case 3:
                    System.out.println("\n--- Ver Lista de Seguros ---");
                    seguradora.verListaSeguro();
                    break;
              
                case 4:
                    System.out.println("\n--- Atualizar Seguro ---");
                    System.out.print("ID do Seguro: ");
                    int idSeguroAtualizar = ler.nextInt();
                    
                    String tipo = seguradora.tipoSeguro(idSeguroAtualizar);
                    
                    Seguro seguroAtualizado = new Seguro();
                    
                    if (tipo == "saude") {
                        SeguroSaude seguroSaude = new SeguroSaude();
                        System.out.println("Plano de Saude");
                        seguroSaude.setPlanoSaude(ler.next());
                      
                        seguroAtualizado = seguroSaude;
                    seguradora.atualizarSeguro(idSeguroAtualizar, seguroAtualizado);
                    } else if (tipo == "automovel") {
                        SeguroAutomovel seguroAutomovel = new SeguroAutomovel();
                        System.out.println("Modelo");
                        seguroAutomovel.setModelo(ler.next());
                        System.out.println("Placa");
                        seguroAutomovel.setPlaca(ler.next());
                      
                        seguroAtualizado = seguroAutomovel;
                    seguradora.atualizarSeguro(idSeguroAtualizar, seguroAtualizado);
                    } else {
                        System.out.println("Opção inválida.");
                        break;
                    }
                 
                  
                    break;
              
                case 5:
                    System.out.println("\n--- Remover Seguro ---");
                    System.out.print("ID do Seguro: ");
                    int idSeguroRemover = ler.nextInt();
                    String t = seguradora.tipoSeguro(idSeguroRemover);
                    
                    if (t == "saude") {
                        seguradora.removerSeguro(idSeguroRemover);
                        nSeguroSaude--;
                    } else if (t == "automovel") {
                        seguradora.removerSeguro(idSeguroRemover);
                        nSeguroAutomovel--;
                    } else {
                        System.out.println("Opção inválida.");
                        break;
                    }
                    seguradora.removerSeguro(idSeguroRemover);
                    break;
              
                case 6:
                    System.out.println("Estatísticas:");
                    System.out.println("Seguros de Saude: " + nSeguroSaude);
                    System.out.println("Seguro Automovel: " + nSeguroAutomovel);
                    break;
                case 7:
                    System.out.println("Saindo...");
                    break;
              
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
            System.out.println();
        }
      
        ler.close();
    }
}
