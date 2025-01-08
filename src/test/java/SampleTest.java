import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class SampleTest {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Before All");
    }
    @Test
    void exampleTest() {
        int sum = 1 + 1;
        Assertions.assertEquals(sum, 2);
    }
}
