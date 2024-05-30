package shop.mtcoding.bank.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import shop.mtcoding.bank.dto.ResponseDTO;
import shop.mtcoding.bank.dto.user.UserReqDTO.JoinReqDto;
import shop.mtcoding.bank.dto.user.UserResDTO.JoinRespDto;
import shop.mtcoding.bank.service.UserService;


@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/join")
    public ResponseEntity<?> join(@RequestBody @Valid JoinReqDto joinReqDto, BindingResult bindingResult){    // JSON으로 받을꺼임
        //BindingResult 는 오류가 담김
        
        JoinRespDto joinRespDto = userService.회원가입(joinReqDto);
        return new ResponseEntity<>(new ResponseDTO<>(1,"회원가입 성공",joinRespDto), HttpStatus.CREATED);
    }
    
}
