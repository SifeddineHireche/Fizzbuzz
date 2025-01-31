package com.entreprise.app.rest.Service;

import com.entreprise.app.rest.Model.FizzBuzzDemand;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class FizzBuzzServiceImpl implements FizzBuzzService{

    private final Map<String, AtomicInteger> requestCount = new ConcurrentHashMap<>();

    @Override
    public ArrayList<String> fizzBuzzResult(FizzBuzzDemand objetFizz) {
        ArrayList<String> result = new ArrayList<>();
        String key = objetFizz.getInt1() + "," + objetFizz.getInt2()+ "," + objetFizz.getLimit() + "," + objetFizz.getStr1() + "," + objetFizz.getStr2();

        requestCount.computeIfAbsent(key, k -> new AtomicInteger(0)).incrementAndGet();

        for (int i = 1; i <= objetFizz.getLimit(); i++) {
            if (multipleDesDeux(i, objetFizz.getInt1(), objetFizz.getInt2())) {
                result.add(objetFizz.getStr1() + objetFizz.getStr2());
            } else if (multiple(i, objetFizz.getInt1())) {
                result.add(objetFizz.getStr1());
            } else if (multiple(i, objetFizz.getInt2())) {
                result.add(objetFizz.getStr2());
            } else {
                result.add(String.valueOf(i));
            }
        }

        return result;
    }
    public boolean multipleDesDeux(int number, int int1, int int2) {
        return number % int1 == 0 && number % int2 == 0;
    }

    public boolean multiple(int number, int numberIn) {
        return number % numberIn==0;
    }


    @Override
    public Map<String, Object> getAccionPlusUtilse() {
        if (requestCount.isEmpty()) {
            return Map.of("message", "aucune appel pour le moment.");
        }

        String mostFrequentKey = null;
        int maxHits = 0;

        for (Map.Entry<String, AtomicInteger> entry : requestCount.entrySet()) {
            int hits = entry.getValue().get();
            if (hits > maxHits) {
                maxHits = hits;
                mostFrequentKey = entry.getKey();
            }
        }

        if (mostFrequentKey == null) {
            return Map.of("message", "aucune appel.");
        }

        return Map.of(
                "parameters", mostFrequentKey,
                "nbAppels", (Serializable) maxHits
        );
    }

}

