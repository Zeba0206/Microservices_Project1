package com.stackroute.muzixapplication.service;

import com.stackroute.muzixapplication.Service.MuzixServiceImpl;
import com.stackroute.muzixapplication.domain.Track;
import com.stackroute.muzixapplication.exception.*;
import com.stackroute.muzixapplication.respository.MuzixRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class MuzixServiceTest {

    private Track album;

    //Create a mock for UserRepository
    @Mock
    private MuzixRepository muzixRepository;

    //Inject the mocks as dependencies into UserServiceImpl
    @InjectMocks
    private MuzixServiceImpl muzixService;
    List<Track> list= null;


    @Before
    public void setUp(){
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        album = new Track();
        album.setTrackid(4);
        album.setTrackname("Darkside");
        album.setTrackartist("Alan walker");
        album.setGenre("pop");
        list = new ArrayList<>();
        list.add(album);


    }

    @Test
    public void saveUserTestSuccess() throws TrackAlreadyExistsException{

        when(muzixRepository.save((Track) any())).thenReturn(album);
        Track savedUser = muzixService.saveAlbum(album);
        Assert.assertEquals(album,savedUser);

        //verify here verifies that userRepository save method is only called once
        verify(muzixRepository,times(1)).save(album);

    }

    @Test(expected = TrackAlreadyExistsException.class)
    public void saveUserTestFailure() throws TrackAlreadyExistsException {
        when(muzixRepository.save((Track) any())).thenReturn(null);
        Track savedUser = muzixService.saveAlbum(album);
        System.out.println("savedUser" + savedUser);
        Assert.assertEquals(album,savedUser);

       /*doThrow(new UserAlreadyExistException()).when(userRepository).findById(eq(101));
       userService.saveUser(user);*/


    }

    @Test
    public void getAllUser(){

        muzixRepository.save(album);
        //stubbing the mock to return specific data
        when(muzixRepository.findAll()).thenReturn(list);
        List<Track> userlist = muzixService.getAllAlbums();
        Assert.assertEquals(list,userlist);
    }





}

