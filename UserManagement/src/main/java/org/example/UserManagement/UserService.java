package org.example.UserManagement;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserTable CreateUser(UserTable user) {
        return userRepository.save(user);
    }

    public UserTable getUserById(int id){
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
    }
    public List<UserTable> GetAllUsers(){
        return userRepository.findAll();
    }
    public void delete(int id) {
        var user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        userRepository.delete(user);

    }

    public UserTable update(UserTable updater, int id) {
        var user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        user.setFirstName(updater.getFirstName());
        user.setLastName(updater.getLastName());
        user.setEmail(updater.getEmail());
        return userRepository.save(user);


    }

}
