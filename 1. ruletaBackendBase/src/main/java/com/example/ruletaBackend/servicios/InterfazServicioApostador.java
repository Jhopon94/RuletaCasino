/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ruletaBackend.servicios;

import com.example.ruletaBackend.entidades.Apostador;
import java.util.List;

/**
 *
 * @author jhopon
 */
public interface InterfazServicioApostador {
    
   
   List<Apostador> ListaJugadores();
   
   void GuardarApostador(Apostador apostador);
   
   
   public Apostador ApostadorIndividual(String cedulaId);
   
   public void EliminarJugador(String cedulaId);
}
