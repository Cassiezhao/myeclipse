package chris.pojo;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Guidemonitor entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "guidemonitor", catalog = "zhineng")
public class Guidemonitor implements java.io.Serializable {

	// Fields

	private Integer gmid;
	private Timestamp gmtime;
	private String mydir;
	private String guidename;
	private String guidemachine;
	private String guidenum;
	
	// Constructors
	@Column(name = "guidenum")
	public String getGuidenum() {
		return guidenum;
	}

	public void setGuidenum(String guidenum) {
		this.guidenum = guidenum;
	}

	/** default constructor */
	public Guidemonitor() {
	}

	/** full constructor */
	public Guidemonitor(Timestamp gmtime, String mydir, String guidename,
			String guidemachine,String guidenum) {
		this.gmtime = gmtime;
		this.mydir = mydir;
		this.guidename = guidename;
		this.guidemachine = guidemachine;
		this.guidenum=guidenum;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "gmid", unique = true, nullable = false)
	public Integer getGmid() {
		return this.gmid;
	}

	public void setGmid(Integer gmid) {
		this.gmid = gmid;
	}

	@Column(name = "gmtime", nullable = false, length = 19)
	public Timestamp getGmtime() {
		return this.gmtime;
	}

	public void setGmtime(Timestamp gmtime) {
		this.gmtime = gmtime;
	}

	@Column(name = "mydir", nullable = false, length = 50)
	public String getMydir() {
		return this.mydir;
	}

	public void setMydir(String mydir) {
		this.mydir = mydir;
	}

	@Column(name = "guidename", nullable = false, length = 50)
	public String getGuidename() {
		return this.guidename;
	}

	public void setGuidename(String guidename) {
		this.guidename = guidename;
	}

	@Column(name = "guidemachine", nullable = false, length = 50)
	public String getGuidemachine() {
		return this.guidemachine;
	}

	public void setGuidemachine(String guidemachine) {
		this.guidemachine = guidemachine;
	}

}