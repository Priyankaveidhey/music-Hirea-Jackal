package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modal.Track;

public interface TrackRepository extends JpaRepository<Track, Long>
{

}
