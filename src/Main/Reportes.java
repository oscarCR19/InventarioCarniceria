package Main;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;

import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Reportes {

    Document documento;
    FileOutputStream archivo;

    public Reportes() {

    }

    public static void hacerReporte(String db, String carniceria) {
        Connection c = null;
        Statement stmt = null;
        ResultSet rs;
        LocalDate hoy= LocalDate.now();
        LocalTime hora=LocalTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        Document documento = new Document();
        Paragraph nombreDocumento = new Paragraph("Carnicerias El Chirriche");
        Paragraph tituloDocumento = new Paragraph("Reporte de inventario");
        Paragraph Sede = new Paragraph("Sede: " + carniceria);
        Paragraph fecha = new Paragraph("Fecha: " + hoy);
        Paragraph horra = new Paragraph("Hora: " + dtf.format(hora));
        try {
            
            
            FileOutputStream archivo = new FileOutputStream("Reporte inventario " + carniceria + ".pdf");
            PdfWriter.getInstance(documento, archivo);
            documento.open();

            nombreDocumento.setAlignment(1);
            Font fuente1 = new Font();
            
            nombreDocumento.setFont(fuente1);
            documento.add(nombreDocumento);
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
            tituloDocumento.setAlignment(0);
            documento.add(tituloDocumento);
            documento.add(Sede);
            documento.add(fecha);
            documento.add(horra);
            
            Image imagen;
            try {
                imagen = Image.getInstance("C:\\Users\\oscar\\Documents\\NetBeansProjects\\Proyecto\\src\\Multimedia\\logochirriche.png");
                imagen.scaleAbsolute(100, 150);
                imagen.setAbsolutePosition(490, 685);

                documento.add(imagen);
            } catch (DocumentException | IOException e) {

            }

            PdfPTable tabla = new PdfPTable(3);
            tabla.setWidthPercentage(100);
            PdfPCell id = new PdfPCell(new Paragraph("Id"));
            id.setBackgroundColor(new BaseColor(253, 255, 215));
            
            PdfPCell nombre = new PdfPCell(new Paragraph("Nombre"));
            nombre.setBackgroundColor(new BaseColor(253, 255, 215));
            
            PdfPCell cantidad = new PdfPCell(new Paragraph("Cantidad"));
            cantidad.setBackgroundColor(new BaseColor(253, 255, 215));
            
            tabla.addCell(id);
            tabla.addCell(nombre);
            tabla.addCell(cantidad);

            try {
                Class.forName("org.postgresql.Driver");
                c = DriverManager
                        .getConnection("jdbc:postgresql://localhost:5432/ChirricheDataBase",
                                "postgres", "root1234");
                stmt = c.createStatement();
                
                rs = stmt.executeQuery("select * from carniceria.\"" + db + "\"");
                while (rs.next()) {
                    int idDb = rs.getInt("idProducto");
                    String nombreDb = rs.getString("nombreProducto");
                    double cantidadDb = rs.getDouble("cantidadProducto");
                    PdfPCell ID = new PdfPCell(new Paragraph(String.valueOf(idDb)));
                    PdfPCell NOMBRE = new PdfPCell(new Paragraph(nombreDb));
                    PdfPCell CANTIDAD = new PdfPCell(new Paragraph(String.valueOf(cantidadDb)));
                    tabla.addCell(ID);
                    tabla.addCell(NOMBRE);
                    tabla.addCell(CANTIDAD);
               }
                rs.close();
                stmt.close();
                c.close();

            } catch (ClassNotFoundException | SQLException e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
            documento.add(Chunk.NEWLINE);
            documento.add(tabla);
            documento.close();

        } catch (DocumentException | FileNotFoundException e) {
            System.out.println(e);
        }
    }
////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////
  public static void ReportePedido(String carniceria,Object fecha, int IdPedido) {

        LocalDate diaActual=LocalDate.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        
        Document documento = new Document();
        Paragraph nombreDocumento = new Paragraph("Carnicerias El Chirriche");
        Paragraph tituloDocumento = new Paragraph("Pedido");
        Paragraph Sede = new Paragraph("Sede: " + carniceria);
        Paragraph date = new Paragraph("Fecha pedido: " + fecha);
        Paragraph IDPe = new Paragraph("Id pedido: " + IdPedido);
        Paragraph diaNow = new Paragraph("Fecha actual: " + diaActual);
        Paragraph hour= new Paragraph("Hora actual: " + dtf.format(LocalTime.now()));
        try {
            FileOutputStream archivo = new FileOutputStream("Reporte de pedido " + carniceria + ".pdf");
            PdfWriter.getInstance(documento, archivo);
            documento.open();

            nombreDocumento.setAlignment(1);
            Font fuente1 = new Font();
            
            nombreDocumento.setFont(fuente1);
            documento.add(nombreDocumento);
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
            tituloDocumento.setAlignment(0);
            documento.add(tituloDocumento);
            documento.add(Sede);
            documento.add(date);
            documento.add(IDPe);
            
            Image imagen;
            try {
                imagen = Image.getInstance("C:\\Users\\oscar\\Documents\\NetBeansProjects\\Proyecto\\src\\Multimedia\\logochirriche.png");
                imagen.scaleAbsolute(100, 150);
                imagen.setAbsolutePosition(490, 685);

                documento.add(imagen);
            } catch (DocumentException | IOException e) {

            }

            PdfPTable tablaPedido = new PdfPTable(3);
            tablaPedido.setWidthPercentage(100);
            PdfPCell id = new PdfPCell(new Paragraph("Id"));
            id.setBackgroundColor(new BaseColor(253, 255, 215));
            
            PdfPCell nombre = new PdfPCell(new Paragraph("Nombre"));
            nombre.setBackgroundColor(new BaseColor(253, 255, 215));
            
            PdfPCell cantidad = new PdfPCell(new Paragraph("Cantidad"));
            cantidad.setBackgroundColor(new BaseColor(253, 255, 215));
            
            tablaPedido.addCell(id);
            tablaPedido.addCell(nombre);
            tablaPedido.addCell(cantidad);

            
                
                for (int i=0;i<Productos.arrayPedido.size();i++) {
                    PdfPCell ID = new PdfPCell(new Paragraph(String.valueOf(Productos.arrayPedido.get(i).getId())));
                    PdfPCell NOMBRE = new PdfPCell(new Paragraph(Productos.arrayPedido.get(i).getNombre()));
                    PdfPCell CANTIDAD = new PdfPCell(new Paragraph(String.valueOf(Productos.arrayPedido.get(i).getCantidad())));
                    tablaPedido.addCell(ID);
                    tablaPedido.addCell(NOMBRE);
                    tablaPedido.addCell(CANTIDAD);
               }
                

            
            documento.add(Chunk.NEWLINE);
            documento.add(tablaPedido);
            documento.add(diaNow);
            documento.add(hour);
            documento.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    } 
    
    
}
