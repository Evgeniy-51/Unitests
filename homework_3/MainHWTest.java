package seminars.third.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seminars.third.coverage.SomeService;

import static org.assertj.core.api.Assertions.*;

class MainHWTest {
    MainHW tasks;

    @BeforeEach
    void setUp() {tasks = new MainHW();}

    /**
     * Напишите тесты, покрывающие на 100% метод evenOddNumber, который проверяет, является ли переданное число
     * четным или нечетным.
     */
    @Test
    void isEvenTrueTest() {
        assertThat(tasks.isEven(4)).isTrue();
    }

    @Test
    void isEvenFalseTest() {
        assertThat(tasks.isEven(3)).isFalse();
    }


    /**
     * Разработайте и протестируйте метод numberInInterval, который проверяет, попадает ли переданное число
     * в интервал (25;100)
     */
    @Test
    void numInRangeLessThenMinTest() {
        assertThat(tasks.numInRange(24.99)).isFalse();
    }

    @Test
    void numInRangeEqualMinTest() {
        assertThat(tasks.numInRange(25)).isTrue();
    }

    @Test
    void numInRangeTrueTest() {
        assertThat(tasks.numInRange(50)).isTrue();
    }

    @Test
    void numInRangeEqualMaxTest() {
        assertThat(tasks.numInRange(100)).isTrue();
    }

    @Test
    void numInRangeMoreMaxTest() {
        assertThat(tasks.numInRange(100.1)).isFalse();
    }
}