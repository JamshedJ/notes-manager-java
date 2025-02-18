package cmd;

import java.util.ArrayList;
import java.util.Scanner;

public class NoteApp {
    private static final ArrayList<Note> notes = new ArrayList<>();
    private static int nextId = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nConsole Notes manager");
            System.out.println("1. Create a note");
            System.out.println("2. List all notes");
            System.out.println("3. Get a note by ID");
            System.out.println("4. Update note");
            System.out.println("5. Delete note");
            System.out.println("6. Exit");
            System.out.print("\nEnter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> createNote();
                case 2 -> getNotes();
                case 3 -> getNoteById();
                case 4 -> updateNote();
                case 5 -> deleteNote();
                case 6 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void createNote() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the title of the note: ");
        String title = scanner.nextLine();

        System.out.print("Enter the content of the note: ");
        String content = scanner.nextLine();

        notes.add(new Note(nextId, title, content));
        nextId++;
    }

    private static void getNotes() {
        System.out.println("\nAll notes:");

        if (notes.isEmpty()) {
            System.out.println("You have no notes.");
            return;
        }

        for (Note note: notes) {
            System.out.println(note);
        }
    }

    private static void getNoteById() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the ID of the note: ");
        int id = scanner.nextInt();

        for (Note note: notes) {
            if (note.getId() == id) {
                System.out.println(note);
                return;
            }
        }

        System.out.println("Note not found.");
    }

    private static void updateNote() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the ID of the note: ");
        int id = scanner.nextInt();

        for (Note note: notes) {
            if (note.getId() == id) {
                System.out.print("Enter the new title of the note: ");
                String title = scanner.nextLine();

                System.out.print("Enter the new content of the note: ");
                String content = scanner.nextLine();

                note.setTitle(title);
                note.setContent(content);

                System.out.println("Note updated.");
                return;
            }
        }

        System.out.println("Note not found.");
    }

    private static void deleteNote() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the ID of the note: ");
        int id = scanner.nextInt();

        for (Note note: notes) {
            if (note.getId() == id) {
                notes.remove(note);
                System.out.println("Note deleted.");
                return;
            }
        }

        System.out.println("Note not found.");
    }
}
