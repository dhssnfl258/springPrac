import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

public class test {

    /**
     * Test frame
     */
    @BeforeAll
    static void beforeTest(){
        System.out.println("@BeforeAll");
    }

    @BeforeEach
    public void beforeEach(){
        System.out.println("@BeforeEach");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("@AfterAll");
    }
    @AfterEach
    public void afterEach(){
        System.out.println("@AfterEach");
    }

    @DisplayName("Test1")
    @Test
    public void test1() {
        String name1 = "hi";
        String name2 = "hi2";
        String name3 = "hi";

        assertThat(name1).isNotNull();
        assertThat(name2).isNotNull();
        assertThat(name3).isNotNull();
        assertThat(name1).isNotEqualTo(name2);

    }

    @Test
    public void test2(){
        int num1 = 15;
        int num2 = 0;
        int num3 = -5;

        assertThat(num1).isPositive();
        assertThat(num2).isEqualTo(0);
        assertThat(num3).isNegative();

        assertThat(num1).isGreaterThan(num2);
        assertThat(num3).isLessThan(num2);

    }

    @Test
    public void junitQuiz3(){
        System.out.println("this is first test!");
    }

}
