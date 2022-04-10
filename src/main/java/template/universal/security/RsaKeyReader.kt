package template.universal.security

import org.springframework.core.io.ClassPathResource
import java.security.KeyFactory
import java.security.interfaces.RSAPrivateKey
import java.security.interfaces.RSAPublicKey
import java.security.spec.PKCS8EncodedKeySpec
import java.security.spec.X509EncodedKeySpec


fun String.rsaPublicKey(): RSAPublicKey {
    ClassPathResource(this).inputStream.use { stream ->
        return KeyFactory.getInstance("RSA").generatePublic(X509EncodedKeySpec(stream.readBytes())) as RSAPublicKey
    }
}

fun String.rsaPrivateKey(): RSAPrivateKey {
    ClassPathResource(this).inputStream.use { stream ->
        return KeyFactory.getInstance("RSA").generatePrivate(PKCS8EncodedKeySpec(stream.readBytes())) as RSAPrivateKey
    }
}