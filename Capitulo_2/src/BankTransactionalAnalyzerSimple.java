import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class BankTransactionalAnalyzerSimple {
    private static final String RESOURCES = "Capitulo_2/src/";//guarda o caminho

    public static void main(String[] args) throws Exception{
        final Path path = Paths.get(RESOURCES + "bank-data-simple.csv");//criando url do caminho
        final List<String> lines = Files.readAllLines(path);
        double total = 0;
        int fck = 0;
        for(String line: lines){
            if(line.isBlank() || line.contains("Resultado,")){
                fck++;
                continue;
            }
                String[] columns = line.split(",");
                double amount = Double.parseDouble(columns[1]);//pego os valores do indice 1 da nossa
                total += amount;

        }
        if(fck == 0){
        String result = "\nResultado, " +Double.toString(total);
        Files.writeString(path, result, StandardOpenOption.APPEND);
        }

        IO.println("Nosso valor total "+ total);
    }


}
