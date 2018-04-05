package game.controller;

import game.application.GameState;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CrossInKnotsController {

//    @RequestMapping("/")
//    public String index() {
//        return "index";
//    }

    @RequestMapping( value = "/gameState/", produces = MediaType.APPLICATION_JSON_VALUE )
    public @ResponseBody
    GameState countryByCode(@RequestParam("matrix") String matrix) {

        return new GameState();
    }
}
