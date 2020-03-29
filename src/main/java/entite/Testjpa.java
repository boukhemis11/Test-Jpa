/**
 * 
 */
package entite;

import java.util.List;
import java.util.Set;
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
        
     // select en fonction d'un id du livre
        Livre livre = entityManager.find(Livre.class, 1);

		System.out.println( livre.getTitre());
        
		// select en fonction d'un titre de livre
		TypedQuery<Livre> query = entityManager.createQuery("SELECT l FROM Livre l WHERE l.titre = 'Germinal'",
				Livre.class);

		Livre l = query.getSingleResult();

		System.out.println(l);
		
		// select en fonction d'un id d'emprunt
		TypedQuery<Livre> query2 = entityManager.createQuery("select l from Livre l join l.emprunt e where e.id=:id", Livre.class)
				.setParameter("id", 1);
		
		List<Livre> livers = query2.getResultList();
		
		for (Livre liver : livers) {
			System.out.println(liver);
		}
		

		
		// select en fonction d'un id de client

		TypedQuery<Emprunt> query3 = entityManager.createQuery("SELECT e FROM Emprunt e JOIN e.client c WHERE c.id =:id", Emprunt.class)
				.setParameter("id", 1);;

		List<Emprunt> emprunts = query3.getResultList();

		for (Emprunt e : emprunts) {
			System.out.println(e);
		}

        entityManager.close();

        entityManagerFactory.close();
	}

}
