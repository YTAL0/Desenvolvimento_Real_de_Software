import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class BankTransactionalAnalyzerSimple {
    private static final String RESOURCES = "Capitulo_2/src/";//guarda o caminho

    public static void main() throws Exception{
        final Path path = Paths.get(RESOURCES + "bank-data-simple.csv");//criando url do caminho
        final List<String> lines = Files.readAllLines(path);
        double total = 0;

        for(String line: lines){
            String[] columns = line.split(",");
            double amount = Double.parseDouble(columns[1]);//pego os valores do indice 1 da nossa
            total+=amount;
        }

        IO.println("Nosso valor total "+ total);
    }


}
