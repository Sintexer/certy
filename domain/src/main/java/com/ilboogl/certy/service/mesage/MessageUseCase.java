package com.ilboogl.certy.service.mesage;

import java.util.Locale;

/**
 * Application internationalized errors provider.
 */
public interface MessageUseCase {

    /**
     * Get message by key using default local.
     *
     * @param key message key
     * @return message in default applications' locale
     */
    String get(String key);

    /**
     * Get internationalized message in provided locale. If message wasn't found in desired locale,
     * default locale value returns instead.
     *
     * @param key message key
     * @param locale desired message's locale
     * @return message in desired locale or in default if it wasn't found in desired.
     */
    String get(String key, Locale locale);

    /**
     * Get internationalized message in provided locale and applies provided message arguments.
     * If message wasn't found in desired locale, default locale value returns instead.
     *
     * @param key message key
     * @param locale desired message's locale
     * @return message in desired locale with arguments inlined or in default if it wasn't found in desired.
     */
    String get(String key, Locale locale, Object...args);

}
