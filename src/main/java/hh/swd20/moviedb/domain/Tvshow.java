package hh.swd20.moviedb.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tvshow {

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
		private String creator;
		private String actor;
		private int season;
		private String status;
		private String genre;
		private String description;
		private int year;
		 
		public Tvshow(String title, String creator, String actor, int season, String status, String genre, String description, int year) {
			
			super();
			this.title = title;
			this.creator = creator;
			this.actor = actor;
			this.season = season;
			this.status = status;
			this.genre = genre;
			this.description = description;
			this.year = year;
		
		}
		
		public Tvshow() {
			super();
		}
		
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getCreator() {
			return creator;
		}
		public void setCreator(String creator) {
			this.creator = creator;
		}
		public String getActor() {
			return actor;
		}
		public void setActor(String actor) {
			this.actor = actor;
		}
		public int getSeason() {
			return season;
		}
		public void setSeason(int season) {
			this.season = season;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getGenre() {
			return genre;
		}
		public void setGenre(String genre) {
			this.genre = genre;
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
			return "Tvshow [id=" + id + " title=" + title + ", creator=" + creator + ", actor=" + actor + ", season=" + season + ", status=" + status + ", genre=" + genre + ", description="
					+ description + ", year=" + year + "]";
		}
		
	}
