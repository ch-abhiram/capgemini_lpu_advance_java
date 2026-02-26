package com.Main;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.Entity.BankAccount;
import com.Entity.Card;
import com.Entity.Customer;
import com.Entity.Transaction;
import com.Util.JpaUtil;

import Dao.BankAccountDao;
import Dao.CardDao;
import Dao.CustomerDao;
import Dao.TransactionDAO;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static CardDao cardDAO = new CardDao();
    static TransactionDAO txnDAO = new TransactionDAO();
    static CustomerDao customerDAO = new CustomerDao();
    static BankAccountDao accountDAO = new BankAccountDao();

    // ===================== CARD =====================

    public static void deactivateCard(){
        System.out.print("Card ID: ");
        Long id = Long.parseLong(sc.nextLine());
        cardDAO.deactivateCard(id);
    }

    public static void viewAllCards(){
        List<Card> list = cardDAO.findAll();
        for(Card c : list){
            System.out.println(
                    c.getCardId()+" | "+
                    c.getCardName()+" | "+
                    c.getCardNetwork()+" | active="+c.isActive()
            );
        }
    }

    public static void assignCardToCustomer(){
        System.out.print("Customer ID: ");
        Long custId = Long.parseLong(sc.nextLine());

        System.out.print("Card ID: ");
        Long cardId = Long.parseLong(sc.nextLine());

        cardDAO.assignCardToCustomer(cardId, custId);
    }

    public static void issueCard(){
        System.out.print("Network: ");
        String network = sc.nextLine();

        System.out.print("Card Type: ");
        String type = sc.nextLine();

        System.out.print("Card Name: ");
        String name = sc.nextLine();

        System.out.print("Expiry yyyy-mm-dd: ");
        LocalDate exp = LocalDate.parse(sc.nextLine());

        System.out.print("Account ID: ");
        Long acc = Long.parseLong(sc.nextLine());

        Card card = new Card();
        card.setCardName(name);
        card.setCardType(type);
        card.setCardNetwork(network);
        card.setExpiryDate(exp);
        card.setActive(true);

        cardDAO.issueCard(card, acc);
    }

    // ===================== CUSTOMER =====================

    public static void viewAllCustomers(){
        List<Customer> list = customerDAO.findAll();
        if(list.isEmpty()){
            System.out.println("No customers");
            return;
        }

        for(Customer c : list){
            System.out.println(
                    c.getCustomerId()+" | "+
                    c.getFullName()+" | "+
                    c.getEmail()
            );
        }
    }

    public static void addCustomer(){
        System.out.print("Phone: ");
        String phone = sc.nextLine();

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        Customer c = new Customer(0, name, email, phone);
        c.setCards(new ArrayList<>());

        customerDAO.save(c);
        System.out.println("Customer saved.");
    }

    // ===================== TRANSACTION =====================

    public static void viewTransactions(){
        System.out.print("Account ID: ");
        Long id = Long.parseLong(sc.nextLine());

        List<Transaction> list = txnDAO.findByAccount(id);

        for(Transaction t : list){
            System.out.println(
                    t.getTransactionId()+" | "+
                    t.getTxnType()+" | "+
                    t.getAmount()+" | "+
                    t.getDescription()+" | "+
                    t.getTxnDate()
            );
        }
    }

    public static void recordTransaction(){
        System.out.print("Reference: ");
        String ref = sc.nextLine();

        System.out.print("Description: ");
        String desc = sc.nextLine();

        System.out.print("Amount: ");
        BigDecimal amt = new BigDecimal(sc.nextLine());

        System.out.print("Type (CREDIT/DEBIT): ");
        String type = sc.nextLine();

        System.out.print("Account ID: ");
        Long accId = Long.parseLong(sc.nextLine());

        Transaction t = new Transaction();
        t.setTxnType(type);
        t.setAmount(amt);
        t.setDescription(desc);
        t.setReferenceNumber(ref);
        t.setTxnDate(LocalDateTime.now());

        txnDAO.save(t, accId);
    }

    // ===================== ACCOUNT =====================

    public static void linkAccountToCustomer(){
        System.out.print("Customer ID: ");
        Long custId = Long.parseLong(sc.nextLine());

        System.out.print("Account ID: ");
        Long accId = Long.parseLong(sc.nextLine());

        accountDAO.linkToCustomer(accId, custId);
    }

    public static void createBankAccount(){
        System.out.print("Balance: ");
        BigDecimal bal = new BigDecimal(sc.nextLine());

        System.out.print("Account Type: ");
        String type = sc.nextLine();

        System.out.print("Account Number: ");
        String num = sc.nextLine();

        BankAccount ba = new BankAccount(0, num, type, bal);
        accountDAO.save(ba);

        System.out.println("Account created.");
    }

    // ===================== MENU =====================

    public static void printMainMenu(){
        System.out.println("\n===== FINTECH MENU =====");
        System.out.println("7 Issue Card");
        System.out.println("3 Create Bank Account");
        System.out.println("1 Add Customer");
        System.out.println("9 View All Cards");
        System.out.println("4 Link Account To Customer");
        System.out.println("2 View Customers");
        System.out.println("6 View Transactions");
        System.out.println("5 Record Transaction");
        System.out.println("10 Deactivate Card");
        System.out.println("8 Assign Card To Customer");
        System.out.println("0 Exit");
        System.out.print("Choice: ");
    }

    // ===================== MAIN =====================

    public static void main(String[] args) {

        try {
            boolean running = true;

            while(running){

                printMainMenu();
                String choice = sc.nextLine();

                switch(choice){

                    case "7": issueCard(); break;
                    case "1": addCustomer(); break;
                    case "3": createBankAccount(); break;
                    case "9": viewAllCards(); break;
                    case "6": viewTransactions(); break;
                    case "2": viewAllCustomers(); break;
                    case "5": recordTransaction(); break;
                    case "4": linkAccountToCustomer(); break;
                    case "10": deactivateCard(); break;
                    case "8": assignCardToCustomer(); break;

                    case "0":
                        running = false;
                        JpaUtil.close();
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice");
                }
            }

        } finally {
            JpaUtil.close();
        }
    }
}