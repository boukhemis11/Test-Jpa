/**
 * 
 */
package banque;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author boukh
 *
 */
public class Virement extends Operation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "beneficiaire")
	private String beneficiaire;
	
	public Virement() {
		super();
	}


	public Virement(LocalDateTime date, Double montant, String type, Compte compte, String beneficiaire) {
		super(date, montant, type , compte);
		this.beneficiaire = beneficiaire;
	}

	@Override
	public String toString() {
		return super.toString() + "\n\t- Bénéficiaire : " + beneficiaire;
	}
}
