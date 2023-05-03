package AccountSystem;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class main {
    
    public static void main(String[] args) {
        System.out.println("Welcome to The Account System!");
        AccountBook ab = new AccountBook();
        ab.updateAccountBook();
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while(true) {
            System.out.println("Please enter your email address to login.");
            System.out.println("If you do not have an account, type \"create\" to make a new account.");
            System.out.print("> ");
            input = scanner.nextLine();
            if(input.equalsIgnoreCase("create")) {
                String email = "";
                String password = "";

                // Loop: Creating An Account
                while(true) {
                    System.out.println("Please enter the email address you would like to create an account with.");
                    System.out.print("> ");
                    email = scanner.nextLine();
                    System.out.println("Please enter the password you would like to use for the account.");
                    System.out.print("> ");
                    password = scanner.nextLine();
                    break;
                }
                ab.addAccount(email, password);
                System.out.println("Congratulations! Your account has been successfully created!");
            }
            else if(ab.isAccountReal(input)) {
                while(true) {
                    System.out.println("Please enter the password for " + input);
                    System.out.print("> ");
                    String password = scanner.nextLine();
                    if(ab.isPasswordCorrect(input, password)) {
                        break;
                    }
                    System.out.println("Sorry, that password was incorrect. Please try again.");
                }
                System.out.println("You have successfully logged into the account associated with " + input);
            }
        }
    }
}
