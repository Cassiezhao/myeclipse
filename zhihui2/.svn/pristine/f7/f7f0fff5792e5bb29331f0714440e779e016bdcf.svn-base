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

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user", catalog = "zhineng")
public class User implements java.io.Serializable {

	// Fields

	private Integer userid;
	private String username;
	private Integer usernum;
	private String userlogTime;
	private Integer userpower;
	private String sex;
	private String tel;
	private String photo;
	private String connect;
	private String password;
	private String count;
	private Integer state;
	private Set<Memory> memories = new HashSet<Memory>(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(String username, Integer usernum, String userlogTime,
			Integer userpower, String sex, String tel, String photo,
			String connect, String password, String count, Integer state,
			Set<Memory> memories) {
		this.username = username;
		this.usernum = usernum;
		this.userlogTime = userlogTime;
		this.userpower = userpower;
		this.sex = sex;
		this.tel = tel;
		this.photo = photo;
		this.connect = connect;
		this.password = password;
		this.count = count;
		this.state = state;
		this.memories = memories;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "userid", unique = true, nullable = false)
	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	@Column(name = "username", length = 10)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "usernum")
	public Integer getUsernum() {
		return this.usernum;
	}

	public void setUsernum(Integer usernum) {
		this.usernum = usernum;
	}

	@Column(name = "userlogTime", length = 50)
	public String getUserlogTime() {
		return this.userlogTime;
	}

	public void setUserlogTime(String userlogTime) {
		this.userlogTime = userlogTime;
	}

	@Column(name = "userpower")
	public Integer getUserpower() {
		return this.userpower;
	}

	public void setUserpower(Integer userpower) {
		this.userpower = userpower;
	}

	@Column(name = "sex", length = 5)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "tel", length = 30)
	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "photo", length = 20)
	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Column(name = "connect", length = 50)
	public String getConnect() {
		return this.connect;
	}

	public void setConnect(String connect) {
		this.connect = connect;
	}

	@Column(name = "password", length = 20)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "count", length = 20)
	public String getCount() {
		return this.count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	@Column(name = "state")
	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Memory> getMemories() {
		return this.memories;
	}

	public void setMemories(Set<Memory> memories) {
		this.memories = memories;
	}

}