package seminars.second.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    Car car;

    @BeforeEach
    void prepareData() {
        car = new Car("Ford", "Focus", 2000);
    }


    @Test
    /**
     * Проверить, что экземпляр объекта Car также является экземпляром транспортного средства (используя
     * оператор instanceof)
     */
    void isVehicleTest() {
        assertInstanceOf(Vehicle.class, car);
    }

    @Test
    void testDrive() {
        /**
         * Проверить, что объект Car развивает скорость 60 в режиме тестового
         * вождения (используя метод testDrive()).
         */
        car.testDrive();
        assertThat(car.getSpeed()).isEqualTo(60);
    }

    @Test
    void park() {
        /**
         * Проверить, что в режиме парковки (сначала testDrive, потом park, т.е. эмуляция движения транспорта) машина
         * останавливается (speed = 0).
         */
        car.testDrive();
        car.park();
        assertThat(car.getSpeed()).isEqualTo(0);
    }

    @Test
    void getNumWheels() {
        /**
         * Проверить, что объект Car создается с 4-мя колесами.
         */
        assertThat(car.getNumWheels()).isEqualTo(4);
    }
}