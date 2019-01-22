public class TodoPrint {
    public static void main(String[] args) {
        String todoText = " - Buy milk\n";
        // Add "My todo:" to the beginning of the todoText
        // Add " - Download games" to the end of the todoText
        // Add " - Diablo" to the end of the todoText but with indention

        // Expected outpt:

        // My todo:
        //  - Buy milk
        //  - Download games
        //      - Diablo

        String toDoTextAdd1 = " - Download games\n";
        String toDoTaxtAdd2 = "     - Diablo";

        todoText = todoText.concat(toDoTextAdd1).concat(toDoTaxtAdd2);

        System.out.println(todoText);
    }
}
