import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TopManagerTest {

    private double SALARY = 25000;
    private static final String notExpectedSumMessage = "Сумма зрплаты не соответствует ожидаемой";

    private TopManager topManager;

    @BeforeEach
    public void setUp() {
        topManager = new TopManager(SALARY);
    }

    @Test
    @DisplayName("Метод set, попытка дать отрицательную зарплату")
    void setSALARY() {
        TopManager topManager = new TopManager(-15000);
        assertEquals(0, topManager.getMonthSalary(),notExpectedSumMessage);
    }

    @Test
    @DisplayName("Метод set, попытка дать отрицательный бонус топ менеджеру")
    void setBONUS() {
        topManager.setBonus(-5000);
        assertEquals(25000, topManager.getMonthSalary(),notExpectedSumMessage);
    }
}