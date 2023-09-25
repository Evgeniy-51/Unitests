import seminars.first.model.Calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    public static void main(String[] args) {

        /** Задание 1. ** В классе Calculator создайте метод calculateDiscount, который принимает сумму покупки
         * и процент скидки и возвращает сумму с учетом скидки. Ваша задача - проверить этот метод с использованием
         * библиотеки AssertJ. Если метод calculateDiscount получает недопустимые аргументы, он должен выбрасывать
         * исключение ArithmeticException. Не забудьте написать тесты для проверки этого поведения.
         */
        int MAX_DISCOUNT = 40;
        assertThatThrownBy(() -> Calculator.calculatingDiscount(100, 41))
                .isInstanceOf(ArithmeticException.class);

        assertThatThrownBy(() -> Calculator.calculatingDiscount(100, -1))
                .isInstanceOf(ArithmeticException.class);

        assertThatThrownBy(() -> Calculator.calculatingDiscount(-100, 5))
                .isInstanceOf(ArithmeticException.class);

        assertThatThrownBy(() -> Calculator.calculatingDiscount(0, 5))
                .isInstanceOf(ArithmeticException.class);

        assertThat(Calculator.calculatingDiscount(100, 10)).isEqualTo(90);


        double res = Calculator.calculatingDiscount(100, 5);
        System.out.println(res);


        // Проверка базового функционала с целыми числами:
        if (8 != Calculator.calculation(2, 6, '+')) {
            throw new AssertionError("Ошибка в методе");
        }

        if (0 != Calculator.calculation(2, 2, '-')) {
            throw new AssertionError("Ошибка в методе");
        }

        if (14 != Calculator.calculation(2, 7, '*')) {
            throw new AssertionError("Ошибка в методе");
        }

        if (2 != Calculator.calculation(100, 50, '/')) {
            throw new AssertionError("Ошибка в методе");
        }

        // Случаи с неправильными аргументами
        // аргумент operator типа char, должен вызывать исключение, если он получает не базовые символы (+-*/)
        try {
            Calculator.calculation(8, 4, '_');
        } catch (IllegalStateException e) {
            if (!e.getMessage().equals("Unexpected value operator: _")) {
                throw new AssertionError("Ошибка в методе");
            }
        }

        // Проверка базового функционала с целыми числами, с использованием утверждений:
        assert 8 == Calculator.calculation(2, 6, '+');
        assert 0 == Calculator.calculation(2, 2, '-');
        assert 14 == Calculator.calculation(2, 7, '*');
        assert 2 == Calculator.calculation(100, 50, '/');

        // Проверка базового функционала с целыми числами, с использованием утверждений AssertJ:
        assertThat(Calculator.calculation(2, 6, '+')).isEqualTo(8);
        assertThat(Calculator.calculation(2, 2, '-')).isEqualTo(0);
        assertThat(Calculator.calculation(2, 7, '*')).isEqualTo(14);
        assertThat(Calculator.calculation(100, 50, '/')).isEqualTo(2);

        // Проверка ожидаемого исключения, с использованием утверждений AssertJ:
        assertThatThrownBy(() ->
                Calculator.calculation(8, 4, '_')
        ).isInstanceOf(IllegalStateException.class);

//        System.out.println(Calculator.calculation(2_147_483_647, 1, '+')); // integer overflow
//        System.out.println(Calculator.squareRootExtraction(169));
    }
}