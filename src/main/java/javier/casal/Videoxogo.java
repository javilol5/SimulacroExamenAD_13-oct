package javier.casal;

import java.io.Serializable;

public class Videoxogo implements Serializable {

    private int id;
    private String titulo;
    private String plataforma;
    private int anolanzamento;
    private String descripcion;

    public Videoxogo(int id, String titulo, String plataforma,
                     int anolanzamento, String descripcion) {
        this.id = id;
        this.titulo = titulo;
        this.plataforma = plataforma;
        this.anolanzamento = anolanzamento;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Id: " + id +
                " | Titulo: " + titulo +
                " | Plataforma: " + plataforma +
                " | AnoLanzamento: " + anolanzamento +
                " | Descripcion: " + descripcion;
    }
}