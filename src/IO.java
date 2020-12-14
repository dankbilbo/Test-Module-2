import java.io.*;
import java.util.ArrayList;

public class IO {
    private static File file = null;
    private static FileWriter fileWriter = null;
    private static FileReader fileReader = null;
    private static BufferedReader bufferedReader = null;

    public static void writeContactsToFile(ArrayList<Contact> contacts) {
        file = new File("Contact.csv");
        try {
            file.createNewFile();
            fileWriter = new FileWriter(file);
            for (Contact contact : contacts) {
                fileWriter.append(contact.stringToFile());
                fileWriter.append("\n");
                fileWriter.flush();
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("I/O error");
        }
    }
    public static void writeContactsToFile(Contact contact) {
        file = new File("Contact.csv");
        try {
            file.createNewFile();
            fileWriter = new FileWriter(file,true);
            fileWriter.append(contact.stringToFile());
            fileWriter.append("\n");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("I/O error");
        }
    }

    public static ArrayList<Contact> readFileToListContact() {
        ArrayList<Contact> contacts = new ArrayList<>();
        file = new File("Contact.csv");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split(",");
                String name = split[0];
                String number = split[1];
                String group = split[2];
                String gender = split[3];
                String address = split[4];
                String email = split[5];
                String dob = split[6];
                Contact contact = FactoryContact.getContact();
                contact.setEmail(email);
                contact.setDob(dob);
                contact.setGender(gender);
                contact.setNumber(number);
                contact.setGroup(group);
                contact.setAddress(address);
                contact.setName(name);
                contacts.add(contact);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("I/O error");
        }
        return contacts;
    }
}