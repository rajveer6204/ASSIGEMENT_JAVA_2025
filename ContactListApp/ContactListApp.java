// Name: BADAL PRASAD           
// Course: B.Tech CSE(Full Stack Development)
// Roll Number: 2501351020

import java.util.Scanner;

class Contact {
    String name;
    String phone;
    String email;

    Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public void display() {
        System.out.println("Name: " + name + ", Phone: " + phone + ", Email: " + email);
    }
}

class ContactManager {
    Contact[] contacts = new Contact[100];  // max 100 contacts
    int count = 0;

    // Add a contact
    public void addContact(Contact c) {
        if (count < contacts.length) {
            contacts[count++] = c;
            System.out.println("Contact added successfully.");
        } else {
            System.out.println("Contact list is full!");
        }
    }

    // Remove a contact
    public boolean removeContact(String name) {
        for (int i = 0; i < count; i++) {
            if (contacts[i].name.equalsIgnoreCase(name)) {
                // shift array left
                for (int j = i; j < count - 1; j++) {
                    contacts[j] = contacts[j + 1];
                }
                count--;
                return true;
            }
        }
        return false;
    }

    // Search a contact
    public Contact searchContact(String name) {
        for (int i = 0; i < count; i++) {
            if (contacts[i].name.equalsIgnoreCase(name)) {
                return contacts[i];
            }
        }
        return null;
    }

    // Display all contacts
    public void displayAll() {
        if (count == 0) {
            System.out.println("No contacts available.");
            return;
        }

        System.out.println("\nAll Contacts:");
        for (int i = 0; i < count; i++) {
            contacts[i].display();
        }
    }
}

public class ContactListApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContactManager manager = new ContactManager();

        while (true) {
            System.out.println("\n===== Contact List Application =====");
            System.out.println("1. Add Contact");
            System.out.println("2. Remove Contact");
            System.out.println("3. Search Contact");
            System.out.println("4. Display All Contacts");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int ch = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (ch) {

                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Phone Number: ");
                    String phone = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    manager.addContact(new Contact(name, phone, email));
                    break;

                case 2:
                    System.out.print("Enter name to remove: ");
                    String rname = sc.nextLine();
                    if (manager.removeContact(rname))
                        System.out.println("Contact removed.");
                    else
                        System.out.println("Contact not found.");
                    break;

                case 3:
                    System.out.print("Enter name to search: ");
                    String sname = sc.nextLine();
                    Contact result = manager.searchContact(sname);

                    if (result != null)
                        result.display();
                    else
                        System.out.println("Contact not found.");
                    break;

                case 4:
                    manager.displayAll();
                    break;

                case 5:
                    System.out.println("Exiting... Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}