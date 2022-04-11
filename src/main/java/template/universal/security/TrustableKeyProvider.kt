package template.universal.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import template.universal.model.TrustableKey

@Component
class TrustableKeyProvider {
    @Autowired
    private lateinit var jwtManager: JwtManager

    fun signTrustableToken(trustableKey: TrustableKey): String {
        return jwtManager.signTrustableKey(trustableKey)
    }

    fun verifyTrustableToken(token: String): TrustableKey? {
        return jwtManager.verifyTrustableKey(token)
    }
}