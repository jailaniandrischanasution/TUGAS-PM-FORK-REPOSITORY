import java.util.ArrayList;
import java.util.Scanner;

public class BrowserHistory {
    private ArrayList<String> history;

    public BrowserHistory() {
        history = new ArrayList<>();
    }

    public void view() {
        if (history.isEmpty()) {
            System.out.println("History kosong.");
        } else {
            System.out.println("History Browser (dari yang terbaru):");
            for (int i = history.size() - 1; i >= 0; i--) {
                System.out.println((i + 1) + ". " + history.get(i));
            }
        }
    }

    public void browse(String website) {
        history.add(website);
        System.out.println("Website " + website + " telah ditambahkan ke history.");
    }

    public void back() {
        if (history.isEmpty()) {
            System.out.println("Tidak ada website untuk kembali.");
        } else {
            String removedWebsite = history.remove(history.size() - 1);
            System.out.println("Kembali dari website " + removedWebsite + ".");
        }
    }

    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory();
        Scanner scanner = new Scanner(System.in);
        String command;

        while (true) {
            System.out.println("\nMasukkan perintah (view, browse <website>, back, exit):");
            command = scanner.nextLine();

            if (command.startsWith("browse ")) {
                String website = command.substring(7);
                browserHistory.browse(website);
            } else if (command.equals("view")) {
                browserHistory.view();
            } else if (command.equals("back")) {
                browserHistory.back();
            } else if (command.equals("exit")) {
                System.out.println("Keluar dari program.");
                break;
            } else {
                System.out.println("Perintah tidak dikenali. Silakan coba lagi.");
            }
        }

        scanner.close();
    }
}
