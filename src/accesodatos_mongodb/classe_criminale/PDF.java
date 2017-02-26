package accesodatos_mongodb.classe_criminale;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import javax.swing.JOptionPane;
import org.bson.Document;

/**
 * GENERA UN PDF CON LOS DATOS DE TODOS LOS DOCUMENTOS.
 *
 * @author hector
 * @version RTM;
 */
public class PDF {

    public static boolean newPDFDoc(File file, Collection<Document> lista) {
        //EXPORTAR A PDF
        try {
            String[] pseudometadatos
                    = {"ID", "PAIS", "CIUDAD", "LUGAR", "RUTA IMAGEN"};
            FileOutputStream archivo
                    = new FileOutputStream(file.getAbsolutePath() + ".pdf");

            com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
            PdfWriter.getInstance((com.itextpdf.text.Document) doc, archivo);

            //Creando el documento;
            doc.open();
            doc.addTitle("Mongo Tours");
            doc.addAuthor("Héctor Ochoa");
            doc.add(new Paragraph("LISTADO DE DESTINOS\n\n", new Font(Font.FontFamily.COURIER, 20, Font.BOLD)));

            //Inserta documentos de la colección con un foreach y da formato COURIER, 16pt;
            lista.forEach((Document raf) -> {
                Document filaLugares = (Document) raf.get("Lugares");
                for (int i = 0; i < filaLugares.size(); i++) {
                    try {
                        Document lugaresDoc = (Document) raf.get("Lugares");
                        Document ImagenesDoc = (Document) raf.get("Imagen");
                        //Recojo cada uno de los documentos de las colecciones;
                        Object[] objects
                                = {raf.get("_id"), raf.get("Pais"), raf.get("Ciudad"), lugaresDoc.get("lug" + i), ImagenesDoc.get("img" + i)};
                        //Si se han borrado los lugares y las respectivas imágenes, informo de que los datos han sido borrados;
                        objects[3]
                                = (lugaresDoc.get("lug" + i).toString().trim().length() == 0)
                                        ? " - dato borrado -"
                                        : lugaresDoc.get("lug" + i);
                        objects[4]
                                = (ImagenesDoc.get("img" + i).toString().trim().length() == 0)
                                        ? " - dato borrado -"
                                        : ImagenesDoc.get("img" + i);
                        //Añado filas al PDF;
                        doc.add(new Paragraph(
                                pseudometadatos[0] + ": " + objects[0] + "\n" +
                                pseudometadatos[1] + ": " + objects[1] + "\n" +
                                pseudometadatos[2] + ": " + objects[2] + "\n" +
                                pseudometadatos[3] + ": " + objects[3] + "\n" +
                                pseudometadatos[4] + ": " + objects[4] + "\n" +
                                "\n\n", new Font(Font.FontFamily.COURIER, 16, Font.NORMAL)));
                        System.out.println("Escribiendo datos en el archivo PDF... espere por favor");

                    } catch (DocumentException ex) {
                        JOptionPane.showMessageDialog(null,
                                "No se ha podido completar el documento",
                                "DESTINOS TURÍSTICOS - Error de generación de PDF",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            //Cierro el documento;
            doc.close();

        } catch (IOException ex) {
            System.out.println("No ha sido posible crear el documento; ERROR ENTRADA/SALIDA");
            return false;
        } catch (DocumentException ex) {
            System.out.println("No ha sido posible crear el documento; DOCUMENT EXCEPTION");
        }
        return true;
    }
}
