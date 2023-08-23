/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ruletaBackend.servicios;

import com.example.ruletaBackend.entidades.Apuesta;
import com.example.ruletaBackend.repositorios.RepositorioApuesta;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioApuesta implements InterfazServicioApuesta{

    @Autowired
    private RepositorioApuesta repApuesta;
    

    @Override
    public List<Apuesta> ListaApuestas() {
        
        List lista = (List<Apuesta>) repApuesta.findAll();
        return lista;
    }
    
    @Override
    public void GuardarApuesta(Apuesta apuesta){
    
        repApuesta.save(apuesta);
    }
    
    @Override
    public void BorrarApuesta(String id){
    
        repApuesta.deleteById(id);
    }
    
    @Override
    public Apuesta ObtenerApuestaIndexCero(){
        List<Apuesta> apuestas = ListaApuestas();
        Apuesta apuesta = new Apuesta();
        
        if(!apuestas.isEmpty())return ListaApuestas().get(0);
        else{
         apuesta.setCantidadapostadores(0);
         apuesta.setGananciascasino(0);
         apuesta.setId(1);
         apuesta.setTotalapostado(0);
         apuesta.setTotalapostado(0);
         return apuesta;
        }
    }
}
