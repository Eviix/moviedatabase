package hh.swd20.moviedb.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import hh.swd20.moviedb.domain.Genre;

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
	
    @ManyToOne
	
	@JsonIgnoreProperties ("movies") 
	
	@JoinColumn(name = "genreid")
	private Genre genre;
	 
	public Movie(String title, String director, String actor, String description, int year, Genre genre) {
		
		super();
		this.title = title;
		this.director = director;
		this.actor = actor;
		this.description = description;
		this.year = year;
		this.genre = genre;
	
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
	
	public Genre getGenre() {
		return genre;
	}

	public void setCategory(Genre genre) {
		this.genre = genre;
	}
	
	@Override
	public String toString() {
		if (this.genre != null) 
		return "Movie [id=" + id + " title=" + title + ", director=" + director + ", actor=" + actor + ", description="
				+ description + ", year=" + year + "category=" + this.getGenre() +"]";	
		
		else
			return "Movie [id=" + id + " title=" + title + ", director=" + director + ", actor=" + actor + ", description="
			+ description + ", year=" + year + "]";
	}

}