package chris.pojo;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Message entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "message", catalog = "zhineng")
public class Message implements java.io.Serializable {

	// Fields

	private Integer msgid;
	private String guidemnum;
	private Integer status;
	private String content;
	private Timestamp time;

	// Constructors

	/** default constructor */
	public Message() {
	}

	/** full constructor */
	public Message(String guidemnum, Integer status, String content,
			Timestamp time) {
		this.guidemnum = guidemnum;
		this.status = status;
		this.content = content;
		this.time = time;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "Msgid", unique = true, nullable = false)
	public Integer getMsgid() {
		return this.msgid;
	}

	public void setMsgid(Integer msgid) {
		this.msgid = msgid;
	}

	@Column(name = "guidemnum", length = 50)
	public String getGuidemnum() {
		return this.guidemnum;
	}

	public void setGuidemnum(String guidemnum) {
		this.guidemnum = guidemnum;
	}

	@Column(name = "Status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "Content", length = 100)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "Time", length = 19)
	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

}