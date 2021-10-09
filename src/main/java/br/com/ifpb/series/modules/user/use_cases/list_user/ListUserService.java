package br.com.ifpb.series.modules.user.use_cases.list_user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.ifpb.series.modules.user.dtos.ListUserDTO;
import br.com.ifpb.series.modules.user.entities.User;
import br.com.ifpb.series.modules.user.exceptions.UserNotFoundException;
import br.com.ifpb.series.modules.user.mappers.UserMapper;
import br.com.ifpb.series.modules.user.repositories.UserRepository;
import br.com.ifpb.series.modules.user.utils.UserMessageUtils;

@Service
public class ListUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;
    
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Page<ListUserDTO> execute(Integer page, Integer linesPerPage, String orderBy, String direction) {

        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

        Page<User> users = userRepository.findAll(pageRequest);

        if (users.isEmpty()) {
            throw new UserNotFoundException(UserMessageUtils.USER_NOT_FOUND);
        }

        Page<ListUserDTO> pageUserDTO = userMapper.toCollectionPageModel(users);

        return pageUserDTO;
    }
}