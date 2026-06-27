import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class BankTransactionalByMonth {

}
    private static final String RESOURCES = "Capitulo_2/src/";
    public static void main(String[] args) throws Exception{
        final Path path = Paths.get(RESOURCES + "bank-data-simple.csv");//criando url do caminho
        final List<String> lines = Files.readAllLines(path);
        final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        double total = 0d;
        for(String line: lines){
            String[] columns = line.split(",");
            final LocalDate date = LocalDate.parse(columns[0],DATE_PATTERN);
            if(date.getMonth() == Month.JANUARY) {
                double amount = Double.parseDouble(columns[1]);//pego os valores do indice 1 do nosso arquivo
                total += amount;
            }
        }

        IO.println("Nosso valor total "+ total);
}
