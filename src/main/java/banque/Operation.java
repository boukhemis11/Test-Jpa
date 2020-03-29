/**
 * 
 */
package banque;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author boukh
 *
 */
@Entity
@Table( name="operation")
public class Operation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "date")
	private LocalDateTime date;
	@Column(name = "montant")
	private Double montant;
	@Column(name = "type")
	private String type;
	@ManyToOne
	@JoinColumn(name = "id_compte")
	private Compte compte;
	
	public Operation() {
		super();
	}
	
	public Operation(LocalDateTime date, Double montant,String type, Compte compte) {
		super();
		this.date = date;
		this.montant = montant;
		this.type = type;
		this.compte = compte;

	}

	public Operation(Integer id, LocalDateTime date, Double montant, Compte compte) {
		super();
		this.id = id;
		this.date = date;
		this.montant = montant;
		this.compte = compte;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	@Override
	public String toString() {
		return "Operation [id=" + id + ", date=" + date + ", montant=" + montant + ", compte=" + compte + "]";
	}
	
	
}
