package hh.swd20.moviedb.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TvshowRepository extends CrudRepository<Tvshow, Long> {

    List<Tvshow> findByTitle(String title);
    List<Tvshow> findByCreator(String creator);
    
}