package pl.sda.simplecrud;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements InitializingBean {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void afterPropertiesSet() throws Exception {
        if(userRepository.count()==0){
            User user = new User("adam", passwordEncoder.encode("adam5"), SecurityConfig.ROLE_USER);
            userRepository.save(user);
        }
    }
}
