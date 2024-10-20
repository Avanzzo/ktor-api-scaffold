package avanzo.ktor.auth

import com.auth0.jwt.algorithms.Algorithm


data class JwtConfig(
    val realm: String,
    val issuer: String,
    val secret: String,
    val audience: String,
    val expiration: Long // in milliseconds
) {
    val algorithm: Algorithm = Algorithm.HMAC256(secret)
}
