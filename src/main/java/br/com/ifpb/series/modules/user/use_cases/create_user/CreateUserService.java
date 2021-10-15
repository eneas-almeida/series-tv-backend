package br.com.ifpb.series.modules.user.use_cases.create_user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ifpb.series.modules.user.dtos.CreateUserDTO;
import br.com.ifpb.series.modules.user.dtos.UserDTO;
import br.com.ifpb.series.modules.user.entities.Profile;
import br.com.ifpb.series.modules.user.entities.User;
import br.com.ifpb.series.modules.user.exceptions.UserAlreadyExistsException;
import br.com.ifpb.series.modules.user.mappers.UserMapper;
import br.com.ifpb.series.modules.user.repositories.UserRepository;
import br.com.ifpb.series.modules.user.utils.UserMessageUtils;

@Service
public class CreateUserService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder bcrypt;

    @Transactional
    public UserDTO execute(CreateUserDTO dto) {

        /* Verify user existence with email */

        Boolean existsUser = userRepository.existsByEmail(dto.getEmail());

        if (existsUser) {
            throw new UserAlreadyExistsException(UserMessageUtils.USER_ALREADY_EXISTS);
        }

        /* Parse dto to entity */
        
        User user = userMapper.toEntity(dto);

        /* Set roler user */

        user.setProfile(Profile.ROLE_USUARIO);
        
        /* Generate password hash */
        
        user.setPassword(bcrypt.encode(dto.getPassword()));
        
        /* Save user in repository */
        
        userRepository.save(user);

        /* Parse entity to dto and return */

        return userMapper.toDTO(user);
    }
}