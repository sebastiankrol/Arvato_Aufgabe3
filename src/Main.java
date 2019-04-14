import sun.plugin.javascript.navig.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        Flear flear1 = new Flear("numberOne", 10, 7);
        Flear flear2 = new Flear("numberTwo", 900, 10);
        Flear flear3 = new Flear("numberThree", 5, 5);
        Flear flear4 = new Flear("numberFour", 50, 10);
        List<Flear> flearList = new ArrayList<>();
        flearList.addAll(Arrays.asList(flear1, flear2, flear3, flear4));
        getOptimalValue(963, flearList);

    }


    public static float getOptimalValue(float money, List<Flear> flears) {
        int res = 0;
        float startMoney = money;
        float paid = money;
        List<String> nameOfFlears = new ArrayList<>();
        flears.sort(Comparator.comparing(Flear::getRating).reversed());

        for (int i = 0; i < flears.size(); i++) {
            if (money >= 0 && flears.get(i).price <= money) {
                nameOfFlears.add(flears.get(i).name);
                money = money - flears.get(i).price;
                System.out.println("money: " + money);
                res = res + flears.get(i).rating;
                System.out.println("rating: " + res);
            }

        }
        paid = paid - money;
        System.out.println("You can buy these Flears with " + startMoney + ": " + nameOfFlears + ". You have paid " + paid + "€. Their summed raiting is :" + res);
//
// TODO implement me
// ...
        return money;
    }


}