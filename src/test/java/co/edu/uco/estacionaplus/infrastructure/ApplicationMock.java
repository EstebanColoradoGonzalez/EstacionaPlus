package co.edu.uco.estacionaplus.infrastructure;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({"co.edu.uco"})
@EnableJpaRepositories(basePackages = "co.edu.uco")
public class ApplicationMock
{

}