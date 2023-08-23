/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ruletaBackend.controladores;

import com.example.ruletaBackend.entidades.Apuesta;
import com.example.ruletaBackend.servicios.InterfazServicioApuesta;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApuestaControlador {
    
    @Autowired
    private InterfazServicioApuesta servApuesta;
    
    @GetMapping("/api/lista")
    public List<Apuesta> ListarApuestas(){
    
        return servApuesta.ListaApuestas();
    }
    
    @PostMapping("/api/listaApuestas")
    public void RegistrarApuesta(@RequestBody Apuesta apuesta){
        servApuesta.GuardarApuesta(apuesta);
    }
    
    @DeleteMapping("/api/listaApuestas/{id}")
    public void EliminarApostador(@PathVariable String id){
        servApuesta.BorrarApuesta(id);
    }
}
