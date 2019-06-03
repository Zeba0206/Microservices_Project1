package com.stackroute.muzixapplication.Service;

import com.stackroute.muzixapplication.domain.Track;
import com.stackroute.muzixapplication.exception.IdNotFoundException;
import com.stackroute.muzixapplication.exception.TrackAlreadyExistsException;
import com.stackroute.muzixapplication.exception.TrackNotFoundException;

import java.util.List;

//import com.stackroute.muzixapplication.exception.TrackAlreadyExistsException;

public interface MuzixService {


    public Track saveAlbum(Track album) throws TrackAlreadyExistsException;

    public Track updateTrack(Track album) throws IdNotFoundException;

    public Track putUpdateTrack(Track album) throws IdNotFoundException;

    public boolean deleteTrack(int trackid) throws TrackNotFoundException;

    public List<Track> getAllAlbums();


}


