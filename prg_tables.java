package PRG556_Project;

import java.util.LinkedList;
import java.util.List;

public class prg_tables {
	List<prg_tables> _prg_tables = new LinkedList<prg_tables>();
	
	public String firstname;
	public String lastname;
	public String email;
	public String id;
	public String password;
	
	
	void addNew(prg_tables Prg_tables)
	{
		_prg_tables.add(Prg_tables);
	}
	public List<prg_tables> getPrg_tables()
	{
		return _prg_tables;
	}
	

	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	
}
