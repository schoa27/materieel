package nl.scholtens.material.cucumber;

import nl.scholtens.material.TreinMaterieelApplication;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(
        classes = TreinMaterieelApplication.class
       ,loader = SpringBootContextLoader.class
)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT )
public abstract class MaterialFeatureTest {}
