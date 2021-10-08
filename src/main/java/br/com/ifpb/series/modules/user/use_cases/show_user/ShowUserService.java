package br.com.ifpb.series.modules.user.use_cases.show_user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.ifpb.series.modules.user.dtos.UserDTO;
import br.com.ifpb.series.modules.user.entities.User;
import br.com.ifpb.series.modules.user.exceptions.UserNotFoundException;
import br.com.ifpb.series.modules.user.mappers.UserMapper;
import br.com.ifpb.series.modules.user.repositories.UserRepository;
import br.com.ifpb.series.modules.user.utils.UserMessageUtils;

@Service
public class ShowUserService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public UserDTO execute(Long id) {
        Optional<User> optionalEntity = userRepository.findById(id);

        if (!optionalEntity.isPresent()) {
            throw new UserNotFoundException(UserMessageUtils.USER_NOT_FOUND);
        }

        return userMapper.toDTO(optionalEntity.get());
    }
}