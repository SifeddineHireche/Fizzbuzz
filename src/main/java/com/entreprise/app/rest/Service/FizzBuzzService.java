package com.entreprise.app.rest.Service;

import com.entreprise.app.rest.Model.FizzBuzzDemand;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

@Service
public interface FizzBuzzService {

    public ArrayList<String> fizzBuzzResult(FizzBuzzDemand objetFizz);

    public Map<String, Object> getAccionPlusUtilse();
}