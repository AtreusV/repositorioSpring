$(document).ready(function() {
    $('#listar').on('click',function() {

        let tabla = document.querySelector('#tabla')
        tabla.innerHTML = '<table><tr><th>ID</th><th>NOMBRE</th><th>PAÍS</th><th>FECHA NACIMIENTO</th><th>CORREO</th></tr></table>'

        $.ajax({

            url:"http://localhost:8080/listarUsuario",
            type:"GET",
            dataType: "JSON",
            success: function(respuesta) {
                for (i = 0;i <= respuesta.length; i++){
                    tabla.innerHTML += 
                    '<tr><td>' + respuesta[i].idUsuario +
                    '<td>' + respuesta[i].nombreUsu +
                    '<td>' + respuesta[i].pais +
                    '<td>' + respuesta[i].fechaNa +
                    '<td>' + respuesta[i].correoUsu
                }
            }
        })
    })
    
    $('#enviar').on('click',function(){
        let datos = {
            idUsuario: parseInt($('#idUsuario').val()),
            nombreUsu: $('#nomUsuario').val(),
            pais: $('#paisUsu').val(),
            fechaNa: $('#fechaNac').val(),
            correoUsu: $('#CorrUsu').val()
        }
        console.log(datos)
    
        let datosEnvio = JSON.stringify(datos);
        console.log(datosEnvio);
        $.ajax({
            url: "http://localhost:8080/agregarUsuario",
            type: "POST",
            data: datosEnvio,
            contentType: "application/JSON",
            dataType: "JSON",
            success: function(respuesta) {
                alert(respuesta)
            }
        })
    });
    
    $('#buscarId').on('click',function(){
        let codigo = $('#codigo').val();
    
        let tabla = document.querySelector('#tabla')
        tabla.innerHTML = '<table><tr><th>ID</th><th>NOMBRE</th><th>PAÍS</th><th>FECHA NACIMIENTO</th><th>CORREO</th></tr></table>'
    
        $.ajax({
            url:"http://localhost:8080/buscarUsuario/"+codigo,
            Type:"GET",
            dataType:"JSON",
            success:function(respuesta){
                if(respuesta!=null){
                    tabla.innerHTML += 
                    '<tr><td>' + respuesta.idUsuario +
                    '<td>' + respuesta.nombreUsu +
                    '<td>' + respuesta.pais +
                    '<td>' + respuesta.fechaNa +
                    '<td>' + respuesta.correoUsu
                }else{
                    console.log("No se encontro el usuario.")
                    console.log(respuesta)
                }
            }
        })
    });

    $('#buscarName').on('click',function(){
        let nombre = $('#nombre_Usu').val();
    
        let tabla = document.querySelector('#tabla')
        tabla.innerHTML = '<table><tr><th>ID</th><th>NOMBRE</th><th>PAÍS</th><th>FECHA NACIMIENTO</th><th>CORREO</th></tr></table>'
    
        $.ajax({
            url:"http://localhost:8080/buscarNombre/"+nombre,
            Type:"GET",
            dataType:"JSON",
            success:function(respuesta){

                for (i = 0;i <= respuesta.length; i++){
                    tabla.innerHTML += 
                    '<tr><td>' + respuesta[i].idUsuario +
                    '<td>' + respuesta[i].nombreUsu +
                    '<td>' + respuesta[i].pais +
                    '<td>' + respuesta[i].fechaNa +
                    '<td>' + respuesta[i].correoUsu
                }
            }
        })
    });
    
    $('#eliminarUsu').on('click',function(){
        let tabla = document.querySelector('#tabla')
        tabla.innerHTML = '<table><tr><th>ID</th><th>NOMBRE</th><th>PAÍS</th><th>FECHA NACIMIENTO</th><th>CORREO</th></tr></table>'
        
        let codigo = $('#codigo').val();

        $.ajax({
            url:"http://localhost:8080/borrarUsuario/"+codigo,
            Type:"GET",
            dataType:"JSON",
            success:function(respuesta){
                for (i = 0;i <= respuesta.length; i++){
                    tabla.innerHTML += 
                    '<tr><td>' + respuesta[i].idUsuario +
                    '<td>' + respuesta[i].nombreUsu +
                    '<td>' + respuesta[i].pais +
                    '<td>' + respuesta[i].fechaNa +
                    '<td>' + respuesta[i].correoUsu
                }
            }
        })

    });

    $('#actualizar').on('click',function(){
        let d = {
            idUsuario: parseInt($('#idUsuario').val()),
            nombreUsu: $('#nomUsuario').val(),
            pais: $('#paisUsu').val(),
            fechaNa: $('#fechaNac').val(),
            correoUsu: $('#CorrUsu').val()
        }

        console.log(d)
        let Datos = JSON.stringify(d);

        $.ajax({
            url: "http://localhost:8080/ModificarUsuario",
            type: "POST",
            data: Datos,
            dataType: "JSON",
            contentType: "application/JSON"
        });
    });
    
});

//dataType: "TEXT",