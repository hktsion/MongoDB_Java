package accesodatos_mongodb.classe_criminale;

import com.mongodb.MongoClient;

/**
 * CONEXIÓN.
 *
 * @author hector
 * @version RTM;
 */
public class Conexion {

    private MongoClient mongo;

    /**
     * CONEXIÓN.
     *
     * @return : : devuelve la conexión Mongo;
     */
    public MongoClient conectar() {
        mongo = new MongoClient("localhost", 27017);
        return mongo;
    }
}
