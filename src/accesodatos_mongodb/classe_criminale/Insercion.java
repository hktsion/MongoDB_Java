package accesodatos_mongodb.classe_criminale;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * INICIALIZACIÓN DE BASE DE DATOS, COLECCIONES Y DOCUMENTOS.
 *
 * @author hector
 * @version RTM;
 */
public abstract class Insercion {

    public static void insertar() {
        Conexion conn = new Conexion();
        MongoClient mongo = conn.conectar();
        MongoDatabase db = mongo.getDatabase("MONGO");

        MongoCollection<Document> coll = db.getCollection("destinos");

        String[] paises
                = {"Argentina", "Francia", "Inglaterra", "Estados Unidos", "Argentina"};
        String desc[]
                = {"Cordoba", "Paris", "Londres", "Miami", "Cordoba"};
        String lugares[][] = {
            {"Sierras", "Carlos Paz"},
            {"Louvre", "Palacio Versalles"},
            {"Big Ben", "Cambridge"},
            {"Key Biscane", "Miami Beach"},
            {"Sierras", "Carlos Paz"}
        };
        String imagenes[][] = {
            {"../img/sierras.png", "../img/carlospaz.png"},
            {"../img/louvre.png", "../img/palacioversalles.png"},
            {"../img/bigben.png", "../img/cambridge.png"},
            {"../img/keybiscane.png", "../img/miamibeach.png"},
            {"../img/sierras.png", "../img/carlospaz.png"}
        };

        for (int i = 0; i < lugares.length; i++) {
            Document doc = new Document();
            Document doc2 = new Document();
            Document doc3 = new Document();
            doc.append("_id", "ciu" + i);
            doc.append("Pais", paises[i]);
            doc.append("Ciudad", desc[i]);
            for (int j = 0; j < lugares[i].length; j++) {
                doc.append("Lugares", doc2.append("lug" + j, lugares[i][j]));
                doc.append("Imagen", doc3.append("img" + j, imagenes[i][j]));
            }
            coll.insertOne(doc);
        }

        mongo.close();

    }

}
