# 🎮 Simulacro Examen 2026



Escribe un programa que poida crear, modificar, ler e eliminar rexistros nas táboas de datos xeradas a través do seguinte script SQL.

---

## 🗄️ Script de Creación de Táboas

```sql
DROP TABLE IF EXISTS InventarioTenda;
DROP TABLE IF EXISTS Videoxogo;

CREATE TABLE Videoxogo (
    Id SERIAL PRIMARY KEY,
    Titulo VARCHAR(255) NOT NULL,
    Plataforma VARCHAR(255),
    AnoLanzamento INT,
    Descripcion VARCHAR(255)
);

CREATE TABLE InventarioTenda (
    Id SERIAL PRIMARY KEY,
    IdVideoxogo INTEGER,
    PrezoMayorista DECIMAL(10, 2),
    PrezoVenta DECIMAL(10, 2),
    PorcentaxeOferta INT,
    FOREIGN KEY (IdVideoxogo) REFERENCES Videoxogo(Id)
);
```

---

## 📋 Requisitos do Programa

1. Escribe unha función que permita serializar nun ficheiro o contido da táboa **Videoxogo**.

   ![img20.png](images/img20.png)

2. Escribe unha función que permita deserializar as entradas do ficheiro creado anteriormente.

   ![img32.png](images/img32.png)

3. Escribe unha función que permita exportar en XML as entradas da táboa **Videoxogo**.

   ![img16.png](images/img16.png)

---

## 🚀 Secuencia de Execución

Usando as funcións anteriores, fai que o teu programa execute a seguinte secuencia:

### 1. Inserción de videoxogos
Insertar na táboa **Videoxogo** os seguintes videoxogos *(recorda que os valores da PK son autoxerados)*:

* **The Legend of Zelda: Ocarina of Time** *(Nintendo 64, 1998)*  
  *Descrición:* Clásico xogo de aventura e acción 3D en Hyrule.
* **Elden Ring** *(Multiplataforma, 2022)*  
  *Descrición:* RPG de acción desafiante nun mundo de fantasía escura.
* **The Witcher 3: Wild Hunt** *(Multiplataforma, 2015)*  
  *Descrición:* RPG de fantasía seguindo as aventuras do bruxo Geralt.
* **Bloodborne** *(PlayStation 4, 2015)*  
  *Descrición:* RPG de acción e terror gótico ambientado na cidade de Yharnam.
* **Super Mario Odyssey** *(Nintendo Switch, 2017)*  
  *Descrición:* Plataformas 3D con mecánicas de posesión de obxectos.

![img1.png](images/img1.png)
![img3.png](images/img3.png)
![img2.png](images/img2.png)

---

### 2. Consulta de IDs
Consulta os IDs que teñen os videoxogos e lístaos.

![img9.png](images/img9.png)
![img8.png](images/img8.png)
![img6.png](images/img6.png)

---

### 3. Inserción en Inventario
Inserta na táboa **InventarioTenda** as seguintes entradas:

| Videoxogo (FK) | Prezo Mayorista | Prezo Venta | Porcentaxe Oferta |
| :--- | :---: | :---: | :---: |
| *(Id de The Legend of Zelda: Ocarina of Time)* | 45.00 | 69.99 | 10 |
| *(Id de Elden Ring)* | 40.00 | 59.99 | 12 |
| *(Id de The Witcher 3)* | 15.00 | 29.99 | 5 |
| *(Id de Bloodborne)* | 20.00 | 39.99 | 8 |
| *(Id de Super Mario Odyssey)* | 35.00 | 49.99 | 6 |

![img11.png](images/img11.png)
![img12.png](images/img12.png)
![img13.png](images/img13.png)

---

### 4. Exportación a XML
Exporta as entradas da táboa **Videoxogo** a XML.

![img15.png](images/img15.png)
![img14.png](images/img14.png)
![img16.png](images/img16.png)
![img17.png](images/img17.png)

---

### 5. Exportación a Ficheiro
Exporta as entradas da táboa **Videoxogo** nun ficheiro.

![img19.png](images/img19.png)
![img18.png](images/img18.png)
![img20.png](images/img20.png)
![img21.png](images/img21.png)

---

### 6. Mensaxe de Ofertas
Mostra unha mensaxe que poña **“OFERTAS VIDEOXOGOS”**.

![img22.png](images/img22.png)
![img23.png](images/img23.png)

---

### 7. Modificación de Oferta
Modifica a porcentaxe de oferta dos videoxogos en **InventarioTenda** para sumarlle 15.

![img25.png](images/img25.png)
![img24.png](images/img24.png)
![img26.png](images/img26.png)

---

### 8. Cálculo do Prezo Actual
Lista o prezo actual de venda de *The Legend of Zelda: Ocarina of Time* (aplicando `PorcentaxeOferta` sobre `PrezoVenta`).

![img29.png](images/img29.png)
![img28.png](images/img28.png)
![img27.png](images/img27.png)

---

### 9. Lectura do Ficheiro Serializado
Lee as entradas de videoxogo do ficheiro serializado.

![img30.png](images/img30.png)
![img31.png](images/img31.png)
![img32.png](images/img32.png)

---

### 10. Escritura Final en Texto
Escribe nun ficheiro de texto o lido do ficheiro serializado.

![img34.png](images/img34.png)
![img33.png](images/img33.png)
![img36.png](images/img36.png)
![img35.png](images/img35.png)