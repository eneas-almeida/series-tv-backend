package br.com.ifpb.series.modules.user.use_cases.delete_user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ifpb.series.modules.user.dtos.UserDTO;
import br.com.ifpb.series.modules.user.entities.User;
import br.com.ifpb.series.modules.user.exceptions.UserNotFoundException;
import br.com.ifpb.series.modules.user.mappers.UserMapper;
import br.com.ifpb.series.modules.user.repositories.UserRepository;
import br.com.ifpb.series.modules.user.utils.UserMessageUtils;

@Service
public class DeleteUserService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Transactional
    public UserDTO execute(Long id) {
        
        Optional<User> optionalEntity = userRepository.findById(id);

        if (!optionalEntity.isPresent()) {
            throw new UserNotFoundException(UserMessageUtils.USER_NOT_FOUND);
        }

        User user = optionalEntity.get();

        /* Delete user in repository */

        userRepository.deleteById(id);

        /* End update data */

        return userMapper.toDTO(user);
    }
}