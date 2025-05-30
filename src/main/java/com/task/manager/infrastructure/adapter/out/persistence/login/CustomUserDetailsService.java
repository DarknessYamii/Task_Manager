package com.task.manager.infrastructure.adapter.out.persistence.login;


import com.task.manager.domain.model.UserDTO;
import com.task.manager.infrastructure.adapter.out.persistence.user.UserEntity;
import com.task.manager.infrastructure.adapter.out.persistence.user.UserJpaRepository;
import com.task.manager.infrastructure.adapter.out.persistence.user.UserMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserJpaRepository userJpaRepository;
    private final UserMapper userMapper;

    public CustomUserDetailsService(UserJpaRepository userJpaRepository, UserMapper userMapper) {
        this.userJpaRepository = userJpaRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userJpaRepository.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        UserDTO userDTO = userMapper.entityToDto(user);
        return new CustomUserDetails(userDTO);
    }
}
