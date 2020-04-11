package com.oneToMany.app;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Father implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;

	@OneToMany(mappedBy = "father" 
			, fetch = FetchType.EAGER )
	private List<Children> listOfChilds;

	public long getId() 
	{
		return id;
	}
	public void setId(long id) 
	{
		this.id = id;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public List<Children> getListOfChids() 
	{
		return listOfChilds;
	}
	public void setListOfChids(List<Children> listOfChids) 
	{
		this.listOfChilds = listOfChids;
	}
	public Father() 
	{
		super();
	}
	@Override
	public String toString() 
	{
		return "Father [id=" + id + ", name=" + name +  "]";
	}
}
