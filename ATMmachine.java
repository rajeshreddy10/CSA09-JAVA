import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ATMmachine {
    private static double balance = 10000.0;  
    private static String pin = "";           
    private static String currentCardNumber = ""; 
    private static ArrayList<String> history = new ArrayList<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> showWelcomeScreen());
    }

    // Welcome Screen
    private static void showWelcomeScreen() {
        JFrame frame = new JFrame("Welcome");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(new Color(0, 102, 204));

        JLabel welcomeLabel = new JLabel("Welcome to ABCD Bank", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 32));
        welcomeLabel.setForeground(Color.WHITE);

        JButton continueBtn = new JButton("Continue");
        continueBtn.setFont(new Font("Arial", Font.BOLD, 20));
        continueBtn.setBackground(new Color(255, 215, 0));
        continueBtn.setForeground(Color.BLACK);

        continueBtn.addActionListener(e -> {
            frame.dispose();
            showLogin();
        });

        frame.add(welcomeLabel, BorderLayout.CENTER);
        frame.add(continueBtn, BorderLayout.SOUTH);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Login Window
    private static void showLogin() {
        JFrame frame = new JFrame("ATM System");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 2));
        frame.getContentPane().setBackground(new Color(204, 229, 255));

        JLabel cardLabel = new JLabel("Enter 9-digit Card Number:");
        cardLabel.setFont(new Font("Arial", Font.BOLD, 16));
        JTextField cardField = new JTextField();
        JLabel pinLabel = new JLabel("Enter 4-digit PIN:");
        pinLabel.setFont(new Font("Arial", Font.BOLD, 16));
        JPasswordField pinField = new JPasswordField();

        JButton loginBtn = new JButton("Login");
        loginBtn.setFont(new Font("Arial", Font.BOLD, 18));
        loginBtn.setBackground(new Color(0, 204, 102));
        loginBtn.setForeground(Color.WHITE);

        frame.add(cardLabel);
        frame.add(cardField);
        frame.add(pinLabel);
        frame.add(pinField);
        frame.add(new JLabel(""));
        frame.add(loginBtn);

        loginBtn.addActionListener(e -> {
            String card = cardField.getText();
            String enteredPin = new String(pinField.getPassword());

            if (card.length() != 9 || !card.matches("\\d{9}")) {
                JOptionPane.showMessageDialog(frame, "Card number must be 9 digits!");
            } else {
                // Set PIN to last 4 digits of card number if new card
                if (!card.equals(currentCardNumber)) {
                    pin = card.substring(5); // last 4 digits
                    currentCardNumber = card;
                }
                if (enteredPin.equals(pin)) {
                    frame.dispose();
                    showATMMenu();
                } else {
                    JOptionPane.showMessageDialog(frame, "Authentication Failed!");
                }
            }
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // ATM Menu
    private static void showATMMenu() {
        JFrame frame = new JFrame("ATM System");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(6, 1, 10, 10));
        frame.getContentPane().setBackground(new Color(255, 255, 204));

        JButton balanceBtn = new JButton("Balance");
        JButton depositBtn = new JButton("Deposit");
        JButton withdrawBtn = new JButton("Withdraw");
        JButton pinChangeBtn = new JButton("PIN Change");
        JButton historyBtn = new JButton("Transaction History");
        JButton exitBtn = new JButton("Exit");

        JButton[] btns = {balanceBtn, depositBtn, withdrawBtn, pinChangeBtn, historyBtn, exitBtn};
        Color[] colors = {
            new Color(153, 204, 255),
            new Color(153, 255, 153),
            new Color(255, 153, 153),
            new Color(255, 255, 153),
            new Color(204, 153, 255),
            new Color(255, 215, 0)
        };
        for (int i = 0; i < btns.length; i++) {
            btns[i].setFont(new Font("Arial", Font.BOLD, 20));
            btns[i].setBackground(colors[i]);
            frame.add(btns[i]);
        }

        balanceBtn.addActionListener(e -> 
            JOptionPane.showMessageDialog(frame, "Balance: ₹" + balance)
        );

        depositBtn.addActionListener(e -> {
            String amountStr = JOptionPane.showInputDialog("Enter Amount to Deposit:");
            if (amountStr != null && !amountStr.isEmpty()) {
                try {
                    double amt = Double.parseDouble(amountStr);
                    if (amt > 0) {
                        balance += amt;
                        history.add("Deposited ₹" + amt);
                        JOptionPane.showMessageDialog(frame, "₹" + amt + " Deposited");
                    } else {
                        JOptionPane.showMessageDialog(frame, "❌ Invalid Amount!");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "❌ Invalid Input!");
                }
            }
        });

        withdrawBtn.addActionListener(e -> {
            String amountStr = JOptionPane.showInputDialog("Enter Amount to Withdraw:");
            if (amountStr != null && !amountStr.isEmpty()) {
                try {
                    double amt = Double.parseDouble(amountStr);
                    if (amt > 0 && amt <= balance) {
                        balance -= amt;
                        history.add("Withdrew ₹" + amt);
                        JOptionPane.showMessageDialog(frame, "₹" + amt + " Withdrawn");
                    } else if (amt > balance) {
                        JOptionPane.showMessageDialog(frame, "❌ Insufficient Balance!");
                    } else {
                        JOptionPane.showMessageDialog(frame, "❌ Invalid Amount!");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "❌ Invalid Input!");
                }
            }
        });

        pinChangeBtn.addActionListener(e -> {
            String oldPin = JOptionPane.showInputDialog("Enter Old PIN:");
            if (oldPin != null && oldPin.equals(pin)) {
                String newPin = JOptionPane.showInputDialog("Enter New 4-digit PIN:");
                if (newPin != null && newPin.length() == 4 && newPin.matches("\\d{4}")) {
                    pin = newPin;
                    history.add("PIN Changed");
                    JOptionPane.showMessageDialog(frame, "PIN Changed Successfully!");
                } else {
                    JOptionPane.showMessageDialog(frame, "❌ Invalid New PIN!");
                }
            } else {
                JOptionPane.showMessageDialog(frame, "❌ Incorrect Old PIN!");
            }
        });

        historyBtn.addActionListener(e -> {
            if (history.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "No transactions yet.");
            } else {
                StringBuilder sb = new StringBuilder();
                for (String h : history) {
                    sb.append(h).append("\n");
                }
                JOptionPane.showMessageDialog(frame, sb.toString(), "Transaction History", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        exitBtn.addActionListener(e -> {
            frame.dispose();
            showThankYouScreen();
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Thank You Screen
    private static void showThankYouScreen() {
        JFrame frame = new JFrame("Thank You");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(new Color(0, 153, 76));
        JLabel thankLabel = new JLabel("Thank you, visit again!", SwingConstants.CENTER);
        thankLabel.setFont(new Font("Arial", Font.BOLD, 28));
        thankLabel.setForeground(Color.WHITE);

        frame.add(thankLabel, BorderLayout.CENTER);

        Timer timer = new Timer(2000, e -> System.exit(0));
        timer.setRepeats(false);
        timer.start();

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}