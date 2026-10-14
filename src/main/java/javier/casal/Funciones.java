package javier.casal;

import java.sql.*;
import java.io.*;
import java.util.*;
import javier.casal.Connector.DBconnector;

public class Funciones {

    // CREATE
    public void insertar(int id, String titulo, String plataforma, int anolanzamento, String descripcion) {

        String sql = "INSERT INTO videoxogo (id, titulo, plataforma, anolanzamento, descripcion) VALUES (?, ?, ?, ?, ?)";

        try {
            Connection conn = DBconnector.conexion();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            ps.setString(2, titulo);
            ps.setString(3, plataforma);
            ps.setInt(4, anolanzamento);
            ps.setString(5, descripcion);

            ps.executeUpdate();

            System.out.println("Videoxogo insertado correctamente.");

            ps.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }
    }

    // CREATE Inventario
    public void insertarInventario(int id, int idvideoxogo, double prezomayorista, double prezoventa, int porcentaxeoferta) {

        String sql = "INSERT INTO InventarioTenda (id, idvideoxogo, prezomayorista, prezoventa, porcentaxeoferta) VALUES (?, ?, ?, ?, ?)";

        try {
            Connection conn = DBconnector.conexion();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            ps.setInt(2, idvideoxogo);
            ps.setDouble(3, prezomayorista);
            ps.setDouble(4, prezoventa);
            ps.setInt(5, porcentaxeoferta);

            ps.executeUpdate();

            System.out.println("Inventario insertado correctamente.");

            ps.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }
    }

    // UPDATE
    public void actualizar(int id, String titulo, String plataforma, int anolanzamento, String descripcion) {

        String sql = "UPDATE videoxogo SET titulo = ?, plataforma = ?, anolanzamento = ?, descripcion = ? WHERE id = ?";

        try {
            Connection conn = DBconnector.conexion();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, titulo);
            ps.setString(2, plataforma);
            ps.setInt(3, anolanzamento);
            ps.setString(4, descripcion);
            ps.setInt(5, id);

            int filas = ps.executeUpdate();

            System.out.println("Videoxogos actualizados: " + filas);

            ps.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }
    }

    // UPDATE Inventario
    public void actualizarInventario(int porcentaxe) {

        String sql = "UPDATE InventarioTenda SET porcentaxeoferta = porcentaxeoferta + ?";

        try {
            Connection conn = DBconnector.conexion();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, porcentaxe);

            int filas = ps.executeUpdate();

            System.out.println("Inventario actualizado: " + filas);

            ps.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }
    }

    // READ
    public void lerTodos() {

        String sql = "SELECT * FROM videoxogo";

        try {
            Connection conn = DBconnector.conexion();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        "Id: " + rs.getInt("id") +
                                " | Titulo: " + rs.getString("titulo") +
                                " | Plataforma: " + rs.getString("plataforma") +
                                " | Ano: " + rs.getInt("anolanzamento") +
                                " | Descripcion: " + rs.getString("descripcion")
                );
            }

            rs.close();
            ps.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Error al leer: " + e.getMessage());
        }
    }


    // READ - Filtrado
    public void lerFiltrado(String titulo) {

        String sql = "SELECT videoxogo.id AS idvideoxogo, videoxogo.titulo, videoxogo.plataforma, videoxogo.anolanzamento, videoxogo.descripcion, " +
                "InventarioTenda.prezomayorista, InventarioTenda.prezoventa, InventarioTenda.porcentaxeoferta " +
                "FROM videoxogo INNER JOIN InventarioTenda ON videoxogo.id = InventarioTenda.idvideoxogo WHERE videoxogo.titulo = ?";

        try {

            Connection conn = DBconnector.conexion();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, titulo);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println(
                        "Id: " + rs.getInt("idvideoxogo") +
                                " | Titulo: " + rs.getString("titulo") +
                                " | Plataforma: " + rs.getString("plataforma") +
                                " | Ano: " + rs.getInt("anolanzamento") +
                                " | Descripcion: " + rs.getString("descripcion") +
                                " | Precio Mayorista: " + rs.getDouble("prezomayorista") +
                                " | Precio Venta: " + rs.getDouble("prezoventa") +
                                " | Porcentaje Oferta: " + rs.getInt("porcentaxeoferta")
                );
            }

            rs.close();
            ps.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Error al buscar: " + e.getMessage());
        }
    }

    // DELETE
    public void eliminar(int id) {

        String sql = "DELETE FROM videoxogo WHERE id = ?";

        try {
            Connection conn = DBconnector.conexion();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            int filas = ps.executeUpdate();

            System.out.println("Videoxogos eliminados: " + filas);

            ps.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Erro ao eliminar: " + e.getMessage());
        }
    }


    // TXT serializado
    public void txtSerializado() {

        try {

            ObjectInputStream entrada = new ObjectInputStream(
                    new FileInputStream("videoxogos.dat")
            );

            ArrayList<Videoxogo> videoxogos = (ArrayList<Videoxogo>) entrada.readObject();

            entrada.close();

            FileWriter escritor = new FileWriter("videoxogos.txt");

            for (Videoxogo v : videoxogos) {
                escritor.write(v.toString() + "\n");
            }

            escritor.close();

            System.out.println("Ficheiro de texto creado correctamente.");

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    // SERIALIZAR
    public void serializar() {

        String sql = "SELECT * FROM videoxogo";

        try {
            Connection conn = DBconnector.conexion();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            ArrayList<Videoxogo> lista = new ArrayList<>();

            while (rs.next()) {
                Videoxogo v = new Videoxogo(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("plataforma"),
                        rs.getInt("anolanzamento"),
                        rs.getString("descripcion")
                );

                lista.add(v);
            }

            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream("videoxogos.dat")
            );

            oos.writeObject(lista);
            oos.close();

            rs.close();
            ps.close();
            conn.close();

            System.out.println("Videoxogos serializados correctamente.");

        } catch (Exception e) {
            System.out.println("Error al serializar: " + e.getMessage());
        }
    }

    // DESERIALIZAR
    public void deserializar() {

        try {
            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream("videoxogos.dat")
            );

            ArrayList<Videoxogo> lista =
                    (ArrayList<Videoxogo>) ois.readObject();

            for (Videoxogo v : lista) {
                System.out.println(v);
            }

            ois.close();

        } catch (Exception e) {
            System.out.println("Error al deserializar: " + e.getMessage());
        }
    }

    // EXPORTAR A XML
    public void exportarXML() {

        String sql = "SELECT * FROM videoxogo";

        try {
            Connection conn = DBconnector.conexion();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            PrintWriter pw = new PrintWriter(
                    new FileWriter("videoxogos.xml")
            );

            pw.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            pw.println("<videoxogos>");

            while (rs.next()) {
                pw.println("    <videoxogo>");
                pw.println("        <id>" + rs.getInt("id") + "</id>");
                pw.println("        <titulo>" +
                        quitarCaracteresEspecialesXML(rs.getString("titulo")) + "</titulo>");
                pw.println("        <plataforma>" +
                        quitarCaracteresEspecialesXML(rs.getString("plataforma")) + "</plataforma>");
                pw.println("        <anolanzamento>" +
                        rs.getInt("anolanzamento") + "</anolanzamento>");
                pw.println("        <descripcion>" +
                        quitarCaracteresEspecialesXML(rs.getString("descripcion")) + "</descripcion>");
                pw.println("    </videoxogo>");
            }

            pw.println("</videoxogos>");

            pw.close();
            rs.close();
            ps.close();
            conn.close();

            System.out.println("Ficheiro XML creado correctamente.");

        } catch (Exception e) {
            System.out.println("Error al exportar XML: " + e.getMessage());
        }
    }

    // quitar caracteres especiales de XML
    private String quitarCaracteresEspecialesXML(String texto) {

        if (texto == null) {
            return "";
        }

        return texto.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&apos;");
    }
}