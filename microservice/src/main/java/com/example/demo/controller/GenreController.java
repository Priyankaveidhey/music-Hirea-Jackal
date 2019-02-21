package com.example.demo.controller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modal.Genre;
import com.example.demo.service.GenreService;

@RestController
@RequestMapping(path = "/core/api/v1/genre")
@CrossOrigin
public class GenreController
{
  @Autowired
  private GenreService genreService;

  @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
  public List<Genre> getAllTracks()
  {
    System.out.println("getAll tracks");
    return genreService.getAllGenre();
  }

  @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON, value = "/{id}")
  public Genre getGenreById(@PathVariable("id") Long id)
  {
    return genreService.genreFindById(id);
  }

  @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
  public Genre saveGenre(@RequestBody Genre genre)
  {
    System.out.println("post genre " + genre.toString());
    return genreService.saveGenre(genre);
  }

  @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON)
  public Genre updateGenre(@RequestBody Genre genre)
  {
    System.out.println("post genre " + genre.toString());
    return genreService.saveGenre(genre);
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
  public void deleteGenre(@PathVariable("id") Long id)
  {
    genreService.deleteGenre(id);
  }
}
