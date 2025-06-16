package org.example.UserManagement;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
@Tag(name = "User controller", description = "This is a user management routes")


public class userController {

    @Autowired
    private UserService userService;

    @PostMapping
    @Operation(
            summary = "this endpoint is used to create new user"
    )
    public UserTable createUser(@RequestBody UserCreationDTO dto) {
        UserTable users = new UserTable();
        users.setFirstName(dto.getFirstName());
        users.setLastName(dto.getLastName());
        users.setEmail(dto.getEmail());

        return userService.CreateUser(users);
    }

    @GetMapping
    @Operation(
            summary = "this endpoint is used to retrieve all data from table"
    )
    public List<UserTable> getAllUsers() {
        return userService.GetAllUsers();
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "this endpoint is used to get user by its id"
    )
    public UserTable getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "this endpoint is used to update user"
    )
    public UserTable updateUser(@PathVariable int id, @RequestBody UserCreationDTO user){
        UserTable users = new UserTable();
        users.setFirstName(user.getFirstName());
        users.setLastName(user.getLastName());
        users.setEmail(user.getEmail());
        return userService.update(users, id);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "this endpoint is used to delete/remove user"
    )
    public void deleteUser(@PathVariable int id) {
        userService.delete(id);
    }


}
