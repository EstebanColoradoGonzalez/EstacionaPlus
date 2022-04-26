package co.edu.uco.estacionaplus.infrastructure.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import java.time.Duration;

@Configuration
public class ConfigurationRestTemplate
{
    private static final int TIME_OUT_DEFAULT = 600;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder)
    {
        return builder.setConnectTimeout(Duration.ofSeconds(TIME_OUT_DEFAULT))
                .setReadTimeout(Duration.ofSeconds(TIME_OUT_DEFAULT))
                .build();
    }
}