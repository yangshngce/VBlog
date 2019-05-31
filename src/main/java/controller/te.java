package controller;

import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class te {
    @RequestMapping("123")
    public String index() {
        return "123";
    }
    @RequestMapping("index")
    public String qww() {
        return "index";
    }
}
