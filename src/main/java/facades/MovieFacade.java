package facades;
import entities.Movies;
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
    public static MovieFacade getMovieFacade(EntityManagerFactory _emf) {
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
    public long getMoviesCount(){
        EntityManager em = emf.createEntityManager();
        try{
            long MovieCount = (long)em.createQuery("SELECT COUNT(m) FROM movies m").getSingleResult();
            return MovieCount;
        }finally{  
            em.close();
        }
    }
}
