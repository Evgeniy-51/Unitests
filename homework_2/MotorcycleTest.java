package seminars.second.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MotorcycleTest {
    Motorcycle moto;

    @BeforeEach
    void prepareData() {
        moto = new Motorcycle("Honda", "CBR 1000RR", 2008);
    }


    @Test
    void testDrive() {
        /**
         * Проверить, что объект Motorcycle развивает скорость 75 в режиме тестового вождения (используя метод
         * testDrive()).
         */
        moto.testDrive();
        assertThat(moto.getSpeed()).isEqualTo(75);
    }

    @Test
    void park() {
        /**
         * Проверить, что в режиме парковки (сначала testDrive, потом park, т.е. эмуляция движения транспорта) машина
         * останавливается (speed = 0).
         */
        moto.testDrive();
        moto.park();
        assertThat(moto.getSpeed()).isEqualTo(0);
    }

    @Test
    void getNumWheels() {
        /**
         * Проверить, что объект Car создается с 4-мя колесами.
         */
        assertThat(moto.getNumWheels()).isEqualTo(2);
    }
}