package com.example.practica.Controlador;


import com.example.practica.Entidades.Usuario;
import com.example.practica.Servicios.servicioUsuario;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins= "*", maxAge = 3600)

@RestController
public class controladorUsuario {
    servicioUsuario servicio = new servicioUsuario();

    @GetMapping("/listarUsuario")
    public ArrayList<Usuario> listarUsuario(){
        return servicio.listar();
    }

    @PostMapping("/agregarUsuario")
    public String agregar(@RequestBody Usuario usuario){
        return servicio.agregarUsuario(usuario);
    }

    @GetMapping("/buscarUsuario/{cod}")
    public Usuario buscarUsuario(@PathVariable("cod") int codigo){
        return servicio.buscar_usuario(codigo);
    }

    @GetMapping("/buscarNombre/{name}")
    public ArrayList<Usuario> buscarNombre(@PathVariable("name") String name){
        return servicio.buscar_nombre(name);
    }

    @GetMapping("/borrarUsuario/{code}")
    public ArrayList<Usuario> borrarUsuario(@PathVariable("code") int codigo){
        return servicio.borrar_usuario(codigo);
    }

    @PostMapping("/ModificarUsuario")
    public String ModificarUsuario(@RequestBody Usuario usuario ){
        return servicio.ModificarUsu(usuario);
    }
}
