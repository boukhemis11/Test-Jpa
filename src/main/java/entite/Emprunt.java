/**
 * 
 */
package entite;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * @author boukh
 *
 */
@Entity
@Table( name="emprunt")
public class Emprunt {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "date_debut")
	private Date date_debut;
	@Column(name = "date_fin")
	private Date date_fin;
	@Column(name = "delai")
	private Integer delai;
	
	@ManyToOne
	@JoinColumn(name="ID_CLIENT")
	private Client client; 
	
	@ManyToMany
	@JoinTable(name = "compo", joinColumns = @JoinColumn(name = "ID_EMP", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_LIV", referencedColumnName = "ID"))
	private Set<Livre> livre;
		
	
	public Emprunt() {

	}
	
	
	public Emprunt(Integer id) {

		this.id = id;
	}


	public Emprunt(Integer id, Date date_debut, Date date_fin, Integer delai, Client client, Set<Livre> livre) {
		super();
		this.id = id;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.delai = delai;
		this.client = client;
		this.livre = livre;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Date getDate_debut() {
		return date_debut;
	}


	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}


	public Date getDate_fin() {
		return date_fin;
	}


	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}


	public Integer getDelai() {
		return delai;
	}


	public void setDelai(Integer delai) {
		this.delai = delai;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public Set<Livre> getLivres() {
		return livre;
	}


	public void setLivres(Set<Livre> livres) {
		this.livre = livres;
	}


	@Override
	public String toString() {
		return "Emprunt [id=" + id + ", date_debut=" + date_debut + ", date_fin=" + date_fin + ", delai=" + delai
				 + ", livre=" + livre + "]";
	}

	
	

}
