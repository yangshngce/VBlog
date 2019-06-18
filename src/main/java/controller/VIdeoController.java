package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.VideoService;

@Controller
public class VIdeoController {

    @Autowired
    private VideoService videoService;

}


