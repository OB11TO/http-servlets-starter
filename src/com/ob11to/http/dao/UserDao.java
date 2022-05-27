package com.ob11to.http.dao;

import com.ob11to.http.entity.User;
import com.ob11to.http.util.ConnectionManager;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.util.List;
import java.util.Optional;

import static java.sql.Statement.RETURN_GENERATED_KEYS;
import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class UserDao implements Dao<Integer, User> {

    private static final UserDao USER_DAO_INSTANCE = new UserDao();

    private static final String SAVE_SQL = """
            INSERT INTO flight_repository.task26.users
            (name, image, birthday, email, password, role, gender) VALUES (?, ?, ?, ?, ?, ?, ?)
            """;

    public static UserDao getInstance() {
        return USER_DAO_INSTANCE;
    }


    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public void update(User entity) {

    }

    @Override
    @SneakyThrows
    public User save(User entity) {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(SAVE_SQL, RETURN_GENERATED_KEYS)) {
            preparedStatement.setObject(1, entity.getName());
            preparedStatement.setObject(2, entity.getImage());
            preparedStatement.setObject(3, entity.getBirthday());
            preparedStatement.setObject(4, entity.getEmail());
            preparedStatement.setObject(5, entity.getPassword());
            preparedStatement.setObject(6, entity.getRole().name());
            preparedStatement.setObject(7, entity.getGender().name());

            preparedStatement.executeQuery();

            var generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            entity.setId(generatedKeys.getObject("id", Integer.class));
        }
        return entity;
    }
}
