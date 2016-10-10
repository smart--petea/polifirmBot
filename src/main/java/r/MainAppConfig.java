package r;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
public class MainAppConfig {
    @Bean
    public MyBean myBean() {
        return new MyBean();
    }
}
