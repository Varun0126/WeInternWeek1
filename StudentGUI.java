import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class StudentGUI extends JFrame {

    private List<Student> students = new ArrayList<>();

    private JTextField idField, nameField, ageField, courseField;
    private DefaultTableModel model;
    private JTable table;

    public StudentGUI() {
        setTitle("Student Management System");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        // ---------- Input Panel ----------
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));

        panel.add(new JLabel("ID"));
        idField = new JTextField();
        panel.add(idField);

        panel.add(new JLabel("Name"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Age"));
        ageField = new JTextField();
        panel.add(ageField);

        panel.add(new JLabel("Course"));
        courseField = new JTextField();
        panel.add(courseField);

        JButton addBtn = new JButton("Add");
        JButton updateBtn = new JButton("Update");
        JButton deleteBtn = new JButton("Delete");

        panel.add(addBtn);
        panel.add(updateBtn);

        add(panel, BorderLayout.NORTH);

        // ---------- Table ----------
        model = new DefaultTableModel(new String[]{"ID", "Name", "Age", "Course"}, 0);
        table = new JTable(model);

        add(new JScrollPane(table), BorderLayout.CENTER);

        add(deleteBtn, BorderLayout.SOUTH);

        // ---------- Actions ----------

        addBtn.addActionListener(e -> addStudent());
        updateBtn.addActionListener(e -> updateStudent());
        deleteBtn.addActionListener(e -> deleteStudent());

        table.getSelectionModel().addListSelectionListener(e -> fillFields());

        setVisible(true);
    }

    // ===================== FUNCTIONS =====================

    private void addStudent() {
        int id = Integer.parseInt(idField.getText());
        String name = nameField.getText();
        int age = Integer.parseInt(ageField.getText());
        String course = courseField.getText();

        Student s = new Student(id, name, age, course);
        students.add(s);

        model.addRow(new Object[]{id, name, age, course});
        clearFields();
    }

    private void updateStudent() {
        int row = table.getSelectedRow();
        if (row == -1) return;

        int id = Integer.parseInt(idField.getText());
        String name = nameField.getText();
        int age = Integer.parseInt(ageField.getText());
        String course = courseField.getText();

        students.set(row, new Student(id, name, age, course));

        model.setValueAt(id, row, 0);
        model.setValueAt(name, row, 1);
        model.setValueAt(age, row, 2);
        model.setValueAt(course, row, 3);

        clearFields();
    }

    private void deleteStudent() {
        int row = table.getSelectedRow();
        if (row == -1) return;

        students.remove(row);
        model.removeRow(row);

        clearFields();
    }

    private void fillFields() {
        int row = table.getSelectedRow();
        if (row == -1) return;

        idField.setText(model.getValueAt(row, 0).toString());
        nameField.setText(model.getValueAt(row, 1).toString());
        ageField.setText(model.getValueAt(row, 2).toString());
        courseField.setText(model.getValueAt(row, 3).toString());
    }

    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        ageField.setText("");
        courseField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StudentGUI::new);
    }
}
