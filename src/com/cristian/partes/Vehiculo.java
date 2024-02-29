package com.cristian.partes;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Vehiculo implements Serializable {
    private String matricula;
    private String modelo;
    private String marca;


    public Vehiculo() {
    }
    public Vehiculo( String matricula, String modelo, String marca) {
        this.matricula=matricula;
        this.modelo=modelo;
        this.marca=marca;
    }
    public String getMatriculas() {
        return matricula;
    }
    public void setMatriculas(String matriculas) {
        this.matricula = matriculas;
    }
    public String getModelos() {
        return modelo;
    }
    public void setModelos(String modelo) {
        this.modelo = modelo;
    }
    public String getMarcas() {
        return marca;
    }
    public void setMarcas(String marca) {
        this.marca = marca;
    }
}
