/**
 * 
 */
package entite;

import javax.persistence.*;

/**
 * @author boukh
 *
 */
public class Testjpa {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("restaurant-pu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

	}

}
