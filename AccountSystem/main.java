package AccountSystem;

import java.io.File;
import java.io.IOException;

public class main {
    
    public static void main(String[] args) {
        System.out.println("Welcome to The Account System!");
        AccountBook ab = new AccountBook();
        ab.addAccount("abc", "123");
        ab.addAccount("def", "456");
    }
}
