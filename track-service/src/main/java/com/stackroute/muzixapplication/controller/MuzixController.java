package com.stackroute.muzixapplication.controller;

import com.stackroute.muzixapplication.Service.MuzixService;
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
//@Autowired
public class MuzixController {

    MuzixService muzixService;

    @Autowired
    public MuzixController(MuzixService muzixService) {

        this.muzixService = muzixService;
    }

    @PostMapping("track")
    public ResponseEntity<?> saveUser(@RequestBody Track album) {
        ResponseEntity responseEntity;
        try {
            muzixService.saveAlbum(album);
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
            muzixService.updateTrack(album);
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
            muzixService.putUpdateTrack(album);
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
            muzixService.deleteTrack(trackid);
            responseEntity = new ResponseEntity<String>("Deleted successfully", HttpStatus.OK);
        } catch (TrackNotFoundException exception) {

            responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("tracks")
    public ResponseEntity<?> getAllAlbums() {
        return new ResponseEntity<List<Track>>(muzixService.getAllAlbums(), HttpStatus.OK);
    }


}
