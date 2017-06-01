package chris.pojo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Area entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "area", catalog = "zhineng")
public class Area implements java.io.Serializable {

	// Fields

	private Integer aid;
	private String aname;
	private String anum;
	private Set<Guidegroup> guidegroups = new HashSet<Guidegroup>(0);

	// Constructors

	/** default constructor */
	public Area() {
	}

	/** minimal constructor */
	public Area(String aname, String anum) {
		this.aname = aname;
		this.anum = anum;
	}

	/** full constructor */
	public Area(String aname, String anum, Set<Guidegroup> guidegroups) {
		this.aname = aname;
		this.anum = anum;
		this.guidegroups = guidegroups;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "Aid", unique = true, nullable = false)
	public Integer getAid() {
		return this.aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	@Column(name = "Aname",  length = 50)
	public String getAname() {
		return this.aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	@Column(name = "Anum", length = 50)
	public String getAnum() {
		return this.anum;
	}

	public void setAnum(String anum) {
		this.anum = anum;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "area")
	public Set<Guidegroup> getGuidegroups() {
		return this.guidegroups;
	}

	public void setGuidegroups(Set<Guidegroup> guidegroups) {
		this.guidegroups = guidegroups;
	}

}