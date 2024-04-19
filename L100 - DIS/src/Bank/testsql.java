import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

public class testsql {
    static Connection minConnection;
    static Statement stmt;
    static BufferedReader inLine;

    public static void main(String[] args) {
        try {
            inLine = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Program startet");

            String server = "localhost";
            String dbnavn = "BankLocks";
            String login = "sa";
            String password = "Camel13975";

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            minConnection = DriverManager.getConnection
                    ("jdbc:sqlserver://" + server + ";databaseName=" + dbnavn +
                            ";user=" + login + ";password=" + password + ";");

            stmt = minConnection.createStatement();
            ResultSet res = stmt.executeQuery("select * from konto");
            while (res.next()) {
                System.out.println("Konto " + res.getInt(1) + " har saldo " + res.getInt(2) + " og ejer " + res.getString(3));
            }
            int frakontoSaldo = 0;
            int tilkontoSaldo = 0;

            /** Indlæs frakonto */
            System.out.println("Skriv kontonr");
            String kontonr1 = inLine.readLine();
            System.out.println("Selecting first konti");
            ResultSet konti1 = stmt.executeQuery("SELECT * FROM konto WHERE kontonr = " + kontonr1);
            while (konti1.next()) {
                System.out.println("Konto " + konti1.getInt(1) + " har saldo " + konti1.getInt(2) + " og ejer " + konti1.getString(3));
            }

            System.out.println();

            /** Indlæs tilkonto */
            System.out.println("Skriv kontonr");
            String kontonr2 = inLine.readLine();
            System.out.println("Selecting second konti");
            ResultSet konti2 = stmt.executeQuery("SELECT * FROM konto WHERE kontonr = " + kontonr2);
            while (konti2.next()) {
                System.out.println("Konto " + konti2.getInt(1) + " har saldo " + konti2.getInt(2) + " og ejer " + konti2.getString(3));
            }

            System.out.println();

            /** Indlæs beløb */
            System.out.println("Skriv beløb som skal overføres fra første til anden konto");
            String beløb = inLine.readLine();

            /** Check at frakonto eksisterer og find saldoen */
            System.out.println("Checker om frakonto eksistere og printer saldo:");
            ResultSet konti1igen = stmt.executeQuery("SELECT * FROM konto WHERE kontonr = " + kontonr1);
            while (konti1igen.next()) {
                if (konti1igen.getInt(1) == 0) {
                    System.out.println("Konto eksistere ikke");
                } else {
                    System.out.println("saldo " + konti1igen.getInt(2));
                }
            }

            /** Kontroller at saldo er større end det beløb, der ønskes overført */
            ResultSet saldo = stmt.executeQuery("SELECT saldo FROM konto WHERE kontonr = " + kontonr1);
            if (saldo.getInt(2) < Integer.valueOf(beløb)) {
                System.out.println("Beløbet er for stort");
                System.out.println("Der er ikke nok penge på kontoen");
                return;
            }

            System.out.println();

            /** Check at tilkonto eksisterer og find saldoen */
            System.out.println("Checker om tilkonto eksistere og printer saldo:");
            ResultSet konti2igen = stmt.executeQuery("SELECT * FROM konto WHERE kontonr = " + kontonr2);
            while (konti2igen.next()) {
                if (konti2igen.getInt(1) == 0) {
                    System.out.println("Konto eksistere ikke");
                } else {
                    System.out.println("saldo " + konti2igen.getInt(2));
                }
            }

            /** Beregn de nye saldi */
            ResultSet saldo1 = stmt.executeQuery("SELECT * FROM konto WHERE kontonr = " + kontonr1);
            if (saldo1.next()) {
                frakontoSaldo = saldo1.getInt(2);
            } else {
                System.out.println("Konto eksistere ikke");
            }

            ResultSet saldo2 = stmt.executeQuery("SELECT * FROM konto WHERE kontonr = " + kontonr2);
            if (saldo2.next()) {
                tilkontoSaldo = saldo2.getInt(2);
            } else {
                System.out.println("Konto eksistere ikke");
            }

            int nyFrakontoSaldo = frakontoSaldo - Integer.valueOf(beløb);
            int nyTilkontoSaldo = tilkontoSaldo + Integer.valueOf(beløb);


            /** Opdatere kontier */
            System.out.println("Opdatere kontier");
            int konti1Updated = stmt.executeUpdate("UPDATE konto SET saldo = " + nyFrakontoSaldo + " WHERE kontonr = " + kontonr1);
            int konti2Updated = stmt.executeUpdate("UPDATE konto SET saldo = " + nyTilkontoSaldo + " WHERE kontonr = " + kontonr2);

            if (konti1Updated == 0 || konti2Updated == 0) {
                throw new SQLException("Fejl ved opdatering af konti");
            }

            if (stmt != null)
                stmt.close();
            if (minConnection != null)
                minConnection.close();
        } catch (Exception e) {
            System.out.print("fejl:  " + e.getMessage());
        }
    }
}