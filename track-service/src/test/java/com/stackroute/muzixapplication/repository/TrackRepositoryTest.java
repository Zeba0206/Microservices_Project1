package com.stackroute.muzixapplication.repository;

import com.stackroute.muzixapplication.domain.Track;
import com.stackroute.muzixapplication.respository.TrackRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest //to slice a particular data

public class TrackRepositoryTest {

    @Autowired
    private TrackRepository trackRepository;
    private Track album;

    @Before
    public void setUp()
    {
        album = new Track();
        album.setTrackId(99);
        album.setTrackName("Shape of you");
        album.setTrackArtist("Ed Sheeran");
        album.setGenre("rock");

    }

    @After
    public void tearDown(){

        trackRepository.deleteAll();
    }


    @Test
    public void testSaveUser(){
        trackRepository.save(album);
        Track fetchUser = trackRepository.findById(album.getTrackId()).get();
        Assert.assertEquals(99,fetchUser.getTrackId());

    }

    @Test
    public void testSaveFailure(){
        Track testUser = new Track(99,"Shape of you","Ed Sheeran","rock");
        trackRepository.save(album);
        Track fetchUser = trackRepository.findById(album.getTrackId()).get();
        Assert.assertNotSame(testUser,album);
    }

    @Test
    public void testGetAllUser(){
        Track u = new Track(11,"Baby","Justin Bieber","pop");
        Track u1 = new Track(12,"Cheap thrills","Sean pual","pop");
        trackRepository.save(u);
        trackRepository.save(u1);

        List<Track> list = trackRepository.findAll();
        Assert.assertEquals("Cheap thrills",list.get(0).getTrackName());




    }


}

