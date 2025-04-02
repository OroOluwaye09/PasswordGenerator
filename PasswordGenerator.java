/*
To compile and run your Java code in VS Code using javac, follow these steps:

1. **Install Java Development Kit (JDK)**
   - Make sure you have the Java Development Kit (JDK) installed. You can download it from Oracle's website or use OpenJDK.
   - After installation, ensure `javac` is available in your terminal by checking the version:
     ```bash
     javac -version
     ```
     If you see a version number (e.g., `javac 11.0.10`), then Java is properly installed.

2. **Install VS Code and the Java Extension Pack**
   - Install VS Code from the official website: https://code.visualstudio.com/
   - Install the **Java Extension Pack** in VS Code, which includes essential tools like **Language Support for Java** and **Debugger for Java**.
     To install, open VS Code, go to the Extensions view (`Ctrl+Shift+X`), and search for **Java Extension Pack**. Click **Install**.

3. **Create and Save Your Java File**
   - Open VS Code.
   - Create a new file in your desired folder, and save it with a `.java` extension, for example, `PasswordGenerator.java`.
   - Paste the code you provided into the file.

4. **Open Integrated Terminal in VS Code**
   - Open the terminal in VS Code by going to **Terminal** > **New Terminal** or using the shortcut `Ctrl+`` (backtick).
   - This opens the terminal at the root of your workspace or folder.

5. **Compile the Java Program**
   - In the terminal, navigate to the folder where your `.java` file is saved. If you're already in the folder with the file, you can run the following command to compile the Java file:
     ```bash
     javac PasswordGenerator.java
     ```
     If the compilation is successful, it will generate a `PasswordGenerator.class` file in the same directory.

6. **Run the Java Program**
   - After compiling, you can run the program using the `java` command:
     ```bash
     java PasswordGenerator
     ```
     This will execute the program and print the generated password to the terminal.

7. **Optional: Using VS Code's Run Feature**
   - VS Code provides a convenient way to run Java programs using the **Run** button if you have the Java extensions installed. You can simply:
     1. Open the Java file in VS Code.
     2. Click the **Run** button (green play button) at the top-right of the editor or use the shortcut `Ctrl+F5`.
     - VS Code will compile and run the Java file without needing to use the terminal.

*/

import java.security.SecureRandom;

public class PasswordGenerator {

    public static void main(String[] args) {
        int length = 12; // Can be set between 8 and 64
        System.out.println(generatePassword(length));
    }

    public static String generatePassword(int length) {
        if (length < 8 || length > 64) {
            throw new IllegalArgumentException("Password length must be between 8 and 64 characters.");
        }

        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String specials = "!@#$%^&*()-_=+<>?";
        
        String allCharacters = upper + lower + digits + specials;
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        // Ensure the password contains at least one character from each category
        password.append(upper.charAt(random.nextInt(upper.length())));
        password.append(lower.charAt(random.nextInt(lower.length())));
        password.append(digits.charAt(random.nextInt(digits.length())));
        password.append(specials.charAt(random.nextInt(specials.length())));

        // Fill the rest with random characters from all categories
        for (int i = 4; i < length; i++) {
            password.append(allCharacters.charAt(random.nextInt(allCharacters.length())));
        }

        // Shuffle to mix the characters randomly
        for (int i = 0; i < password.length(); i++) {
            int j = random.nextInt(password.length());
            char temp = password.charAt(i);
            password.setCharAt(i, password.charAt(j));
            password.setCharAt(j, temp);
        }

        return password.toString();
    }
}
