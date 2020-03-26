/**
 * 
 */
package entite;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.*;

/**
 * @author boukh
 *
 */
public class Testjpa {
    private static final Logger LOGGER = Logger.getLogger(Testjpa.class.getName());

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bibliotheque-b");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
     // select en fonction d'un id
        Livre livre = entityManager.find(Livre.class, 1);
        //Livre livre2 = entityManager.find(Livre.class, "titre de livre Vingt mille lieues sous les mers");

        LOGGER.log(Level.INFO, "titre de livre " + livre.getTitre());
        
		// select en fonction d'un titre
		TypedQuery<Livre> query = entityManager.createQuery("SELECT l FROM Livre l WHERE l.titre = 'Germinal'",
				Livre.class);

		Livre l = query.getSingleResult();

		LOGGER.log(Level.INFO, "Select livre Germinal : {0}", l);

        entityManager.close();

        entityManagerFactory.close();
	}

}
