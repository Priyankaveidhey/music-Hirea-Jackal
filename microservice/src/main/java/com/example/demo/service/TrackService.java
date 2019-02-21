package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modal.Genre;
import com.example.demo.modal.Track;
import com.example.demo.repository.TrackRepository;

/**
 * 
 * @author
 *
 */

@Service
public class TrackService
{
  /**
   * @
   */
  @Autowired
  private TrackRepository trackRepository;

  /**
   * 
   * @return
   */
  public List<Track> getAllTracks()
  {

    try
    {
      return trackRepository.findAll();
    }
    catch (Exception e)
    {
      System.out.println("Exception occured while fetching all apartment  " + e.getMessage());
      return null;
    }
  }

  /**
   * THis method will create new apartment in database
   * 
   * @param id
   * 
   * @return {@link Tracks}}
   */
  public Track saveTrack(Track track)
  {

    try
    {
      return trackRepository.save(track);
    }
    catch (Exception e)
    {
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
  public void deleteTrack(Long id)
  {

    try
    {
      trackRepository.delete(id);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      System.out.println("Exception occured while delete genre  " + e.getMessage());

    }
  }
}
