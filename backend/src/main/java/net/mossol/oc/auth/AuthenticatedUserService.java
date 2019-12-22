package net.mossol.oc.auth;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import net.mossol.oc.model.User;
import net.mossol.oc.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AuthenticatedUserService implements UserDetailsService {

    @Resource
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User user = userRepository.findByUserId(username).orElseThrow(
                () -> new UsernameNotFoundException("Can't find user; userId :" + username)
        );
        return UserPrincipal.create(user);
    }

    @Transactional
    public UserDetails loadUserById(Long id) {
        final User user = userRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("Can't find user; id :" + id)
        );

        return UserPrincipal.create(user);
    }
}
