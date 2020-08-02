package com.khkim.designpatterns.web;

import com.khkim.designpatterns.strategypattern.Duck;
import com.khkim.designpatterns.strategypattern.MallardDuck;
import com.khkim.designpatterns.strategypattern.ModelDuck;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StrategyPatternController {

    @GetMapping("/duck")
    public String duck(@RequestParam(value = "name", defaultValue = "duck") String name) {

        Duck duck;
        if ("MallardDuck".equals(name)) {
            duck = new MallardDuck();
        } else {
            duck = new ModelDuck();
        }

        duck.performFly();
        duck.performQuack();

        return "Duck is a " + duck.toString();
    }
}
