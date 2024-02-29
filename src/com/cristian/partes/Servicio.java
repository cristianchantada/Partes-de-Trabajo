package com.cristian.partes;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

public class Servicio implements Serializable {
    private String desc;
    private Time he;
    private Time hs;
    private Date fecha = new Date();

    public Servicio() {}

    public Servicio(String desc){
        this();
        this.desc = desc;
    }

    public Servicio(String desc, Date fecha){
        this(desc);
        this.fecha = fecha;
    }

    public Servicio(String desc, Time he, Time hs, Date fecha) {
        this.desc = desc;
        this.he = he;
        this.hs = hs;
        this.fecha = fecha;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Time getHe() {
        return he;
    }

    public void setHe(Time he) {
        this.he = he;
    }

    public Time getHs() {
        return hs;
    }

    public void setHs(Time hs) {
        this.hs = hs;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}