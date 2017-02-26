package accesodatos_mongodb.classe_criminale;

import java.util.ArrayList;
import java.util.Collection;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * UTILIDADES Contiene herramientas que facilitan el acceso los datos.
 *
 * @author hector
 * @version RTM;
 */
public abstract class MongoUtils {

    //Devuelve todas las colecciones en un arrayList;
    public static <E> Collection<E> returnAll(Iterable<E> iter) {
        Collection<E> list = new ArrayList<>();
        long value = 0;
        for (E item : iter) {
            System.out.println((value + 1) + " documento/s encontrado/s.");
            list.add(item);
            value++;
        }
        System.out.println("TOTAL de documentos: " + value);
        return list;
    }

    //Limpia los datos de la tabla
    public static void clearJTable(DefaultTableModel ozzy) {
        for (int i = 0; i < ozzy.getRowCount(); i++) {
            ozzy.removeRow(i);
            i -= 1;
        }
    }

    //Inicializa buttons del formulario
    public static void enabledButtons(ArrayList<JButton> botones, boolean antiflag) {
        botones.stream().forEach((btn) -> {
            btn.setEnabled(antiflag);
        });
    }

    //Inicializa textfields del formulario*/
    public static void enabledJTextFields(ArrayList<JTextField> fields, boolean antiflag) {
        fields.stream().forEach((field) -> {
            field.setEnabled(antiflag);
        });
    }

    //Valida que los campos no estén vacíos;
    public static boolean camposVacios(Destino dest) {
        if (dest.getId().trim().equals("") || dest.getPais().trim().equals("") || dest.getCiudad().trim().equals("") || dest.getLugares().trim().equals("")) {
            return true;
        } else {
            return false;
        }
    }

    //Valida si un string comienza por un número
    public static boolean primerCaracterNumerico(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException nfe) {
            nfe.getMessage();
            return false;
        }
    }

    //Valida si un string comienza por un número
    public static boolean isNumeric(String string) {
        int contador = 0;
        String[] strings = string.split("");
        for (String dato : strings) {
            try {
                Integer.parseInt(dato);
                contador += 1;
            } catch (Exception e) {
            }
        }

        if (contador > 0) {
            return true;
        } else {
            return false;
        }
    }

    //Limpia los textFields
    public static boolean limpiaTextFields(ArrayList<JTextField> fields, boolean flag) {
        if (flag) {
            for (int i = 0; i < fields.size(); i++) {
                fields.get(i).setText("");
            }
        }
        return true;
    }

    //Generar ID aleatorio
    public static String nextID(String indiceUltimoElemento) {
        int aux = Integer.parseInt(indiceUltimoElemento.substring(3)) + 1;
        return "ciu" + (aux);
    }

    //Separa los lugares en el insert --> separados por comas;
    public static String[] rompeComas(String cadena) {
        String[] lugaresturisticos = cadena.split(",");
        for (int i = 0; i < lugaresturisticos.length; i++) {
            lugaresturisticos[i] = lugaresturisticos[i].trim();
        }
        return lugaresturisticos;
    }

    //Devuelve el array con  KEY : : VALUE
    public static String[] recogeSubdocsDelDocSeleccionado(ArrayList<Object> lug) {
        String lugaresString = "";
        String[] lugaresBeta = null;
        lugaresString = lug.get(0).toString().replace("Document{{", "").trim();
        lugaresString = lugaresString.replaceAll("}", "").trim();

        //meto las key-values en un array;
        lugaresBeta = lugaresString.split(",");
        for (int i = 0; i < lugaresBeta.length; i++) {
            lugaresBeta[i] = lugaresBeta[i].trim();
        }
        return lugaresBeta;
    }
}
