package vn.nhandev.laptopshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.nhandev.laptopshop.domain.User;
import vn.nhandev.laptopshop.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public String handHello() {
        return "Hello from service";
    }

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public List<User> getAllUsersbyEmail(String email) {
        return this.userRepository.findOneByEmail(email);
    }

    public User handleSaveUser(User user) {
        User eric = this.userRepository.save(user);
        System.out.println(eric);
        return eric;

    }
}
