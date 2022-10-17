package controller;

import model.User;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        User user1 = new User(); //set user1 có sẵn//
        user1.setUsername("hung");
        user1.setPassword("Hung1234");
        user1.setEmail("tuanhung1401@gmail.com");
        User user2 = new User(); //set user 2 có sẵn//
        user2.setUsername("hoang");
        user2.setPassword("Hoang1234");
        user2.setEmail("huyhoang2502@gmail.com");
        ArrayList<User> users = new ArrayList<>(); //tạo arraylist để chứa các user//
        users.add(user1); //thêm user 1 vào arraylist//
        users.add(user2); //thêm user 2 vào arraylist//
        while (true) { //tạo loop để lặp lại bước đăng nhập hoặc đăng ký//
            System.out.println("Mời bạn lựa chọn: ");
            System.out.println("1.Đăng nhập");
            System.out.println("2.Đăng ký");
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            sc.nextLine();
            boolean match = false;
            loop1:
            while (true) { //tạo loop để lặp lại nhập username//
                if (option == 1) { //Đăng nhập//
                    User user = null;
                    loop2:
                    while (true) { // check xem username nhập vào có nằm trong danh sách username có sẵn hay không//
                        System.out.println("Mời bạn nhập username: ");
                        String username = sc.nextLine();
                        for (int i = 0; i < users.size(); i++) {
                            if (username.equals(users.get(i).getUsername())) {
                                user = users.get(i);
                                match = true;
                            }
                        }
                        if (match) { //có trùng khớp//
                            System.out.println("Mời bạn nhập password: ");
                            break loop2;
                        } else { // không trùng khớp //
                            System.out.println("Kiểm tra lại username: ");
                        }
                    }
                    String password = sc.nextLine();
                    if (!password.equals(user.getPassword())) { //nhập mật khẩu sai//
                        System.out.println("Mật khẩu không đúng. Mời bạn chọn: ");
                        System.out.println("1.Đăng nhập lại");
                        System.out.println("2.Quên mật khẩu");
                        int option2 = sc.nextInt();
                        sc.nextLine();
                        if (option2 == 1) { //để chạy lại vòng loop nhập username//
                            option = 1;
                        } else { //đã nhập mật khẩu đúng//
                            System.out.println("Xin mời nhập email của bạn: ");
                            String email = sc.nextLine();
                            if (!email.equals(user.getEmail())) { //để check xem email có tồn tại hay chưa//
                                System.out.println("Tài khoản không tồn tại");
                            } else {
                                System.out.println("Mời bạn nhập mật khẩu mới: ");
                                String newPassword = sc.nextLine();
                                while (newPassword.length() < 7 || newPassword.length() > 15) { //để check xem mật khẩu có đúng với yêu cầu hay không//
                                    System.out.println("Mật khẩu không hợp lệ, mật khẩu phải có độ dài từ 7 đến 15 ký tự. Xin vui lòng đặt lại: ");
                                    newPassword = sc.nextLine();
                                }
                                System.out.println("Thay đổi mật khẩu thành công! Mời bạn đăng nhập lại");
                                user.setPassword(newPassword); //set mật khẩu mới thay cho mật khẩu cũ//
                            }
                        }
                    } else { //đăng nhập thành công//
                        System.out.println("Chào mừng " + user.getUsername() + ", ban có thể thực hiện các công việc sau: ");
                        System.out.println("1 - Thay đổi username");
                        System.out.println("2 - Thay đổi email");
                        System.out.println("3 - Thay đổi mật khẩu");
                        System.out.println("4 - Đăng xuất (Sau khi đăng xuất quay về mục yêu cầu đăng nhập hoặc đăng ký");
                        System.out.println("0 - Thoát chương trình");
                        int userOption = sc.nextInt();
                        sc.nextLine();
                        switch (userOption) { //lựa chọn sau khi đăng nhập thành công//
                            case 1:
                                while (true) { //tạo loop để lặp lại việc nhập username mới khi nhập username trùng//
                                    boolean match2 = false;
                                    System.out.println("Mời bạn nhập username mới: ");
                                    String newUsername = sc.nextLine();
                                    for (int i = 0; i < users.size(); i++) {
                                        if (newUsername.equals(users.get(i).getUsername())) {
                                            user = users.get(i);
                                            match2 = true;
                                        }
                                    }
                                    if (match2) {
                                        System.out.println("Username đã tồn tại, vui lòng đặt username khác");
                                    } else {
                                        System.out.println("Thay đổi username thành công");
                                        user.setUsername(newUsername);
                                        break; //break loop while ở dòng 86//
                                    }
                                }
                                break;
                            case 2:
                                while (true) {
                                    boolean match2 = false; //tạo loop để lặp lại việc nhập email mới khi nhập email trùng//
                                    System.out.println("Mời bạn nhập email mới: ");
                                    String newEmail = sc.nextLine();
                                    for (int i = 0; i < users.size(); i++) {
                                        if (newEmail.equals(users.get(i).getEmail())) {
                                            user = users.get(i);
                                            match2 = true;
                                        }
                                    }
                                    if (match2) {
                                        System.out.println("Email đã tồn tại, vui lòng đặt email khác");
                                    } else {
                                        System.out.println("Thay đổi email thành công");
                                        user.setEmail(newEmail);
                                        break; //break loop while ở dòng 106//
                                    }
                                }
                                break;
                            case 3:
                                System.out.println("Mời bạn nhập mật khẩu mới: ");
                                String newPassword = sc.nextLine();
                                System.out.println("Thay đổi mật khẩu thành công!!!");
                                user.setPassword(newPassword);
                                break;
                            case 4:
                                break loop1;
                            case 0:
                                System.exit(0);
                        }
                    }
                } else if (option == 2) {//Đăng ký//
                    String username;
                    while (true) { // đặt loop để lặp lại vòng nhập username khi người dùng nhập vào username đã tồn tại //
                        System.out.println("Mời bạn nhập username: ");
                        username = sc.nextLine();
                        boolean match3 = false;
                        for (int i = 0; i < users.size(); i++) {
                            if (username.equals(users.get(i).getUsername())) {
                                match3 = true;
                            }
                        }
                        if (match3) {
                            System.out.println("Username đã tồn tại, vui lòng đặt username khác");
                            continue; //để break vòng while ở 139 nhưng vẫn tiếp tục thực hiện các bước dưới//
                        }
                        System.out.println("Mời bạn nhập email: ");
                        String email = sc.nextLine();
                        System.out.println("Mời bạn nhập password: ");
                        String password = sc.nextLine();
                        while (password.length() < 7 || password.length() > 15) { //đặt điều kiện cho password//
                            System.out.println("Mật khẩu không hợp lệ, mật khẩu phải có độ dài từ 7 đến 15 ký tự. Xin vui lòng đặt lại: ");
                            password = sc.nextLine();
                        }
                        System.out.println("Đăng ký thành công!!! Xin mời đăng nhập lại");
                        User newUser = new User();
                        newUser.setUsername(username);
                        newUser.setEmail(email);
                        newUser.setPassword(password);
                        users.add(newUser); //thêm các info mới nhập của user vào arraylist users//
                        option = 1;
                        break;
                    }
                }
            }

        }
    }
}