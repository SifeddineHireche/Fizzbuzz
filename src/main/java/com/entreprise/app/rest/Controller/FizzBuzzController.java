package com.entreprise.app.rest.Controller;

import com.entreprise.app.rest.Exceptions.FizzBuzzException;
import com.entreprise.app.rest.Model.FizzBuzzDemand;
import com.entreprise.app.rest.Service.FizzBuzzService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("api/")
public class FizzBuzzController {
    private final FizzBuzzService fizzBuzzService;

    public FizzBuzzController(FizzBuzzService fizzBuzzService) {
        this.fizzBuzzService = fizzBuzzService;
    }

    @GetMapping("/fizzbuzz")
    public ArrayList<String> fizzBuzz(@RequestParam  int int1, @RequestParam  int int2, @RequestParam  int limit,
                                      @RequestParam String str1, @RequestParam String str2) {
        if (int1 <= 0 || int2 <= 0 || limit <= 0) {
            throw new FizzBuzzException("Les entiers doivent etre superieur a 0");
        }



        return fizzBuzzService.fizzBuzzResult(new FizzBuzzDemand(int1,int2,limit,str1,str2));
    }

    @GetMapping("/statisques")
    public Map<String, Object> getMostFrequentRequest() {
        return fizzBuzzService.getAccionPlusUtilse();
    }


}
