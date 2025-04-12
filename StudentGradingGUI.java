package calculator_project;

//public class StudentGradingGUI {
//
//}
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentGradingGUI extends JFrame implements ActionListener {
    JLabel nameLabel, rollLabel, collegeLabel, subject1Label, subject2Label, subject3Label;
    JTextField nameField, rollField, collegeField, subject1Field, subject2Field, subject3Field;
    JButton calculateButton;
    JTextArea outputArea;

    public StudentGradingGUI() {
        setTitle("Student Grading System");
        setLayout(null);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        nameLabel = new JLabel("Student Name:");
        nameLabel.setBounds(50, 30, 120, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(180, 30, 200, 25);
        add(nameField);

        rollLabel = new JLabel("Roll Number:");
        rollLabel.setBounds(50, 70, 120, 25);
        add(rollLabel);

        rollField = new JTextField();
        rollField.setBounds(180, 70, 200, 25);
        add(rollField);

        collegeLabel = new JLabel("College Name:");
        collegeLabel.setBounds(50, 110, 120, 25);
        add(collegeLabel);

        collegeField = new JTextField();
        collegeField.setBounds(180, 110, 200, 25);
        add(collegeField);

        subject1Label = new JLabel("Subject 1 Marks:");
        subject1Label.setBounds(50, 150, 120, 25);
        add(subject1Label);

        subject1Field = new JTextField();
        subject1Field.setBounds(180, 150, 200, 25);
        add(subject1Field);

        subject2Label = new JLabel("Subject 2 Marks:");
        subject2Label.setBounds(50, 190, 120, 25);
        add(subject2Label);

        subject2Field = new JTextField();
        subject2Field.setBounds(180, 190, 200, 25);
        add(subject2Field);

        subject3Label = new JLabel("Subject 3 Marks:");
        subject3Label.setBounds(50, 230, 120, 25);
        add(subject3Label);

        subject3Field = new JTextField();
        subject3Field.setBounds(180, 230, 200, 25);
        add(subject3Field);

        calculateButton = new JButton("Calculate Result");
        calculateButton.setBounds(150, 280, 150, 30);
        calculateButton.addActionListener(this);
        add(calculateButton);

        outputArea = new JTextArea();
        outputArea.setBounds(50, 330, 450, 200);
        outputArea.setBackground(Color.BLACK);
        outputArea.setForeground(Color.WHITE);
        outputArea.setFont(new Font("Arial", Font.BOLD, 14));
        outputArea.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
        outputArea.setEditable(false);
        add(outputArea);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            String name = nameField.getText();
            int roll = Integer.parseInt(rollField.getText());
            String college = collegeField.getText();
            int mark1 = Integer.parseInt(subject1Field.getText());
            int mark2 = Integer.parseInt(subject2Field.getText());
            int mark3 = Integer.parseInt(subject3Field.getText());

            int total = mark1 + mark2 + mark3;
            double percentage = total / 3.0;
            String grade;

            if (percentage >= 90) grade = "A+";
            else if (percentage >= 80) grade = "A";
            else if (percentage >= 70) grade = "B";
            else if (percentage >= 60) grade = "C";
            else if (percentage >= 50) grade = "D";
            else grade = "F";

            outputArea.setText("=== Student Report ===\n");
            outputArea.append("Name         : " + name + "\n");
            outputArea.append("Roll Number  : " + roll + "\n");
            outputArea.append("College Name : " + college + "\n");
            outputArea.append("Subject 1    : " + mark1 + "\n");
            outputArea.append("Subject 2    : " + mark2 + "\n");
            outputArea.append("Subject 3    : " + mark3 + "\n");
            outputArea.append("Total Marks  : " + total + "\n");
            outputArea.append(String.format("Percentage   : %.2f%%\n", percentage));
            outputArea.append("Grade        : " + grade);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid input!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
