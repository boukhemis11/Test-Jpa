/**
 * 
 */
package banque;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author boukh
 *
 */
@Embeddable
public class Adresse {
	@Column(name = "numero")
	private Integer numero;
	@Column(name = "rue")
	private String rue;
	@Column(name = "codePostale")
	private int codePostal;
	@Column(name = "Ville")
	private String ville;
	
	
	
	public Adresse() {
		super();
	}
	
	
	public Adresse(int numero, String rue, int codePostal, String ville) {
		super();
		this.numero = numero;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "Adresse [numero=" + numero + ", rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville + "]";
	}

	
}
