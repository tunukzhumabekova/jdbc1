package peaksoft;

import peaksoft.service.UserService;
import peaksoft.service.UserServiceImpl;
import peaksoft.util.Util;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Util.getConnection();
        UserService userServiceImpl = new UserServiceImpl();
        while (true) {
            int a = scanner.nextInt();
            switch (a) {
                case 1:
                    userServiceImpl.createUsersTable();
                    break;
                case 2:
                    userServiceImpl.saveUser("Tunuk", "Zhumabekova", (byte) 16);
                    break;
                case 3:
                    userServiceImpl.dropUsersTable();
                    break;
                case 4:
                    System.out.println(userServiceImpl.getAllUsers());

                    break;
                case 5:
                    userServiceImpl.removeUserById(1);
                    break;
                case 6:
                    userServiceImpl.cleanUsersTable();
                    break;
            }
        }
    }
}
