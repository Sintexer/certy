package com.ilboogl.certy.service.mesage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

/**
 * MessageUseCase implementation that serves as a facade for Spring's {@link MessageSource}.
 */
@Service
public class MessageService implements MessageUseCase {

    private final MessageSource messageSource;

    @Autowired
    public MessageService(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public String get(String key) {
        return messageSource.getMessage(key, new Object[]{}, Locale.getDefault());
    }

    @Override
    public String get(String key, Locale locale) {
        return messageSource.getMessage(key, new Object[]{}, locale);
    }

    @Override
    public String get(String key, Locale locale, Object... args) {
        return messageSource.getMessage(key, args, Locale.getDefault());
    }
}
