package com.ilboogl.certy.service.model;

import com.ilboogl.certy.service.certificate.model.Price;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;

public class PriceTest {

    private static final long NEGATIVE_LONG = -1L;
    private static final long POSITIVE_LONG = 1L;

    private static Validator validator;
    private static ExecutableValidator executableValidator;

    @BeforeAll
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        executableValidator = factory.getValidator().forExecutables();
    }

    @ParameterizedTest
    @ValueSource(longs = {1, 2, 100, 0, 100000})
    @DisplayName("Create Price via cents positive scenario")
    void createPriceByCentsPositive(long value) {
        var price = new Price(value);
        var violations = validator.validate(price);
        Assertions.assertTrue(violations.isEmpty(), "Violations set should be empty");
    }

    @ParameterizedTest
    @ValueSource(longs = {1, 2, 100, 0, 100000})
    @DisplayName("Create Price via dollars and cents positive scenario")
    void createPriceByDollarsAndCentsPositive(long value) {
        var price = new Price(value, value);
        var violations = validator.validate(price);
        Assertions.assertTrue(violations.isEmpty(), "Violations set should be empty");
    }

    @ParameterizedTest
    @ValueSource(longs = {-1, -2, -100, -100000})
    @DisplayName("Create Price validation error when dollars and cents are negative")
    void createPriceDollarsAndCentsNegative(long value) {
        var price = new Price(value, value);
        var violations = validator.validate(price);
        Assertions.assertFalse(violations.isEmpty(), "Violations set should not be empty");
    }

    @ParameterizedTest
    @ValueSource(longs = {-1, -2, -100, -100000})
    @DisplayName("Create Price validation error when cents are negative")
    void createPriceCentsNegative(long value) throws NoSuchMethodException {
        var violations = executableValidator.validateConstructorParameters(
                Price.class.getConstructor(long.class),
                new Object[] {NEGATIVE_LONG}
        );
        Assertions.assertFalse(violations.isEmpty(), "Violations set should not be empty");
    }

    @Test
    @DisplayName("Create Price validation error when dollars are valid and cents are negative")
    void createPriceDollarsValidCentsNegative() throws NoSuchMethodException {
        var violations = executableValidator.validateConstructorParameters(
                Price.class.getConstructor(long.class, long.class),
                new Object[] {POSITIVE_LONG, NEGATIVE_LONG}
        );
        Assertions.assertFalse(violations.isEmpty(), "Violations set should not be empty");
    }

    @Test
    @DisplayName("Create Price validation error when dollars are negative and cents are valid")
    void createPriceDollarsNegativeCentsValid() throws NoSuchMethodException {
        var violations = executableValidator.validateConstructorParameters(
                Price.class.getConstructor(long.class, long.class),
                new Object[] {NEGATIVE_LONG, POSITIVE_LONG}
        );
        Assertions.assertFalse(violations.isEmpty(), "Violations set should not be empty");
    }

}
