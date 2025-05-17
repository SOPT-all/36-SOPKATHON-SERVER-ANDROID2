package or.sopt.atsoptkathon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class AtsoptkathonApplication {

    public static void main(String[] args) {
        SpringApplication.run(AtsoptkathonApplication.class, args);
    }

}
