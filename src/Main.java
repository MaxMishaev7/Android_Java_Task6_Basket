import java.util.Scanner;
import ru.mishaev.max.Basket;

public class Main {
    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.printListOfProducts();
        Scanner scan = new Scanner(System.in);

        while(true) {
            System.out.print("\nВведите товар и его количество или \"end\": ");
            String data = scan.nextLine();
            if (data.equals("end")) {
                break;
            } else {
              basket.addProductQty(data);
            }
        }
        scan.close();
        basket.printBusket();
    }
}