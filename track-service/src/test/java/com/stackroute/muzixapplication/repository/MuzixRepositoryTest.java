package com.stackroute.muzixapplication.repository;

import com.stackroute.muzixapplication.domain.Track;
import com.stackroute.muzixapplication.respository.MuzixRepository;
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

public class MuzixRepositoryTest {

    @Autowired
    private MuzixRepository muzixRepository;
    private Track album;

    @Before
    public void setUp()
    {
        album = new Track();
        album.setTrackid(99);
        album.setTrackname("Shape of you");
        album.setTrackartist("Ed Sheeran");
        album.setGenre("rock");

    }

    @After
    public void tearDown(){

        muzixRepository.deleteAll();
    }


    @Test
    public void testSaveUser(){
        muzixRepository.save(album);
        Track fetchUser = muzixRepository.findById(album.getTrackid()).get();
        Assert.assertEquals(99,fetchUser.getTrackid());

    }

    @Test
    public void testSaveFailure(){
        Track testUser = new Track(99,"Shape of you","Ed Sheeran","rock");
        muzixRepository.save(album);
        Track fetchUser = muzixRepository.findById(album.getTrackid()).get();
        Assert.assertNotSame(testUser,album);
    }

    @Test
    public void testGetAllUser(){
        Track u = new Track(11,"Baby","Justin Bieber","pop");
        Track u1 = new Track(12,"Cheap thrills","Sean pual","pop");
        muzixRepository.save(u);
        muzixRepository.save(u1);

        List<Track> list = muzixRepository.findAll();
        Assert.assertEquals("Cheap thrills",list.get(0).getTrackname());




    }


}

