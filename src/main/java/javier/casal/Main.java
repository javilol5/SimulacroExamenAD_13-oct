package javier.casal;
import java.sql.*;

public class Main {

    public static void main(String[] args) {

        Funciones f = new Funciones();

//        // INSERTAR
//        System.out.println();
//        System.out.println("Insertar rexistros en la base de datos:");
//        System.out.println();
//
//        f.insertar(
//                1,
//                "The Legend of Zelda: Ocarina of Time",
//                "Nintendo 64",
//                1998,
//                "Clásico xogo de aventura e acción 3D en Hyrule"
//        );
//
//        f.insertar(
//                2,
//                "Elden Ring",
//                "Multiplataforma",
//                2022,
//                "RPG de acción desafiante nun mundo de fantasía escura"
//        );
//
//        f.insertar(
//                3,
//                "The Witcher 3: Wild Hunt",
//                "Multiplataforma",
//                2015,
//                "RPG de fantasía seguindo as aventuras do bruxo Geralt"
//        );
//
//        f.insertar(
//                4,
//                "Bloodborne",
//                "PlayStation 4",
//                2015,
//                "RPG de acción e terror gótico ambientado na cidade de Yharnam"
//        );
//
//        f.insertar(
//                5,
//                "Super Mario Odyssey",
//                "Nintendo Switch",
//                2017,
//                "Plataformas 3D con mecánicas de posesión de obxectos"
//        );


//        // CONSULTAR ID
//        System.out.println();
//        System.out.println("Leer todos los datos:");
//        System.out.println();
//
//        f.lerTodos();


//        // INSERTAR INVENTARIO
//        System.out.println();
//        System.out.println("Insertar rexistros en la base de datos:");
//        System.out.println();
//
//        f.insertarInventario(
//                1,
//                1,
//                45.00,
//                69.99,
//                10
//        );
//
//        f.insertarInventario(
//                2,
//                2,
//                40.00,
//                59.99,
//                12
//        );
//
//        f.insertarInventario(
//                3,
//                3,
//                15.00,
//                29.99,
//                5
//        );
//
//        f.insertarInventario(
//                4,
//                4,
//                20.00,
//                39.99,
//                8
//        );
//
//        f.insertarInventario(
//                5,
//                5,
//                35.00,
//                49.99,
//                6
//        );


//        // Exporta as entradas da táboa Videoxogo a XML.
//        System.out.println();
//        System.out.println("Exportar a XML:");
//        System.out.println();
//
//        f.exportarXML();


//        // Exporta as entradas da táboa Videoxogo nun ficheiro.
//        System.out.println();
//        System.out.println("Serializar:");
//        System.out.println();
//
//        f.serializar();


//        // Mostra unha mensaxe que poña “OFERTAS VIDEOXOGOS”.
//        System.out.println();
//        System.out.println("OFERTAS VIDEOXOGOS");
//        System.out.println();


//        // Modifica a porcentaxe de oferta dos videoxogos en InventarioTenda para sumarlle 15.
//        System.out.println();
//        System.out.println("Actualizar porcentaxe de oferta:");
//        System.out.println();
//
//        f.actualizarInventario(15);


//        //Lista o prezo actual de venda de The Legend of Zelda: Ocarina of Time (aplicando PorcentaxeOferta sobre PrezoVenta).
//        System.out.println();
//        System.out.println("Prezo actual de venda de The Legend of Zelda: Ocarina of Time:");
//        System.out.println();
//
//        f.lerFiltrado("The Legend of Zelda: Ocarina of Time");


//        //Lee as entradas de videoxogo do ficheiro serializado.
//        System.out.println();
//        System.out.println("Leer serializado:");
//        System.out.println();
//
//        f.deserializar();


        //Escribe nun ficheiro de texto o lido do ficheiro serializado.
        System.out.println();
        System.out.println("Escribir en ficheiro de texto:");
        System.out.println();

        f.txtSerializado();



    }
}

