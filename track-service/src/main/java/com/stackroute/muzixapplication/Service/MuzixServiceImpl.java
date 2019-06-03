package com.stackroute.muzixapplication.Service;

import com.stackroute.muzixapplication.domain.Track;
import com.stackroute.muzixapplication.exception.IdNotFoundException;
import com.stackroute.muzixapplication.exception.TrackAlreadyExistsException;
import com.stackroute.muzixapplication.exception.TrackNotFoundException;
import com.stackroute.muzixapplication.respository.MuzixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MuzixServiceImpl implements MuzixService {
    MuzixRepository muzixRepository;

    @Autowired
    public MuzixServiceImpl(MuzixRepository muzixRepository) {

        this.muzixRepository = muzixRepository;
    }

    @Override
    public Track saveAlbum(Track album) throws TrackAlreadyExistsException {

        if (muzixRepository.existsById(album.getTrackId())) {
            throw new TrackAlreadyExistsException("album Already Exists");
        }
        Track savedAlbum = muzixRepository.save(album);
        if (savedAlbum == null) {
            throw new TrackAlreadyExistsException("track already exist exception");
        }
        return savedAlbum;
    }

    @Override
    public List<Track> getAllAlbums() {
        return muzixRepository.findAll();
    }

    /*@Override
    public List<Track> getByName(String trackname) throws TrackNotFoundException {
        List<Track> albums=muzixRepository.getByName(trackname);
        if(albums.isEmpty())
        {
            throw new TrackNotFoundException("Track id not found");
        }
        return albums;
    }*/
    @Override
    public Track updateTrack(Track album) throws IdNotFoundException {
        if (muzixRepository.existsById(album.getTrackId())) {
            Track savedAlbum = muzixRepository.save(album);
        }

        Track updateTrack = muzixRepository.save(album);
        return updateTrack;
    }

    @Override
    public Track putUpdateTrack(Track album) throws IdNotFoundException {
        Track savedAlbum;
        if (muzixRepository.existsById(album.getTrackId())) {
            savedAlbum = muzixRepository.save(album);
            return savedAlbum;
        } else {
            throw new IdNotFoundException("Track id not found");
        }

    }

    @Override
    public boolean deleteTrack(int trackid) throws TrackNotFoundException {
        boolean status = false;
        if (muzixRepository.existsById(trackid)) {
            muzixRepository.deleteById(trackid);
            status = true;
            return status;
        } else {
            throw new TrackNotFoundException("Track id not found");
        }


    }
}
