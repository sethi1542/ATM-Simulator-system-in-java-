package statement;

import java.io.FileWriter;
import java.time.LocalDateTime;

public class MiniStatement {

    private static final String FILE = "transactions.txt";

    public static void log(String accNo, String type, double amount) {
        try (FileWriter fw = new FileWriter(FILE, true)) {
            fw.write(accNo + " | " + type + " | " + amount + " | "
                    + LocalDateTime.now() + "\n");
        } catch (Exception ignored) {}
    }
}
