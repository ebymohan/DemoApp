package org.joychou.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * safedomain xml，Bean
 */
@Configuration
public class SafeDomainConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(SafeDomainConfig.class);

    @Bean // @BeansafeDomainParserf SpringIOC
    public SafeDomainParser safeDomainParser() {
        try {
            LOGGER.info("SafeDomainParser bean inject successfully!!!");
            return new SafeDomainParser();
        } catch (Exception e) {
            LOGGER.error("SafeDomainParser is null " + e.getMessage(), e);
        }
        return null;
    }

}

