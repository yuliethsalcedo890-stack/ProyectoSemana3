# 📊 Proyecto Semana 3 – Generación y Clasificación de Datos

**Autor:** Yulieth Salcedo  
**Curso / Entrega:** Semana 3 – GenerateInfoFiles

---

## Descripción
Proyecto en **Java** que genera datos pseudoaleatorios y los guarda en archivos planos:

- `productos.txt` → ID;Nombre;Precio  
- `vendedores.txt` → TipoDocumento;Número;Nombre;Apellido  
- `ventas_<Documento>.txt` → archivo por vendedor con registros (IDProducto;Cantidad;)

La clase principal es `GenerateInfoFiles` (ubicada en `src/`) y al ejecutarla crea los archivos mencionados en la raíz del proyecto.

---

## Estructura del proyecto
ProyectoSemana3/
├─ src/
│ └─ GenerateInfoFiles.java
├─ productos.txt
├─ vendedores.txt
├─ ventas_<id>.txt
└─ README.md
---

## ⚙️ Requisitos
- **Java JDK 8** o superior  
- **Eclipse IDE** (o cualquier IDE para Java)  

---

## 🚀 Cómo ejecutar
1. Importa el proyecto en Eclipse:  
   *File → Import → Existing Projects into Workspace*  
2. Ejecuta la clase `GenerateInfoFiles`:  
   *Run As → Java Application*  
3. En consola aparecerá:  
Archivos generados exitosamente ✅4. Revisa los archivos creados en la raíz del proyecto:  
- `productos.txt`  
- `vendedores.txt`  
- `ventas_<Documento>.txt`  

---

## 📊 Ejemplo de salida

**Archivo `productos.txt`:**
P001; Televisor; 1200000
P002; Celular; 850000
**Archivo `vendedores.txt`:**
CC; 10345678; Juan; Pérez
TI; 10223344; María; López
**Archivo `ventas_10345678.txt`:**
P001; 3
P002; 1
---

## 🛠️ Comandos Git (alternativa por terminal)
```bash
git add README.md
git commit -m "Añadir README.md con descripción del proyecto"
git branch -M main
git remote add origin https://github.com/yuliethsalcedo890-stack/ProyectoSemana3.git
git push -u origin main
Estado del proyecto

 Clase GenerateInfoFiles implementada

 Archivos generados correctamente

 README agregadoRepositorio: ProyectoSemana3