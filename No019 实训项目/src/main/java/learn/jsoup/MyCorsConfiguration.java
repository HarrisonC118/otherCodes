package learn.jsoup;

import org.springframework.web.cors.CorsConfiguration;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author: HatcherCheung
 * @Date: 2021/12/20
 * @Description:
 */
public class MyCorsConfiguration {
    public CorsConfiguration  getCorsConfiguration() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedHeaders(Collections.singletonList("*"));
        corsConfiguration.setAllowedMethods(Collections.singletonList("*"));
        corsConfiguration.setAllowedOrigins(Collections.singletonList(""));
        return corsConfiguration;
    }
}
