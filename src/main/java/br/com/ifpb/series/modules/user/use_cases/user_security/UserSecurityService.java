package br.com.ifpb.series.modules.user.use_cases.user_security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpb.series.modules.security.JwtUser;
import br.com.ifpb.series.modules.security.services.UserService;
import br.com.ifpb.series.modules.user.dtos.UserDTO;
import br.com.ifpb.series.modules.user.entities.User;
import br.com.ifpb.series.modules.user.mappers.UserMapper;
import br.com.ifpb.series.modules.user.repositories.UserRepository;

@Service
public class UserSecurityService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public UserDTO service() {

        JwtUser jwtUser = UserService.authenticated();

        if (jwtUser == null) {}

        User user = userRepository.findOneById(jwtUser.getId()).get();

        if (user == null) {}

        return userMapper.toDTO(user);
    }
}
