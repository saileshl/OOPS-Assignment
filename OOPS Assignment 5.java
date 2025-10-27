import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class ContactBookUI extends JFrame implements ActionListener {

    JTextField nameField, phoneField, emailField;
    JButton addButton;
    DefaultTableModel tableModel;
    JTable contactTable;

    public ContactBookUI() {
        // Frame setup
        setTitle("Contact Book UI");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Input panel
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Add New Contact"));

        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Phone:"));
        phoneField = new JTextField();
        inputPanel.add(phoneField);

        inputPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        inputPanel.add(emailField);

        addButton = new JButton("Add Contact");
        addButton.addActionListener(this);
        inputPanel.add(addButton);

        // Table setup
        String[] columns = {"Name", "Phone", "Email"};
        tableModel = new DefaultTableModel(columns, 0);
        contactTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(contactTable);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Contact List"));

        // Add components to frame
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String name = nameField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();

            if (name.isEmpty() || phone.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all fields!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                tableModel.addRow(new Object[]{name, phone, email});
                nameField.setText("");
                phoneField.setText("");
                emailField.setText("");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ContactBookUI::new);
    }
}
