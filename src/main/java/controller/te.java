package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class te {
//sadasdasd
    @RequestMapping("index")
    public String index() {
        return "index";
    }
}
