package peaksoft.dao;

import peaksoft.model.User;
import peaksoft.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserDaoJdbcImpl implements UserDao {

    public UserDaoJdbcImpl() {
    }

    @Override
    public void createUsersTable() {
        String sql= "create table if not exists users(" +
                "                     id serial primary key, "+
                "                    name varchar(50)," +
                "                    lastName varchar, " +
                "                    age int)";
        try (
                Connection connection = Util.getConnection();

                Statement statement = connection.createStatement();){
            statement.executeUpdate(sql);
            System.out.println("Table successfully created");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void dropUsersTable() {
        String sql="drop table users ";
        try(Connection connection=Util.getConnection();
            Statement statement=connection.createStatement();){
            statement.executeUpdate(sql);
            System.out.println("table was dropped");
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String sql = "INSERT INTO users (name, lastName, age) VALUES (?, ?, ?)";
        try (Connection connection = Util.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public void removeUserById(long id) {
String sql="delete from users where id="+id;
try(Connection connection=Util.getConnection();
Statement statement=connection.createStatement();){
    statement.executeUpdate(sql);
    System.out.println("user with id "+id+" was deleted");
}catch (SQLException e) {
    System.out.println(e.getMessage());
}
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "select * from users";
        try (Connection connection = Util.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                users.add(new User(

                        resultSet.getString("name"),
                                resultSet.getString("lastName"),
                                resultSet.getByte("age")
                        )
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }


    public void cleanUsersTable() {
        String sql="truncate table  users ";
        try(Connection connection=Util.getConnection();
            Statement statement=connection.createStatement();){
            statement.executeUpdate(sql);
            System.out.println("table was cleaned");
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}