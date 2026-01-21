package POTD.GFG;
import java.util.*;

public class F_Implement_UNDO_REDO_20Jan2026 {


        // stores characters removed using undo
        private Stack<Character> stack = new Stack<>();

        // current text
        private StringBuilder text = new StringBuilder();

        public static void main(String[] args) {

            F_Implement_UNDO_REDO_20Jan2026 editor = new F_Implement_UNDO_REDO_20Jan2026();
            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("\n1. Append");
                System.out.println("2. Undo");
                System.out.println("3. Redo");
                System.out.println("4. Read");
                System.out.println("5. Exit");

                int choice = sc.nextInt();

                if (choice == 1) {
                    System.out.print("Enter character: ");
                    char ch = sc.next().charAt(0);
                    editor.append(ch);
                }
                else if (choice == 2) {
                    editor.undo();
                }
                else if (choice == 3) {
                    editor.redo();
                }
                else if (choice == 4) {
                    System.out.println("Text: " + editor.read());
                }
                else if (choice == 5) {
                    break;
                }
            }

            sc.close();
        }

        // add character to text
        // Time: O(1), Space: O(1)
        public void append(char x) {
            text.append(x);
        }

        // remove last character
        // Time: O(1), Space: O(1)
        public void undo() {
            if (text.length() > 0) {
                char c = text.charAt(text.length() - 1);
                text.deleteCharAt(text.length() - 1);
                stack.push(c);
            }
        }

        // add back last removed character
        // Time: O(1), Space: O(1)
        public void redo() {
            if (!stack.isEmpty()) {
                text.append(stack.pop());
            }
        }

        // return current text
        // Time: O(n), Space: O(n)
        public String read() {
            return text.toString();
        }
    }

