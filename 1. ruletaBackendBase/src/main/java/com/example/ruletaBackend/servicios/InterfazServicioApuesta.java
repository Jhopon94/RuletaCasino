/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ruletaBackend.servicios;

import com.example.ruletaBackend.entidades.Apuesta;
import java.util.List;

/**
 *
 * @author jhopon
 */
public interface InterfazServicioApuesta {
    
   List<Apuesta> ListaApuestas();
   
   void GuardarApuesta(Apuesta apuesta);
   
   void BorrarApuesta(String id);
   
   Apuesta ObtenerApuestaIndexCero();
}
