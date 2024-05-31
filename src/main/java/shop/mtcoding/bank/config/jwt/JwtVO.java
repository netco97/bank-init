package shop.mtcoding.bank.config.jwt;

/*
 * SECRET 노출되면 안된다. (환경변수, 클라우드) 
 * 리플레시 토큰 (X)
 */
public interface JwtVO {
    public static final String SECRET = "JWT_SECRETKEY_TEST"; // HS256 (대칭키)
    public static final int EXPIRATION_TIME = 1000 * 60 * 60 * 24 * 7 ; // 일주일
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER = "Authorization";

}
