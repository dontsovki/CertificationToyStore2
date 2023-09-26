package progect;

import java.util.Scanner;
import progect.Toy;
import progect.view;
import progect.DataService;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Controller {
        Scanner in = new Scanner(System.in);
        DataService dataService;
        view view;

        public Controller() {
            dataService = new DataService();
            view = new view();
        }


        public void run() {
            while (true) {
                view.menu();
                int menuItem = 0;
                if(in.hasNextInt()) {
                    menuItem = in.nextInt();
                } else {
                    System.out.println("Ошибка! нужно ввести число!");
                }

                if (menuItem == 1) {
                    Toy toy = new Toy(view.menuAddName(),
                            view.menuAddQuantity(),
                            view.menuAddFrequency());
                    dataService.addToysToQueue(toy);
                } else if (menuItem == 2){
                    dataService.startLottery();
                } else if (menuItem == 3){
                    dataService.changeFrequency(view.menuInputName(), view.menuChangeFrequency());
                } else {
                    System.out.println("Программа завершена");
                    break;
                }
            }

        }
}
