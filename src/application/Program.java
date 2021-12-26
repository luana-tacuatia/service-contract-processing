package application;

import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.PaypalService;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter contract data");
        System.out.print("Number: ");
        int contractNumber = sc.nextInt();
        System.out.print("Date (dd/MM/yyyy): ");
        Date date = sdf.parse(sc.next());
        System.out.print("Contract value: ");
        double totalValue = sc.nextDouble();

        Contract contract = new Contract(contractNumber, date, totalValue);

        System.out.print("Enter number of installments: ");
        int numberInstallments = sc.nextInt();

        ContractService cs = new ContractService(new PaypalService());

        cs.processContract(contract, numberInstallments);

        System.out.println("INSTALLMENTS:");
        for (Installment it : contract.getInstallments()) {
            System.out.println(it);
        }

        sc.close();
    }
}
