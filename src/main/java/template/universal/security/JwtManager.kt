package template.universal.security

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.exceptions.JWTVerificationException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import template.universal.model.User
import java.io.File
import java.io.FileOutputStream
import java.security.Key
import java.security.KeyPairGenerator
import java.util.*

@Component
class JwtManager {
    @Autowired
    lateinit var rsaKeyFile: RsaKeyProperties

    private val algorithm by lazy {
        Algorithm.RSA512(
            rsaKeyFile.publicKey.rsaPublicKey(),
            rsaKeyFile.privateKey.rsaPrivateKey()
        )
    }

    fun verify(token: String): String? {
        try {
            val decoded = JWT.require(algorithm).build().verify(token)
            return decoded.subject
        } catch (e: JWTVerificationException) {
            e.printStackTrace()
        }
        return null
    }

    fun sign(user: User): String {
        return JWT.create()
            .withIssuedAt(Date())
            .withExpiresAt(Date(System.currentTimeMillis() + TIMEOUT))
            .withSubject(user.uid)
            .sign(algorithm)
    }

    private fun generateRSAKeyPairs(keysDir: File) {
        val kpg = KeyPairGenerator.getInstance("RSA").apply { initialize(2048) }
        val keyPair = kpg.generateKeyPair()
        val public: Key = keyPair.public
        val private: Key = keyPair.private
        FileOutputStream(File(keysDir, "jwt_rsa.key")).use { out -> out.write(private.encoded) }
        FileOutputStream(File(keysDir, "jwt_rsa.pub")).use { out -> out.write(public.encoded) }
    }

    companion object {
        const val TIMEOUT = 7 * 24 * 60 * 60 * 1000
    }
}