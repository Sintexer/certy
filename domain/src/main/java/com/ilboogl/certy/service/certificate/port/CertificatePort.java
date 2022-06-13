package com.ilboogl.certy.service.certificate.port;

import com.ilboogl.certy.service.certificate.Certificate;

import java.util.Optional;

/**
 * Certificate port for persistence operations.
 */
public interface CertificatePort {

    /**
     * Returns certificate by id.
     *
     * @param id certificate id
     * @return certificate optional found by id
     */
    Optional<Certificate> findById(Long id);

    /**
     * Saves certificate. Can be used either for create and update operations.
     *
     * @param certificate certificate object to persist
     * @return certificate after saving, if it was new certificate with null instead of id,
     * then returned object will have generated id
     */
    Certificate save(Certificate certificate);

    /**
     * Deletes certificate.
     *
     * @param id certificate id
     */
    void deleteById(Long id);
}
