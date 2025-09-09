package sdetinterviewquestions4;

import java.util.Scanner;

public class PrintInitials {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input first, middle, and last name
        System.out.print("Enter First Name: ");
        String firstName = sc.nextLine();

        System.out.print("Enter Middle Name: ");
        String middleName = sc.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = sc.nextLine();

        // Extract and print initials
        String initials = "";
        if (!firstName.isEmpty()) initials += firstName.toUpperCase().charAt(0);
        if (!middleName.isEmpty()) initials += middleName.toUpperCase().charAt(0);
        if (!lastName.isEmpty()) initials += lastName.toUpperCase().charAt(0);

        System.out.println("Initials: " + initials);
        
        sc.close();
    }
}
