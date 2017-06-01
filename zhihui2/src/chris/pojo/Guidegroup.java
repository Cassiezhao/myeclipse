package chris.pojo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Guidegroup entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "guidegroup", catalog = "zhineng")
public class Guidegroup implements java.io.Serializable {

	// Fields

	private Integer ggid;
	private Area area;
	private String gname;
	private Set<Guide> guides = new HashSet<Guide>(0);

	// Constructors

	/** default constructor */
	public Guidegroup() {
	}

	/** minimal constructor */
	public Guidegroup(Area area, String gname) {
		this.area = area;
		this.gname = gname;
	}

	/** full constructor */
	public Guidegroup(Area area, String gname, Set<Guide> guides) {
		this.area = area;
		this.gname = gname;
		this.guides = guides;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ggid", unique = true, nullable = false)
	public Integer getGgid() {
		return this.ggid;
	}

	public void setGgid(Integer ggid) {
		this.ggid = ggid;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "aid")
	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	@Column(name = "gname",  length = 50)
	public String getGname() {
		return this.gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "guidegroup")
	public Set<Guide> getGuides() {
		return this.guides;
	}

	public void setGuides(Set<Guide> guides) {
		this.guides = guides;
	}

}