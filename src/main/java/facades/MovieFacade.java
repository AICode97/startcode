package facades;

import entities.Movie;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class MovieFacade {

    private static MovieFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private MovieFacade() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static MovieFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new MovieFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    //TODO Remove/Change this before use
    public long getMovieCount(){
        EntityManager em = emf.createEntityManager();
        try{
            long movieCount = (long)em.createQuery("SELECT COUNT(r) FROM Movie r").getSingleResult();
            return movieCount;
        }finally{  
            em.close();
        }
        
    }

}
