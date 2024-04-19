package opg3;

import java.net.*;
import java.io.*;
import java.lang.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Screen-scrape tal: " + scrapeNumber());
        System.out.println("Screen-scrape USD -> DKK: " + dollarScrape());
    }

    public static int scrapeNumber() throws IOException {
        int result = 0;
        URL url = new URL("https://dis.students.dk/example1.php"); BufferedReader br = new BufferedReader( new InputStreamReader(url.openStream()));
        StringBuilder sb = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            sb.append(line);
        }

        int index1 = sb.toString().lastIndexOf("This page has been seen ") + "This page has been seen ".length();
        int index2  = sb.toString().indexOf(" times by everyone");

        result = Integer.parseInt(sb.toString().substring(index1, index2));

        return result;
    }

    public static double dollarScrape() throws IOException, ParseException {
        double result = 0;

        URL url = new URL("https://www.valutakurser.dk"); BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        StringBuilder sb = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            sb.append(line);
        }

        int index1 = sb.toString().indexOf("<a href=\"/valuta/amerikanske-dollar/USD\">");
        String nyString = sb.toString().substring(index1);

        int index2  = nyString.indexOf("</a>");
        String nyString2 = nyString.substring(0, index2);

        int index3 = nyString2.indexOf("<div class=\"currencyItem_actualValueContainer__2xLkB\">") + "<div class=\"currencyItem_actualValueContainer__2xLkB\">".length();
        String nyString3 = nyString.substring(index3);

        int index4 = nyString3.indexOf("</div>");

        NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
        Number number = format.parse(nyString3.substring(0, index4));

        result = number.doubleValue();

        return result;
    }


}
