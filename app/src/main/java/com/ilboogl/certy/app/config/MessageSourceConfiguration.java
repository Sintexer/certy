package com.ilboogl.certy.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 * Configures application message source by parameters provided in application properties:
 * `certy.messages.source` and `certy.messages.encoding`.
 *
 * If no default encoding provided, UTF8 will be used.
 */
@Configuration
public class MessageSourceConfiguration {

    @Value("${certy.messages.source}")
    private String messagesSourcePath;

    @Value("${certy.messages.encoding:UTF8}")
    private String messagesSourceDefaultEncoding;

    @Bean
    public MessageSource messageSource() {
        var messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename(messagesSourcePath);
        messageSource.setDefaultEncoding(messagesSourceDefaultEncoding);
        return messageSource;
    }
}
