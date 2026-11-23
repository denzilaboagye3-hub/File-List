
import javax.swing.*;
import java.awt.*;

public class SortedListGUI extends JFrame {

    private final SortedList sortedList;
    private final JTextField inputField;
    private final JTextArea outputArea;

    public SortedListGUI() {
        sortedList = new SortedList();

        setTitle("Sorted Array List - Binary Search");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Input area
        JPanel inputPanel = new JPanel(new BorderLayout(10, 10));
        inputPanel.setBorder(
                BorderFactory.createEmptyBorder(10, 10, 0, 10)
        );

        inputField = new JTextField();
        inputPanel.add(new JLabel("Enter a string:"), BorderLayout.WEST);
        inputPanel.add(inputField, BorderLayout.CENTER);

        add(inputPanel, BorderLayout.NORTH);

        // Output area
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 14));

        JScrollPane scrollPane = new JScrollPane(outputArea);
        add(scrollPane, BorderLayout.CENTER);

        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton addButton = new JButton("Add String");
        JButton searchButton = new JButton("Search String");
        JButton displayButton = new JButton("Display List");
        JButton clearButton = new JButton("Clear Output");
        JButton quitButton = new JButton("Quit");

        buttonPanel.add(addButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(displayButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(quitButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Add a string
        addButton.addActionListener(e -> {
            String input = inputField.getText().trim();

            if (input.isEmpty()) {
                JOptionPane.showMessageDialog(
                        this, "Please enter a string."
                );
                return;
            }

            sortedList.add(input);

            outputArea.append("Added: " + input + "\n");
            outputArea.append("Current sorted list:\n");
            outputArea.append(sortedList.displayList() + "\n");

            inputField.setText("");
        });

        // Search for a string
        searchButton.addActionListener(e -> {
            String input = inputField.getText().trim();

            if (input.isEmpty()) {
                JOptionPane.showMessageDialog(
                        this, "Please enter a search string."
                );
                return;
            }

            int result = sortedList.binarySearch(input);

            if (result >= 0) {
                outputArea.append(
                        "FOUND: " + input +
                                " at index " + result + "\n\n"
                );
            } else {
                int insertionPoint = -(result + 1);

                outputArea.append(
                        "NOT FOUND: " + input + "\n" +
                                "Insertion position: " +
                                insertionPoint + "\n\n"
                );
            }
        });

        // Display sorted list
        displayButton.addActionListener(e -> {
            outputArea.append("Sorted List:\n");
            outputArea.append(sortedList.displayList() + "\n");
        });

        // Clear only the output, not the list
        clearButton.addActionListener(e ->
                outputArea.setText("")
        );

        // Quit application
        quitButton.addActionListener(e -> dispose());

        setVisible(true);
    }
}
