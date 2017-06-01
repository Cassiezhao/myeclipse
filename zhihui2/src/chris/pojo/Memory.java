package chris.pojo;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Memory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "memory", catalog = "zhineng")
public class Memory implements java.io.Serializable {

	// Fields

	private Integer mmid;
	private User user;
	private String message;
	private Timestamp mtime;
	private String opuser;

	// Constructors

	/** default constructor */
	public Memory() {
	}

	/** minimal constructor */
	public Memory(String message, Timestamp mtime) {
		this.message = message;
		this.mtime = mtime;
	}

	/** full constructor */
	public Memory(User user, String message, Timestamp mtime, String opuser) {
		this.user = user;
		this.message = message;
		this.mtime = mtime;
		this.opuser = opuser;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "mmid", unique = true, nullable = false)
	public Integer getMmid() {
		return this.mmid;
	}

	public void setMmid(Integer mmid) {
		this.mmid = mmid;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userid")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "message", nullable = false, length = 50)
	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Column(name = "mtime", nullable = false, length = 19)
	public Timestamp getMtime() {
		return this.mtime;
	}

	public void setMtime(Timestamp mtime) {
		this.mtime = mtime;
	}

	@Column(name = "opuser", length = 50)
	public String getOpuser() {
		return this.opuser;
	}

	public void setOpuser(String opuser) {
		this.opuser = opuser;
	}

}