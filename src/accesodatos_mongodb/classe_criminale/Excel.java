package accesodatos_mongodb.classe_criminale;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.bson.Document;

/**
 * EXPORTACIÓN A EXCEL.
 *
 * @author hector
 * @version RTM;
 */
public abstract class Excel {

    /**
     * GENERA EL LIBRO DE EXCEL.
     *
     * @param file : : para obtener la ruta
     * @param lista : : lista de documentos de la base de datos.
     * @return : : estado boolean de la creación del libro Excel.
     */
    public static boolean newExcelBook(File file, Collection<Document> lista) {
        String[] pseudometadatos
                = {"ID", "PAIS", "CIUDAD", "LUGAR", "RUTA IMAGEN"};
        try {
            WorkbookSettings conf = new WorkbookSettings();
            conf.setEncoding("ISO-8859-1");

            WritableWorkbook libro
                    = Workbook.createWorkbook(new File(file.getAbsolutePath() + ".xls"), conf);
            WritableSheet hoja = libro.createSheet("lugares_turisticos", 0);

            WritableFont font
                    = new WritableFont(WritableFont.TAHOMA, 9, WritableFont.NO_BOLD);
            WritableCellFormat formartoDatos = new WritableCellFormat(font);
            WritableFont fontCabecera
                    = new WritableFont(WritableFont.TAHOMA, 9, WritableFont.BOLD);
            WritableCellFormat formatoCabecera
                    = new WritableCellFormat(fontCabecera);

            //Escribe cabeceras en TAHOMA 9pt BOLD
            for (int i = 0; i < pseudometadatos.length; i++) {
                System.out.println("Creando cabecera: " + pseudometadatos[i]);
                hoja.addCell(new jxl.write.Label(i, 0, pseudometadatos[i], formatoCabecera));
            }

            //Creo mi contenedor de destinos;
            ArrayList<Destino> destinos = new ArrayList<>();

            //Recorro mi coleccción y por cada documento creo un objeto destino, con id, pais, ciudad...
            lista.forEach((Document item) -> {

                Document lugaresDoc = (Document) item.get("Lugares");
                Document ImagenesDoc = (Document) item.get("Imagen");

                for (int i = 0; i < lugaresDoc.size(); i++) {

                    Destino dest = new Destino();
                    String noDataLug
                            = (lugaresDoc.getString("lug" + i).length() == 0)
                                    ? " -datos borrados-"
                                    : lugaresDoc.getString("lug" + i);
                    String noDataImg
                            = (ImagenesDoc.getString("img" + i).length() == 0)
                                    ? " -datos borrados-"
                                    : ImagenesDoc.getString("img" + i);

                    dest.setId(item.getString("_id"));
                    dest.setPais(item.getString("Pais"));
                    dest.setCiudad(item.getString("Ciudad"));
                    dest.setLugares(noDataLug);
                    dest.setRuta_imagen(noDataImg);

                    destinos.add(dest);
                };
            });

            //Inserción de datos de los destinos;
            for (int i = 0; i < destinos.size(); i++) {

                String[][] datos = new String[destinos.size()][6];
                datos[i][0] = destinos.get(i).getId();
                datos[i][1] = destinos.get(i).getPais();
                datos[i][2] = destinos.get(i).getCiudad();
                datos[i][3] = destinos.get(i).getRuta_imagen();
                datos[i][4] = destinos.get(i).getLugares();
                for (int j = 0; j < 5; j++) {
                    //Creando Filas Excel
                    hoja.addCell(new jxl.write.Label(j, i + 1, datos[i][j], formartoDatos));
                    System.out.println("Creando fila  excel con nuevo destino:" + i + " espere por favor...");
                }
            }

            libro.write();
            libro.close();

            System.out.println("*** LIBRO EXCEL EXPORTADO CORRECTAMENTE ***");

            return true;

        } catch (WriteException ex) {
            System.out.println("No ha sido posible crear el libro Excel; ERROR DE ESCRITURA");
            return false;
        } catch (IOException ex) {
            System.out.println("No ha sido posible crear el libro Excel; ERROR DE ENTRADA SALIDA");
            return false;
        }
    }
}
