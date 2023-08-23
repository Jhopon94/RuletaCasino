/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ruletaBackend.controladores;

import com.example.ruletaBackend.LogicaJuego.LogicaApuesta;
import com.example.ruletaBackend.entidades.Apostador;
import com.example.ruletaBackend.entidades.ApostadorJugando;
import com.example.ruletaBackend.entidades.Apuesta;
import com.example.ruletaBackend.servicios.InterfazServicioApostador;
import com.example.ruletaBackend.servicios.InterfazServicioApuesta;
import com.example.ruletaBackend.servicios.ServicioApostador;
import com.example.ruletaBackend.servicios.ServicioApuesta;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApostadorControlador {

    @Autowired
    private InterfazServicioApostador servApostador;
    @Autowired
    private ServicioApostador servApostadorNoInterfaz; //para almacenar la información indirecta sin problemas desde la lógica del juego
    @Autowired
    private InterfazServicioApuesta servApuesta;
    @Autowired
    private ServicioApuesta servApuestaNoInterfaz;
    
    @GetMapping("/api/listaJugadores")
    public List<Apostador> ListaJugadores() {
        List listaJugadores = servApostador.ListaJugadores();
        if(listaJugadores.isEmpty() || listaJugadores == null){
            Apostador jugador = new Apostador();
            Date date = new Date(0);
            jugador.setNombre("vacio");
            jugador.setCedula(0);
            jugador.setId(0);
            jugador.setSaldo(0);
            jugador.setNacimiento(date);
            listaJugadores.add(jugador);
            return listaJugadores;
        }return listaJugadores;
    }
    
    @GetMapping("api/listaJugadores/{cedula}")
    public Apostador JugadorEncontrado(@PathVariable String cedula){
        return  servApostador.ApostadorIndividual(cedula);
    }

    @GetMapping("/api/listaApostadores")
    public List<ApostadorJugando> ListaApostadores() {
        LogicaApuesta obtenerApostadores = new LogicaApuesta(ListaJugadores(), servApostadorNoInterfaz, servApuestaNoInterfaz);
        return obtenerApostadores.RetornarApostadoresJugando();
    }
    
    @GetMapping("/api/listaApuestas")
    public List<Apuesta> ListarApuestas(){
        List listaApuestas = servApuesta.ListaApuestas();
        if(listaApuestas.isEmpty() || listaApuestas == null){
            Apuesta apuesta = new Apuesta();
            apuesta.setId(0);
            apuesta.setTotalapostado(0);
            apuesta.setCantidadapostadores(0);
            apuesta.setGananciascasino(0);
            listaApuestas.add(apuesta);
            return listaApuestas;
        }return listaApuestas;
    }

    @PostMapping("/api/listaJugadores")
    public void RegistrarApostador(@RequestBody Apostador apostador) {
        apostador.setNombre(AcomodarNombre(apostador.getNombre()));
        servApostador.GuardarApostador(apostador);
    }

    @DeleteMapping("/api/listaJugadores/{cedula}")
    public void EliminarJugador(@PathVariable String cedula) {
        servApostador.EliminarJugador(cedula);
    }
    
    public String AcomodarNombre(String nombre){
    
        String nuevoNombre = "";
        int duracionNombre = nombre.length();
        char auxiliarLetra;
        char auxiliarLetraAnterior = ' ';
        
        
        for (int i = 0; i < duracionNombre; i++){
        
            auxiliarLetra = nombre.charAt(i);
            if(!Character.isWhitespace(auxiliarLetra)){ //si no es un espacio
                
                if(Character.isWhitespace(auxiliarLetraAnterior)){  // Si letra anterior es un espacio
                    auxiliarLetra = Character.toUpperCase(auxiliarLetra);
                    nuevoNombre = nuevoNombre + auxiliarLetra;
                }else{
                    nuevoNombre = nuevoNombre + auxiliarLetra;
                }
            }else {  // para poner los espacios intermedios
                if(!Character.isWhitespace(auxiliarLetraAnterior)){  // Si letra anterior NO es espacio
                    nuevoNombre = nuevoNombre + auxiliarLetra;
                }
            }
            auxiliarLetraAnterior = auxiliarLetra;
        }
        return nuevoNombre;
    }
}
