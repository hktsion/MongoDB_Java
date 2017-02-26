package accesodatos_mongodb.classe_criminale;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.Collection;
import org.bson.Document;

/**
 * REALIZA EL CREATE, READ, UPDATE AND DELETE DE DOCUMENTOS.
 *
 * @author hector
 * @version RTM;
 */
public class CRUD {

    private final MongoClient cliente;
    private MongoDatabase database;
    private MongoCollection collection;

    public CRUD() {
        if ((cliente = new Conexion().conectar()) == null) {
            System.out.println("No se ha podico conectar a la base de datos");
            return;
        }
        database = cliente.getDatabase("MONGO");
        collection = database.getCollection("destinos");
    }

    /**
     * DEVUELVE LUGARES DE LA ID QUE SE SELECCIONE;
     *
     * @param dest : : Objeto de la clase Destino;
     * @return : : Devuelve ArrayList con los subdocumentos Lugares que
     * encuentra con la ID que le pasamos por parámetro a través del objeto
     * destino;
     */
    public ArrayList<Object> dameLosLugaresQueTieneTuID(Destino dest) {
        //Me aseguro de que  mi colleccion de documentos (listaReturn) sólo tiene un elemento, el del ID seleccionado
        FindIterable<Document> findIterable
                = collection.find(new BasicDBObject("_id", dest.getId()));

        //Mediante un cursor y un contenedor (arrayList) recojo los Lugares por cada ID;
        ArrayList<Object> lista = new ArrayList<>();
        MongoCursor<Document> cursor = findIterable.iterator();
        while (cursor.hasNext()) {
            Document doc = cursor.next();
            lista.add(doc.get("Lugares"));
        }
        return lista;
    }

    /**
     * ID DEL PRÓXIMO ELEMENTO QUE SE INSERTARÁ;
     *
     * @return : : devuelve el último índice insertado en la base de datos para
     * poder incrementarlo en la siguiente inserción;
     */
    public String ultimo_ID_Insertado() {
        Document myDoc
                = (Document) collection.find().sort(new BasicDBObject("_id", -1)).first();
        String ultimoIndice = myDoc.getString("_id");
        System.out.println("ÚLTIMO ID AÑADIDO A LA COLECCIÓN: " + ultimoIndice);
        return ultimoIndice;
    }

    /**
     * SELECCIONA por ID;
     *
     * @param dest : : Objeto de la clase Destino;
     * @return: : Devuelve ArrayList con el documento que tiene esa ID;
     */
    public Collection<Document> selectXid(Destino dest) {
        BasicDBObject whatIwanttomodify = new BasicDBObject();
        whatIwanttomodify.put("_id", dest.getId());
        FindIterable res = collection.find(whatIwanttomodify);
        Collection<Document> list = MongoUtils.returnAll(res);
        System.out.println("*** Se ha seleccionado el documento con ID = " + dest.getId() + " para realizar una acción***");
        return list;
    }

    /**
     * SELECCIONA TODOS LOS DOCUMENTOS
     *
     * @return : : devuelve todos los documentos de la base de datos.
     */
    public Collection<Document> selectXall() {
        FindIterable<Document> iterable = collection.find();
        Collection<Document> list = MongoUtils.returnAll(iterable);
        return list;
    }

    /**
     * UPDATE;
     *
     * @param dest : : objeto de tipo Destino
     * @param lista : : contiene el documento que se quiere modificar;
     * @return : : estado boolean del update
     */
    public boolean update(Destino dest, ArrayList<Object> lista) {
        Document docFind = new Document(); //mi documento principal;
        docFind.append("_id", dest.getId());
        Document newDocumentUpdate = new Document();  //mi documento principal;

        if (!dest.getPais().equals("")) {
            System.out.println("*********************************");
            System.out.println("NUEVO Pais: " + dest.getPais());
            System.out.println("*********************************");
            newDocumentUpdate.append("$set", new BasicDBObject("Pais", dest.getPais()));
            collection.findOneAndUpdate(docFind, newDocumentUpdate);
        }
        if (!dest.getCiudad().equals("")) {
            System.out.println("*********************************");
            System.out.println("NUEVA Ciudad: " + dest.getCiudad());
            System.out.println("*********************************");
            newDocumentUpdate.append("$set", new BasicDBObject("Ciudad", dest.getCiudad()));
            collection.findOneAndUpdate(docFind, newDocumentUpdate);
        }
        if (!dest.getLugares().equals("")) {
            newDocumentUpdate.append("$set", new BasicDBObject("Lugares." + updateLugar(lista), dest.getLugares()));
            collection.findOneAndUpdate(docFind, newDocumentUpdate);
            System.out.println("*********************************");
            System.out.println("NUEVO Lugar: " + dest.getLugares());
            System.out.println("*********************************");
        }
        return true;
    }

    /**
     * INSERTAR NUEVO DOCUMENTO;
     *
     * @param destino : : objeto tipo Destino;
     * @return : : estado boolean del insert;
     */
    public boolean insertar(Destino destino) {
        String[] lugares = MongoUtils.rompeComas(destino.getLugares());

        Collection<Document> listadetodoslosdocumentos = selectXall();

        Document doc = new Document();
        Document doc2 = new Document();
        Document doc3 = new Document();
        doc.append("_id", destino.getId());
        doc.append("Pais", destino.getPais());
        doc.append("Ciudad", destino.getCiudad());
        for (int j = 0; j < lugares.length; j++) {
            doc.append("Lugares", doc2.append("lug" + j, lugares[j]));
            doc.append("Imagen", doc3.append("img" + j, "../img/default.png"));
        }
        collection.insertOne(doc);
        return true;
    }

    /**
     * ELIMINA UN ELEMENTO LUGAR DEL DOCUMENTO LUGARES.
     *
     * @param dest : : objeto de tipo Destino
     * @param lista : : subdocumento dentro del documento 'Lugares'
     * @return : : Estado boolean del borrado.
     */
    @SuppressWarnings("empty-statement")
    public boolean delete(Destino dest, ArrayList<Object> lista) {
        String keyLug = null, keyImg = null;
        String[] lugaresBeta
                = MongoUtils.recogeSubdocsDelDocSeleccionado(lista);

        BasicDBObject elnuevocontenido = new BasicDBObject();
        BasicDBObject loquequieromodificar = new BasicDBObject();
        BasicDBObject eliminartodocontenido
                = new BasicDBObject();

        //PAR clave/valor;
        //Clave a modificar:
        loquequieromodificar.append("_id", dest.getId());

        for (int i = 0; i < lugaresBeta.length; i++) {
            if (dest.getLugares().trim().equals(lugaresBeta[i].substring(5).trim())) {
                keyLug = "Lugares.".concat(lugaresBeta[i].substring(0, 4));
                keyImg = "Imagen.img".concat(lugaresBeta[i].substring(3, 4));
            }
        }

        eliminartodocontenido
                .append(keyLug, "")
                .append(keyImg, "");
        elnuevocontenido.append("$set", eliminartodocontenido);

        //Resultado del Update;
        UpdateResult val
                = collection.updateMany(loquequieromodificar, elnuevocontenido);
        System.out.println("DOCUMENTOS ELIMINADOS: " + val.getModifiedCount());

        long confirm = 0;
        if (val.getModifiedCount() != confirm) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * ENTRA EN LOS DOCUMENTOS QUE PUEDA HABER EN OTROS DOCUMENTOS;
     *
     * @param lista : : objeto de tipo Destino
     * @return : : devuelve documento dentro de otro documento;
     */
    public String updateLugar(ArrayList<Object> lista) {
        String[] lugaresBeta
                = MongoUtils.recogeSubdocsDelDocSeleccionado(lista);
        String[] lugaresAlpha = lugaresBeta[0].split("=");
        return lugaresAlpha[0];
    }

}
