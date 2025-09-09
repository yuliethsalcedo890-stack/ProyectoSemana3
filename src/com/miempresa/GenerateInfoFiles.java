package com.miempresa;



import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateInfoFiles {

    private static final String[] FIRST_NAMES = {"Ana","Luis","Carlos","María","Pedro","Laura","Jorge","Sofía"};
    private static final String[] LAST_NAMES  = {"García","Rodríguez","López","Martínez","Sánchez","Pérez"};
    private static final String[] PRODUCT_NAMES = {"Camisa","Pantalon","Zapatos","Chaqueta","Sombrero","Bolso"};
    private static final String[] DOC_TYPES = {"CC","TI","CE"};
    private static final Random RAND = new Random();
    private static final DecimalFormat PRICE_FMT = new DecimalFormat("#.00");

    private static final List<Salesman> GENERATED_SALESMEN = new ArrayList<>();
    private static int generatedProductsCount = 0;

    public static void main(String[] args) {
        try {
            int productsCount = 8;    // productos
            int salesmanCount = 5;    // vendedores
            int salesPerSellerMax = 10;

            createProductsFile(productsCount);
            createSalesManInfoFile(salesmanCount);

            for (Salesman s : GENERATED_SALESMEN) {
                int salesCount = 3 + RAND.nextInt(Math.max(1, salesPerSellerMax - 2));
                createSalesMenFile(salesCount, s.getFullName(), Long.parseLong(s.documentNumber));
            }

            System.out.println("Archivos generados exitosamente ✅");
        } catch (IOException e) {
            System.err.println("❌ Error al generar archivos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void createSalesManInfoFile(int salesmanCount) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("vendedores.txt"))) {
            GENERATED_SALESMEN.clear();
            for (int i = 0; i < salesmanCount; i++) {
                String tipo = DOC_TYPES[RAND.nextInt(DOC_TYPES.length)];
                long numero = 10000000L + Math.abs(RAND.nextInt(90000000));
                String nombre = FIRST_NAMES[RAND.nextInt(FIRST_NAMES.length)];
                String apellido = LAST_NAMES[RAND.nextInt(LAST_NAMES.length)];
                String line = tipo + ";" + numero + ";" + nombre + ";" + apellido;
                bw.write(line);
                bw.newLine();

                GENERATED_SALESMEN.add(new Salesman(tipo, String.valueOf(numero), nombre, apellido));
            }
        }
    }

    public static void createProductsFile(int productsCount) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("productos.txt"))) {
            generatedProductsCount = productsCount;
            for (int i = 1; i <= productsCount; i++) {
                String nombreProducto = PRODUCT_NAMES[RAND.nextInt(PRODUCT_NAMES.length)] + "_" + i;
                double precio = 1000 + RAND.nextInt(9001) + RAND.nextDouble();
                String precioStr = PRICE_FMT.format(precio);
                bw.write(i + ";" + nombreProducto + ";" + precioStr);
                bw.newLine();
            }
        }
    }

    public static void createSalesMenFile(int randomSalesCount, String name, long id) throws IOException {
        String filename = "ventas_" + id + ".txt";
        String tipoDoc = DOC_TYPES[RAND.nextInt(DOC_TYPES.length)];

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write(tipoDoc + ";" + id);
            bw.newLine();

            if (generatedProductsCount <= 0) {
                generatedProductsCount = 10;
            }

            for (int i = 0; i < randomSalesCount; i++) {
                int idProducto = 1 + RAND.nextInt(generatedProductsCount);
                int cantidad = 1 + RAND.nextInt(20);
                bw.write(idProducto + ";" + cantidad + ";");
                bw.newLine();
            }
        }
    }

    private static class Salesman {
        final String docType;
        final String documentNumber;
        final String name;
        final String lastName;

        Salesman(String docType, String documentNumber, String name, String lastName) {
            this.docType = docType;
            this.documentNumber = documentNumber;
            this.name = name;
            this.lastName = lastName;
        }

        String getFullName() {
            return name + " " + lastName;
        }
    }
}
