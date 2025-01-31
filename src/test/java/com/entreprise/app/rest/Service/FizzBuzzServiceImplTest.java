package com.entreprise.app.rest.Service;

import com.entreprise.app.rest.Model.FizzBuzzDemand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Map;

class FizzBuzzServiceImplTest {

    private FizzBuzzServiceImpl fizzBuzzService;

    @BeforeEach
    void setUp() {
        fizzBuzzService = new FizzBuzzServiceImpl();
    }

    @Test
    void testFizzBuzzResult_NormalCase() {
        FizzBuzzDemand demand = new FizzBuzzDemand(3, 5, 15, "Fizz", "Buzz");

        ArrayList<String> result = fizzBuzzService.fizzBuzzResult(demand);

        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(15);
        assertThat(result.get(2)).isEqualTo("Fizz");
        assertThat(result.get(4)).isEqualTo("Buzz");
        assertThat(result.get(14)).isEqualTo("FizzBuzz");
    }

    @Test
    void testFizzBuzzResult_DifferentValues() {
        FizzBuzzDemand demand = new FizzBuzzDemand(2, 4, 10, "Foo", "Bar");

        ArrayList<String> result = fizzBuzzService.fizzBuzzResult(demand);

        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(10);
        assertThat(result.get(1)).isEqualTo("Foo");
        assertThat(result.get(3)).isEqualTo("FooBar");
        assertThat(result.get(9)).isEqualTo("Foo");
    }

    @Test
    void testFizzBuzzResult_HandlesSingleElement() {
        FizzBuzzDemand demand = new FizzBuzzDemand(3, 5, 1, "Fizz", "Buzz");

        ArrayList<String> result = fizzBuzzService.fizzBuzzResult(demand);

        assertThat(result).containsExactly("1");
    }

    @Test
    void testMultipleDesDeux() {
        assertThat(fizzBuzzService.multipleDesDeux(15, 3, 5)).isTrue();
        assertThat(fizzBuzzService.multipleDesDeux(10, 3, 5)).isFalse();
    }

    @Test
    void testMultiple() {
        assertThat(fizzBuzzService.multiple(9, 3)).isTrue();
        assertThat(fizzBuzzService.multiple(10, 3)).isFalse();
    }

    @Test
    void testGetAccionPlusUtilse_NoRequests() {
        Map<String, Object> result = fizzBuzzService.getAccionPlusUtilse();

        assertThat(result).containsEntry("message", "aucune appel pour le moment.");
    }

    @Test
    void testGetAccionPlusUtilse_OneMostUsedRequest() {
        FizzBuzzDemand demand1 = new FizzBuzzDemand(3, 5, 15, "Fizz", "Buzz");
        FizzBuzzDemand demand2 = new FizzBuzzDemand(2, 4, 10, "Foo", "Bar");

        fizzBuzzService.fizzBuzzResult(demand1);
        fizzBuzzService.fizzBuzzResult(demand1);
        fizzBuzzService.fizzBuzzResult(demand2);

        Map<String, Object> result = fizzBuzzService.getAccionPlusUtilse();

        assertThat(result).containsKeys("parameters", "nbAppels");
        assertThat(result.get("parameters")).isEqualTo("3,5,15,Fizz,Buzz");
        assertThat(result.get("nbAppels")).isEqualTo(2);
    }
}
