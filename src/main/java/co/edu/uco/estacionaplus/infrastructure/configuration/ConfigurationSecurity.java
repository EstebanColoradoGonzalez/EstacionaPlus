package co.edu.uco.estacionaplus.infrastructure.configuration;

import co.edu.uco.estacionaplus.infrastructure.filter.AuthenticationFilter;
import co.edu.uco.estacionaplus.infrastructure.service.ServiceValidateToken;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationSecurity
{
    private static final String URL_PATTERN = "/*";

    @Bean
    public FilterRegistrationBean<AuthenticationFilter> authenticationFilter(ServiceValidateToken tokenValidationService)
    {
        FilterRegistrationBean<AuthenticationFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new AuthenticationFilter(tokenValidationService, new String[]{"/api/login","/api/parkings", "/api/users", "/swagger-ui.html","/swagger-ui/index.html","/v3/api-docs/swagger-config","/v3/api-docs", "*.js","*.css","*.png"}));
        registrationBean.addUrlPatterns(URL_PATTERN);

        return registrationBean;
    }
}
