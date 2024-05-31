package shop.mtcoding.bank.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletResponse;
import shop.mtcoding.bank.dto.ResponseDTO;

public class CustomResponseUtil {
    private static final Logger log = LoggerFactory.getLogger(CustomResponseUtil.class);
    
    public static void success(HttpServletResponse response, Object dto){
        
        try {
            ObjectMapper om = new ObjectMapper();
            ResponseDTO<?> responseDTO = new ResponseDTO<>(1, "로그인성공", dto);
            String responseBody = om.writeValueAsString(responseDTO); 
            response.setContentType("application/json; charset=utf-8");
            response.setStatus(200);
            response.getWriter().print(responseBody); // 예쁘게 메세지를 포장하는 공통적인 응답 DTO
        } catch (Exception e) {
            log.error("서버 파싱 에러");
        }
    }

    public static void unAuthentication(HttpServletResponse response, String msg){
        
        try {
            ObjectMapper om = new ObjectMapper();
            ResponseDTO<?> responseDTO = new ResponseDTO<>(-1, msg, null);
            String responseBody = om.writeValueAsString(responseDTO); // JSON변환
            response.setContentType("application/json; charset=utf-8");
            response.setStatus(401);
            response.getWriter().print(responseBody); // 예쁘게 메세지를 포장하는 공통적인 응답 DTO
        } catch (Exception e) {
            log.error("서버 파싱 에러");
        }
    }
}
