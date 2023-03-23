package com.example.practica.Servicios;

import com.example.practica.Entidades.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Vector;

public class servicioUsuario {

    ArrayList<Usuario> lista= new ArrayList<>();

    public  servicioUsuario(){
        lista.add(new Usuario(10,"Arturo","colombia",LocalDate.of(2023,02,28),"Arturo@mail.com"));
        lista.add(new Usuario(11,"Pablo","Ecuador",LocalDate.of(2023,03,14),"Pablo@mail.com"));
        lista.add(new Usuario(12,"Juan","Polonia",LocalDate.of(2023,04,16),"Juan@mail.com"));
    }

    public ArrayList<Usuario> listar(){
        return lista;
    }

    public String agregarUsuario(Usuario usuario){
        lista.add(usuario);
        return "registro exitoso";
    }

    public Usuario buscarusuario(int codigo){
        Usuario usu = null;

        for(Usuario u: lista){
            if(u.getIdUsuario()==codigo){
                usu=u;
            }
        }
        System.out.println(usu);
        return usu;
    }

    public ArrayList<Usuario> borrarUsuario(int codigo){
        lista.remove(buscarusuario(codigo));
        return lista;
    }

    public ArrayList<Usuario> actualizar(int codigo){
        Usuario borrusu = buscarusuario(codigo);

        ArrayList<String> listaa= new ArrayList<>();
        listaa.add("aaaa");

        for (Usuario i : lista) {
            i.getIdUsuario();
            System.out.println(i);
            if (i.getIdUsuario() == borrusu.idUsuario){
                System.out.println("\n"+ borrusu.idUsuario + "\n");
            }
        }
        return lista;
    }
}

