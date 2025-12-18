package com.br.nadson.sistema_de_biblioteca.principal;

import com.br.nadson.sistema_de_biblioteca.modelo.Usuario;

public class Main {
    public static void main(String[] args) {
        Usuario u1=new Usuario("João",15);
        Usuario u2=new Usuario("Pedro", 45);
        System.out.println(u1.apresentar());
        System.out.println("_________  __");
        System.out.println(u2.apresentar());
    }
}
