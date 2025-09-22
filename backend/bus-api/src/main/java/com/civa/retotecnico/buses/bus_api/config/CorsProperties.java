package com.civa.retotecnico.buses.bus_api.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
/**
 * Configuration properties for CORS settings
 */
@Component
@ConfigurationProperties(prefix = "cors")
public class CorsProperties {

    private String allowedOrigin = "http://localhost:5173";

    public String getAllowedOrigin() {
        return allowedOrigin;
    }

    public void setAllowedOrigin(String allowedOrigin) {
        this.allowedOrigin = allowedOrigin;
    }
}