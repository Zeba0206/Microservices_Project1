package com.stackroute.muzixapplication.controller;

import com.stackroute.muzixapplication.Service.TrackService;
import com.stackroute.muzixapplication.domain.Track;
import com.stackroute.muzixapplication.exception.IdNotFoundException;
import com.stackroute.muzixapplication.exception.TrackNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "api/v1/")
public class TrackController {

    TrackService trackService;

    @Autowired
    public TrackController(TrackService trackService) {

        this.trackService = trackService;
    }

    @PostMapping("track")
    public ResponseEntity<?> saveUser(@RequestBody Track album) {
        ResponseEntity responseEntity;
        try {
            trackService.saveAlbum(album);
            responseEntity = new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);

        } catch (Exception ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);


        }
        return responseEntity;
    }

    @PatchMapping("/track")
    public ResponseEntity<?> updateAlbum(@RequestBody Track album) throws IdNotFoundException {
        ResponseEntity responseEntity;
        try {
            trackService.updateTrack(album);
            responseEntity = new ResponseEntity<String>("Updated Successfully", HttpStatus.CREATED);
        } catch (IdNotFoundException exception) {
            responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }


    @PutMapping("/track")
    public ResponseEntity<?> putUpdateAlbum(@RequestBody Track album) {
        ResponseEntity responseEntity;
        try {
            trackService.putUpdateTrack(album);
            responseEntity = new ResponseEntity<String>("Updated Successfully", HttpStatus.CREATED);
        } catch (IdNotFoundException exception) {
            responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @DeleteMapping("/track/{trackid}")
    public ResponseEntity<?> deleteTrack(@PathVariable("trackid") int trackid) throws TrackNotFoundException {
        ResponseEntity responseEntity;
        try {
            trackService.deleteTrack(trackid);
            responseEntity = new ResponseEntity<String>("Deleted successfully", HttpStatus.OK);
        } catch (TrackNotFoundException exception) {

            responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("tracks")
    public ResponseEntity<?> getAllAlbums() {
        return new ResponseEntity<List<Track>>(trackService.getAllAlbums(), HttpStatus.OK);
    }


}
