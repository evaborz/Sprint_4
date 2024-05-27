import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.praktikum.Program;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CheckIsAdultTest {

    private static java.lang.Object[][] getTextData;
    private final int age;
    private final boolean result;

    public CheckIsAdultTest(int age, boolean result) {
        this.age = age;
        this.result = result;
    }

    @Parameterized.Parameters
    public static java.lang.Object[][] getTextData() {
        return new Object[][] {
                { 10, false },
                { 18, true },
                {20, true },
                { 21, false }

        };
        return getTextData;
    }

    @Test
    public void checkIsAdultWhenAgeThenResult() {
        Program program = new Program();
        boolean isAdult;
        boolean actualResult = isAdult(age);
        isAdult = program.checkIsAdult();
        assertEquals("Должно вернуться тру если возраст больше 18", result, actualResult);
    }
    public boolean checkIsAdult(int age) {
        return age >= 18;
    }
}
