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

import com.example.demo.modal.Track;
import com.example.demo.service.TrackService;

@RestController
@RequestMapping(path = "/core/api/v1/track")
@CrossOrigin
public class TrackController
{
  @Autowired
  private TrackService trackService;

  @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
  public List<Track> getAllTracks()
  {
    System.out.println("getAll tracks");
    return trackService.getAllTracks();
  }

  @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
  public Track saveTrack(@RequestBody Track track)
  {
    System.out.println("post tack ");
    return trackService.saveTrack(track);
  }

  @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON)
  public Track updateTrack(@RequestBody Track track)
  {
    System.out.println("put track " + track.toString());
    return trackService.saveTrack(track);
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
  public void deleteTrack(@PathVariable("id") Long id)
  {
    trackService.deleteTrack(id);
  }
}
