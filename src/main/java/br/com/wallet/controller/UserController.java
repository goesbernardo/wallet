package br.com.wallet.controller;


import br.com.wallet.dto.UserDTO;
import br.com.wallet.model.User;
import br.com.wallet.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/wallet")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Response<UserDTO>> create(@Valid @RequestBody UserDTO userDTO , BindingResult result) {

        Response<UserDTO> response = new Response<UserDTO>();

         User user =  userService.save(this.convertDTOtoEntity(userDTO));

         response.setData(this.convertEntitytoDTO(user));

         return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    private User convertDTOtoEntity(UserDTO dto ) {

        User user = new User();
        user.setEmail(dto.getEmail());
        user.setName(dto.getName());
        user.setPassword(dto.getPassword());

        return user;
    }

    private UserDTO convertEntitytoDTO(User user){
        UserDTO dto = new UserDTO();
        dto.setEmail(user.getEmail());
        dto.setName(user.getName());
        dto.setPassword(user.getPassword());

        return dto;


    }
}
