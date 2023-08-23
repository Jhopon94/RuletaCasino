/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ruletaBackend.LogicaJuego;

import com.example.ruletaBackend.entidades.Apostador;
import com.example.ruletaBackend.entidades.ApostadorJugando;
import com.example.ruletaBackend.entidades.Apuesta;
import com.example.ruletaBackend.servicios.ServicioApostador;
import com.example.ruletaBackend.servicios.ServicioApuesta;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author jhopon
 */
public class LogicaApuesta {

    private final List<Apostador> listaJugadoresEntrantes;
    private List<ApostadorJugando> listaJugadoresSalientes;
    private String colorGanador;

    private final int saldo = 0;
    Random random = new Random();

    private final ServicioApostador servApostador;
    private final ServicioApuesta servApuesta;
    Apuesta apuesta = new Apuesta();
    Apuesta apuestaActualizar = new Apuesta();

    public LogicaApuesta(List<Apostador> listaJugadores, ServicioApostador servApostador, ServicioApuesta servApuesta) {

        listaJugadoresEntrantes = listaJugadores;
        listaJugadoresSalientes = new ArrayList<>();
        colorGanador = ColorApuesta();
        this.servApostador = servApostador;
        this.servApuesta = servApuesta;
    }

    public boolean JugadoresExistentes() {//si la lsita recibe valores vacíos o nulos devuelve false

        return !(listaJugadoresEntrantes.isEmpty() || listaJugadoresEntrantes == null);

    }

    public String ColorApuesta() {

        int numero = random.nextInt(201);

        if (numero == 100 || numero == 200) {
            return "verde";
        } else {

            if (numero % 2 == 0) {
                return "negro";
            } else {
                return "rojo";
            }
        }
    }

    public int CantidadApostada(int saldoJugador) {

        if (saldoJugador <= 1000) {

            return saldoJugador;
        }
        if (saldoJugador > 1000) {

            int porcentajeApuesta = random.nextInt(11, 20);
            int apuesta = (saldoJugador * porcentajeApuesta) / 100;
            return apuesta;
        }
        return 0;
    }

    public boolean PuedeApostar(int saldoJugador) {

        return saldoJugador > 0;
    }

    public List<ApostadorJugando> RetornarApostadoresJugando() {

        if (JugadoresExistentes()) {
            int totalApostadores = 0;
            int totalCantidadApostada = 0;
            int totalGananciaCasino = 0;
            int auxiliarTotalGananciaGente = 0;
            for (Apostador p : listaJugadoresEntrantes) {

                if (PuedeApostar(p.getSaldo())) {
                    ApostadorJugando jugador = new ApostadorJugando();
                    jugador.setNombre(p.getNombre());
                    String colorApostado = ColorApuesta(); // variable para el color apostado
                    jugador.setColor(colorApostado);
                    int apuesta = CantidadApostada(p.getSaldo()); //variable para la cantidad apostada
                    jugador.setApuesta(apuesta);
                    int ganancia = CantidadGanada(apuesta, colorApostado);
                    jugador.setGanancia(ganancia);

                    //Acomodar Saldo Jugadores
                    if (ganancia != 0) {
                        p.setSaldo(p.getSaldo() + ganancia);
                    } else {
                        p.setSaldo(p.getSaldo() - apuesta);
                    }
                    servApostador.GuardarApostador(p);
                    //
                    //Sumar datos para guardar apuesta
                    totalApostadores++;
                    totalCantidadApostada = totalCantidadApostada + apuesta;
                    auxiliarTotalGananciaGente = auxiliarTotalGananciaGente + ganancia;
                    //

                    listaJugadoresSalientes.add(jugador);
                }
            }
            totalGananciaCasino = totalCantidadApostada - auxiliarTotalGananciaGente;
            //Guardado de apuesta
            apuestaActualizar =  servApuesta.ObtenerApuestaIndexCero();
            apuesta.setCantidadapostadores(totalApostadores + apuestaActualizar.getCantidadapostadores());
            apuesta.setTotalapostado(totalCantidadApostada + apuestaActualizar.getTotalapostado());
            apuesta.setGananciascasino(totalGananciaCasino + apuestaActualizar.getGananciascasino());
            apuesta.setCantidadjuegos(apuestaActualizar.getCantidadjuegos() + 1);
            int obtenerId = apuestaActualizar.getId();
            apuesta.setId(obtenerId);
            servApuesta.GuardarApuesta(apuesta);
            //
            //Manda Lista
            return listaJugadoresSalientes;
            //
        } else {
            ApostadorJugando jugador = new ApostadorJugando();
            jugador.setNombre("vacio");
            jugador.setColor("vacio");
            jugador.setGanancia(0);
            jugador.setApuesta(0);
            listaJugadoresSalientes.add(jugador);
            return listaJugadoresSalientes;
        }

    }

    public int CantidadGanada(int apuesta, String colorElegido) {

        int cantidadGanada = 0;

        if (colorGanador.equals(colorElegido)) {
            if (colorGanador.equals("verde")) {
                cantidadGanada = apuesta * 10;
            }
            if (colorGanador.equals("negro") || colorGanador.equals("rojo")) {
                cantidadGanada = apuesta * 2;
            }
        }

        return cantidadGanada;
    }
}
