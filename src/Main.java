import java.util.Scanner;

/**
 * Created by Raphael on 7/03/2017.
 */
public class Main {
    public static void main(String[] args) {
        ExpHashMap<String, Integer> expMap = new ExpHashMap<>();
        expMap.put("apple", 1, 5000);
        expMap.start();
        Scanner sc = new Scanner(System.in);
        System.out.println("+==================+");
        System.out.println("| Expiring HashMap |");
        System.out.println("+==================+=================================================================+");
        System.out.println("| Commands: 'put <key> <val> <dur>'   -> inserts <val> at <key> with duration <dur>  |");
        System.out.println("|           'get <key>'               -> retrieves the val at <key>                  |");
        System.out.println("|           'print'                   -> prints entire map                           |");
        System.out.println("+====================================================================================+");
        while (true) {
            System.out.print("> ");
            String command = sc.nextLine();
            String[] commandParts = command.split(" ");
            String key;
            int val;
            long dur;
            switch (commandParts[0]) {
                case "put":
                    if (commandParts.length != 4) {
                        System.out.println("Err: Wrong number of arguments");
                        continue;
                    }
                    key = commandParts[1];
                    val = Integer.parseInt(commandParts[2]);
                    dur = Long.parseLong(commandParts[3]);
                    System.out.println("> Inserting '" + val + "' into '" + key + "' for <" + dur + "> milliseconds");
                    expMap.put(key, val, dur);
                    break;
                case "get":
                    if (commandParts.length != 2) {
                        System.out.println("Err: Incorrect number of arguments");
                        continue;
                    }
                    key = commandParts[1];
                    try {
                        val = expMap.get(key);
                        System.out.println("> '" + key + "' --> '" + val + "'");
                    } catch (NullPointerException e) {
                        System.out.println("Err: No entry for '" + key + "'");
                    }
                    break;
                case "print":
                    expMap.print();
                    break;
                default:
                    System.out.println("Err: Unrecognised command");
            }

        }
    }
}
