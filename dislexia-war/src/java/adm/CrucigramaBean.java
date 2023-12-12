/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package adm;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

@Named(value = "crucigramaBean")
@SessionScoped
public class CrucigramaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<List<Celda>> tablero;
    private List<String> clavesAcross;
    private List<String> clavesDown;

    @PostConstruct
    public void init() {
        // Inicializa el tablero y las claves
        inicializarTablero();
        inicializarClaves();
    }

    public List<List<Celda>> getTablero() {
        return tablero;
    }

    public List<String> getClavesAcross() {
        return clavesAcross;
    }

    public List<String> getClavesDown() {
        return clavesDown;
    }

    private void inicializarTablero() {
    // Implementa la lógica para inicializar el tablero según tus reglas de juego
    // Aquí, por ejemplo, se crea un tablero 5x5 con celdas negras en las esquinas
    tablero = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
        List<Celda> fila = new ArrayList<>();
        for (int j = 0; j < 5; j++) {
            if ((i == 0 && j == 0) || (i == 0 && j == 4) || (i == 4 && j == 0) || (i == 4 && j == 4)) {
                fila.add(new Celda(CeldaTipo.NEGRA, ""));
            } else {
                fila.add(new Celda(CeldaTipo.BLANCA, ""));
            }
        }
        tablero.add(fila);
    }
}


    private void inicializarClaves() {
        // Implementa la lógica para inicializar las claves según tus reglas de juego
        // Aquí, por ejemplo, se crean claves ficticias para Across y Down
        clavesAcross = new ArrayList<>();
        clavesAcross.add("1. Palabra de prueba");
        clavesAcross.add("2. Otra palabra");
        
        clavesDown = new ArrayList<>();
        clavesDown.add("1. Otra palabra");
        clavesDown.add("2. Palabra de prueba");
    }

    public class Celda implements Serializable {

        private static final long serialVersionUID = 1L;

        private CeldaTipo tipo;
        private String letra;

        public Celda(CeldaTipo tipo, String letra) {
            this.tipo = tipo;
            this.letra = letra;
        }

        public CeldaTipo getTipo() {
            return tipo;
        }

        public void setTipo(CeldaTipo tipo) {
            this.tipo = tipo;
        }

        public String getLetra() {
            return letra;
        }

        public void setLetra(String letra) {
            this.letra = letra;
        }
    }

    public enum CeldaTipo {
        NEGRA, BLANCA
    }
}