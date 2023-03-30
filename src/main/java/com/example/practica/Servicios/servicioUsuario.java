package com.example.practica.Servicios;

import com.example.practica.Entidades.Usuario;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.util.ArrayList;

public class servicioUsuario {

    ArrayList<Usuario> lista= new ArrayList<>();

    ArrayList<Usuario> listnombre= new ArrayList<>();

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

    public Usuario buscar_usuario(int codigo){
        Usuario usu = null;

        for(Usuario u: lista){
            if(u.getIdUsuario()==codigo){
                usu=u;
            }
        }
        return usu;
    }

    public ArrayList<Usuario> buscar_nombre(String name){
        String usu = null;

        for(Usuario u: lista){
            if(u.getNombreUsu().equals(name)){
                listnombre.add(u);
            }
        }
        return listnombre;
    }

    public ArrayList<Usuario> borrar_usuario(int codigo){
        lista.remove(buscar_usuario(codigo));
        return lista;
    }

    public String ModificarUsu(Usuario usuario){
        boolean cambio = false;
        for (Usuario Es : lista){
            if (Es.getIdUsuario() == usuario.getIdUsuario()){

                Es.setNombreUsu(usuario.getNombreUsu());
                Es.setCorreoUsu(usuario.getCorreoUsu());
                Es.setPais(usuario.getPais());
                Es.setFechaNa(usuario.getFechaNa());
                cambio = true;
            }
        }

        String respuesta = "";
        if(cambio == true){
            respuesta = "Se han actualizado los datos";
        }else{
            respuesta = "No se han actualizado los datos";
        }
        return respuesta;
    }
}

