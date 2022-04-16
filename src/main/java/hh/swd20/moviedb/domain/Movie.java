package hh.swd20.moviedb.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	private String title;
	private String director;
	private String actor;
	private String description;
	private int year;
	 
	public Movie(String title, String director, String actor, String description, int year) {
		
		super();
		this.title = title;
		this.director = director;
		this.actor = actor;
		this.description = description;
		this.year = year;
	
	}
	
	public Movie() {
		super();
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	@Override
	public String toString() {
		return "Movie [id=" + id + " title=" + title + ", director=" + director + ", actor=" + actor + ", description="
				+ description + ", year=" + year + "]";
	}
	
}
