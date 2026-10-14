package javier.casal;

public class InventarioTenda {


    private int id;
    private String idvideoxogo;
    private String prezomayorista;
    private double prezoventa;
    private int porcentaxeoferta;

    public InventarioTenda(int id, String idvideoxogo, String prezomayorista, double prezoventa, int porcentaxeoferta) {
        this.id = id;
        this.idvideoxogo = idvideoxogo;
        this.prezomayorista = prezomayorista;
        this.prezoventa = prezoventa;
        this.porcentaxeoferta = porcentaxeoferta;
    }

    @Override
    public String toString() {
        return "Id: " + id +
                " | IdVideoxogo: " + idvideoxogo +
                " | PrezoMayorista: " + prezomayorista +
                " | PrezoVenta: " + prezoventa +
                " | PorcentaxeOferta: " + porcentaxeoferta;
    }
}