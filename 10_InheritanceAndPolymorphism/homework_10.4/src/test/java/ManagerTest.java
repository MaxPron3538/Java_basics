import net.sf.saxon.expr.Component;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManagerTest {

    private double SALARY = 20000;
    private static final String notExpectedSumMessage = "Сумма зрплаты не соответствует ожидаемой";

    private Manager manager;

    @BeforeEach
    public void setUp() {
        manager = new Manager(SALARY);
    }

    @Test
    @DisplayName("Метод set, попытка дать отрицательную зарплату")
    void setSALARY() {
        Manager manager = new Manager(-15000);
        assertEquals(0, manager.getMonthSalary(),notExpectedSumMessage);
    }

    @Test
    @DisplayName("Метод set, попытка дать отрицательный бонус работнику")
    void setBONUS() {
        manager.setBonus(-2000);
        assertEquals(20000, manager.getMonthSalary(),notExpectedSumMessage);
    }
}