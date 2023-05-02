package AccountSystem;

import java.util.HashMap;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AccountBook {

    final String FILENAME = "accounts.txt";
    HashMap<String, String> book = new HashMap<String, String>();

    // Constructors
    public AccountBook() {
        this.book = new HashMap<String, String>();
    }

    public AccountBook(HashMap<String, String> book) {
        this.book = book;
    }

    /*
     * Writes an account to the file
     * Returns true if successful, false if not
     */
    public boolean writeAccountToFile(String username) {
        if(book.containsKey(username)) {
            try {
                FileWriter fw = new FileWriter(FILENAME, true);
                fw.write(username + "//" + book.get(username) + "\n");
                fw.close();
            }
            catch (IOException e) {
                e.printStackTrace();
                return false;
            }
            return true;
        }
        return false;
    }

    /*
     * Updates the file with the new AccountBook
     */
    public void updateAccountFile() {
        // Clear the contents of the file
        try {
            new FileWriter(FILENAME, false).close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        // Rewrite the new contents
        for(HashMap.Entry<String, String> entry : book.entrySet()) {
            writeAccountToFile(entry.getKey());
        }
    }

    /*
     * Updates the HashMap with the accounts from the file
     * Returns true if successful, false if not
     */
    public boolean updateAccountBook() {
        try {
            File file = new File(FILENAME);
            Scanner fr = new Scanner(file);
            while(fr.hasNextLine()) {
                String account = fr.nextLine();
                String[] details = account.split("//");
                addAccount(details[0], details[1]);
            }
            fr.close();
            return true;
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    /*
     * Adds an account to the HashTable
     */
    public void addAccount(String email, String password) {
        if(book.containsKey(email)) {
            book.replace(email, password);
        }
        else {
            book.put(email, password);
        }
        updateAccountFile();
    }
}