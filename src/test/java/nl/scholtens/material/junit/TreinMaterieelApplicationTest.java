package nl.scholtens.material.junit;

import nl.scholtens.material.junit.builders.SessionBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TreinMaterieelApplicationTest extends SessionBuilder {

    @Test
    public void contextLoads() {
    }
}
