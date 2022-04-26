package co.edu.uco.estacionaplus.infrastructure.adapter.service;

import co.edu.uco.estacionaplus.domain.service.servicelogin.ServiceEncryptText;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

@Component
public class ServiceEncryptTextSHA256 implements ServiceEncryptText
{
    @Override
    public String encryptText(String text)
    {
        return DigestUtils.sha256Hex(text);
    }
}