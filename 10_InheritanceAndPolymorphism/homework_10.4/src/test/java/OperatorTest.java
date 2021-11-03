import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperatorTest {

    private double SALARY = 15000;
    private static final String notExpectedSumMessage = "Сумма зрплаты не соответствует ожидаемой";

    private Operator operator;

    @BeforeEach
    public void setUp() {
        operator = new Operator(SALARY);
    }

    @Test
    @DisplayName("Метод set, попытка дать отрицательную зарплату")
    void setSALARY() {
        Operator operator = new Operator(-25000);
        assertEquals(0, operator.getMonthSalary(),notExpectedSumMessage);
    }

    @Test
    @DisplayName("Метод set, попытка дать бонус оператору")
    void setBONUS() {
        operator.setBonus(3000);
        assertEquals(15000, operator.getMonthSalary(),notExpectedSumMessage);
    }
}