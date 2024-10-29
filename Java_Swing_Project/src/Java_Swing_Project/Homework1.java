package Java_Swing_Project;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Homework1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(700, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        
        JPanel panel1 = new JPanel();
        TitledBorder border1 = new TitledBorder("Customer Information");
        panel1.setBorder(border1);
        panel1.setBounds(10, 10, 660, 80);
        panel1.setLayout(null);  

        JLabel userLabel = new JLabel("Name:");
        userLabel.setBounds(20, 30, 80, 25);
        JTextField userText = new JTextField();
        userText.setBounds(100, 30, 165, 25);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(350, 30, 80, 25);
        JTextField phoneField = new JTextField();
        phoneField.setBounds(430, 30, 165, 25);
        
        JPanel panel2 = new JPanel();
        TitledBorder border2 = new TitledBorder("Meals");
        panel2.setBorder(border2);
        panel2.setBounds(10, 90, 300, 160);
        panel2.setLayout(null);

        JLabel mealLabel = new JLabel("Choose a meal:");
        mealLabel.setBounds(20, 20, 150, 25);
        String[] meals = {"Pasta - $12.00", "Pizza - $20.00", "Chicken - $16.00"};
        JComboBox<String> mealBox = new JComboBox<>(meals);
        mealBox.setBounds(20, 50, 200, 30);

        JLabel quantityLabel = new JLabel("Quantity:");
        quantityLabel.setBounds(20, 90, 150, 25);

        SpinnerNumberModel model = new SpinnerNumberModel(1, 1, 10, 1);
        JSpinner spinner = new JSpinner(model);
        spinner.setBounds(90, 90, 50, 30);

        JCheckBox option = new JCheckBox("Extra Cheese (+$2.00)");
        option.setBounds(20, 120, 200, 25);

        JPanel panel3 = new JPanel();
        TitledBorder border3 = new TitledBorder("Drinks");
        panel3.setBorder(border3);
        panel3.setBounds(10, 250, 300, 160);
        panel3.setLayout(null);

        JLabel drinkLabel = new JLabel("Choose a drink:");
        drinkLabel.setBounds(20, 20, 150, 25);

        JCheckBox option1 = new JCheckBox("Cola - $2.00");
        option1.setBounds(20, 50, 200, 25);
        JCheckBox option2 = new JCheckBox("Water - $1.00");
        option2.setBounds(20, 80, 200, 25);
        JCheckBox option3 = new JCheckBox("Add Ice (+$0.50)");
        option3.setBounds(20, 110, 200, 25);

        JPanel panel4 = new JPanel();
        TitledBorder border4 = new TitledBorder("Desserts");
        panel4.setBorder(border4);
        panel4.setBounds(10, 410, 300, 160);
        panel4.setLayout(null);

        JLabel dessertLabel = new JLabel("Choose a dessert:");
        dessertLabel.setBounds(20, 20, 150, 25);

        JRadioButton cakeButton = new JRadioButton("Cake - $4.00");
        cakeButton.setBounds(20, 50, 200, 25);
        JRadioButton iceCreamButton = new JRadioButton("Ice Cream - $3.00");
        iceCreamButton.setBounds(20, 80, 200, 25);
        JCheckBox toppings = new JCheckBox("Extra Toppings (+$1.00)");
        toppings.setBounds(20, 110, 200, 25);

        JPanel panel5 = new JPanel();
        TitledBorder border5 = new TitledBorder("Order Summary");
        panel5.setBorder(border5);
        panel5.setBounds(320, 90, 350, 480);
        panel5.setLayout(null);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(10, 20, 330, 450);

        JLabel totalLabel = new JLabel("Total: $0.00");
        totalLabel.setBounds(30, 590, 150, 40);

        JButton calculate = new JButton("Calculate Price");
        calculate.setBounds(330, 590, 150, 40);

        JButton reset = new JButton("Reset Order");
        reset.setBounds(500, 590, 150, 40);

        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = userText.getText();
                String phone = phoneField.getText();
                String meal = mealBox.getSelectedItem().toString();
                int quantity = (int) spinner.getValue();
                double total = 0;

                StringBuilder orderSummary = new StringBuilder();
                orderSummary.append("Customer: ").append(name).append("\n");
                orderSummary.append("Phone: ").append(phone).append("\n\n");

                if (meal.contains("Pasta")) total += 12 * quantity;
                else if (meal.contains("Pizza")) total += 20 * quantity;
                else total += 16 * quantity;

                orderSummary.append(meal).append(" x").append(quantity).append(" - $").append(12 * quantity).append("\n");

                if (option.isSelected()) {
                    total += 2 * quantity;
                    orderSummary.append(" + Extra Cheese x").append(quantity).append(" - $").append(2 * quantity).append("\n");
                }
                if (option1.isSelected()) {
                    total += 2;
                    orderSummary.append("Cola - $2.00\n");
                }
                if (option2.isSelected()) {
                    total += 1;
                    orderSummary.append("Water - $1.00\n");
                }
                if (option3.isSelected()) {
                    total += 0.5;
                    orderSummary.append(" + Ice - $0.50\n");
                }
                if (cakeButton.isSelected()) {
                    total += 4;
                    orderSummary.append("Cake - $4.00\n");
                } else if (iceCreamButton.isSelected()) {
                    total += 3;
                    orderSummary.append("Ice Cream - $3.00\n");
                }
                if (toppings.isSelected()) {
                    total += 1;
                    orderSummary.append(" + Extra Toppings - $1.00\n");
                }
                textArea.setText(orderSummary.toString());
                totalLabel.setText("Total: $" + total);
            }
        });
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userText.setText("");
                phoneField.setText("");
                mealBox.setSelectedIndex(0);
                spinner.setValue(1);
                option.setSelected(false);
                option1.setSelected(false);
                option2.setSelected(false);
                option3.setSelected(false);
                cakeButton.setSelected(false);
                iceCreamButton.setSelected(false);
                toppings.setSelected(false);
                textArea.setText("");
                totalLabel.setText("Total: $0.00");
            }
        });
        panel1.add(userLabel);
        panel1.add(userText);
        panel1.add(phoneLabel);
        panel1.add(phoneField);
        frame.add(panel1);
        panel2.add(mealLabel);
        panel2.add(mealBox);
        panel2.add(quantityLabel);
        panel2.add(spinner);
        panel2.add(option);
        frame.add(panel2);
        panel3.add(drinkLabel);
        panel3.add(option1);
        panel3.add(option2);
        panel3.add(option3);
        frame.add(panel3);
        panel4.add(dessertLabel);
        panel4.add(cakeButton);
        panel4.add(iceCreamButton);
        panel4.add(toppings);
        frame.add(panel4);   
        panel5.add(textArea);
        frame.add(panel5);
        frame.add(calculate);
        frame.add(reset);
        frame.add(totalLabel);
        frame.setVisible(true);
    }
}