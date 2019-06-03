package com.stackroute.muzixapplication.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.muzixapplication.domain.Track;
import com.stackroute.muzixapplication.exception.*;
import com.stackroute.muzixapplication.Service.TrackService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest

public class TrackControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private Track album;
    @MockBean
    private TrackService trackService;
    @InjectMocks
    private TrackController trackController;

    private List<Track> list =null;

    @Before
    public void setUp(){

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(trackController).build();
        album = new Track();
        album.setTrackId(1);
        album.setTrackName("Believer");
        album.setGenre("action");
        album.setTrackArtist("john");
        list = new ArrayList();
        list.add(album);
    }
    @Test
    public void saveAlbum() throws Exception {
        when(trackService.saveAlbum(any())).thenReturn(album);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v2/album")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(album)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    public void saveTrackFailure() throws Exception {
        when(trackService.saveAlbum(any())).thenThrow(TrackAlreadyExistsException.class);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v2/album")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(album)))
                .andExpect(MockMvcResultMatchers.status().isConflict())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void getAllTrack() throws Exception {
        when(trackService.getAllAlbums()).thenReturn(list);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v2/album")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(album)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }


    private static String asJsonString(final Object obj)
    {
        try{
            return new ObjectMapper().writeValueAsString(obj);

        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

}
