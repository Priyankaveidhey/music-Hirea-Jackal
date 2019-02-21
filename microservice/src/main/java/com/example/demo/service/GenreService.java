package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modal.Genre;
import com.example.demo.repository.GenreRepository;

/**
 * 
 * @author
 *
 */

@Service
public class GenreService
{
  /**
   * @
   */
  @Autowired
  private GenreRepository genreRepository;

  /**
   * 
   * @return
   */
  public List<Genre> getAllGenre()
  {

    try
    {
      return genreRepository.findAll();
    }
    catch (Exception e)
    {
      System.out.println("Exception occured while fetching all apartment  " + e.getMessage());
      return null;
    }
  }

  /**
   * THis method will create new track in database
   * 
   * @param id
   * 
   * @return {@link Genre}}
   */
  public Genre saveGenre(Genre genre)
  {

    try
    {
      return genreRepository.save(genre);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      System.out.println("Exception occured while saving new apartment  " + e.getMessage());
      return null;
    }
  }

  /**
   * THis method will delete track in database
   * 
   * @param id
   * 
   * @return {@link Genre}}
   */
  public void deleteGenre(Long id)
  {

    try
    {
      genreRepository.delete(id);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      System.out.println("Exception occured while delete genre  " + e.getMessage());

    }
  }

  public Genre genreFindById(Long id)
  {

    try
    {
      return genreRepository.findById(id);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      System.out.println("Exception occured while delete genre  " + e.getMessage());
      return null;
    }

  }
}
