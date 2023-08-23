/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ruletaBackend.servicios;

import com.example.ruletaBackend.entidades.Apostador;
import com.example.ruletaBackend.repositorios.RepositorioApostador;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioApostador implements InterfazServicioApostador {

    @Autowired
    private RepositorioApostador repApostador;
    private Apostador apostador = new Apostador();

    @Override
    public List<Apostador> ListaJugadores() {

        List lista = (List<Apostador>) repApostador.findAll();
        return lista;
    }

    @Override
    public Apostador ApostadorIndividual(String cedulaId) {
        Optional<Apostador> auxiliarVerificar = repApostador.findById(cedulaId);
        
        if(auxiliarVerificar.isPresent())return auxiliarVerificar.get();
        else {
            apostador.setId(1);
            apostador.setNombre("noexiste");
            apostador.setCedula(1);
            apostador.setSaldo(1);
            return apostador;
        }
    }
    
    @Override
    public void EliminarJugador(String cedulaId) {
       
        repApostador.deleteById(cedulaId);
    }

    @Override
    public void GuardarApostador(Apostador apostador) {
        
        if(apostador != null){
        apostador.setId(apostador.getCedula());
        repApostador.save(apostador);
        }
    }
}
