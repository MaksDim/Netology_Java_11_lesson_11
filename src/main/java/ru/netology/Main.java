package ru.netology;

import ru.netology.domain.PurchaseItem;
import ru.netology.repository.CartRepository;

public class Main {

    public static void main(String[] args) {
        PurchaseItem first = new PurchaseItem(1111, 1, "first", 100, 2);
        PurchaseItem second = new PurchaseItem(22, 2, "second", 10,1 );
        PurchaseItem third = new PurchaseItem(333, 3, "third",1,2 );

        CartRepository repo = new CartRepository();
        repo.save(first);
        repo.save(second);
        repo.save(third);
        repo.removeById(22);
    }
        /*String[] names = {
                "Petya",
                "Anya",
                "Olya",
                "Kolya",
                "Sveta"
        };
        String removeName = "Olya";

        String[] tmp = new String[names.length - 1];
        int copyToIndex = 0;
        for (int i = 0; i < names.length; i++) {
            if (!names[i].equals(removeName)) {
                tmp[copyToIndex] = names[i];
                copyToIndex++;
            }
        }
        names = tmp;
    }

//        String newName = "Kolya";
//
//        String[] tmp = new String[names.length + 1];
//
//        for (int i = 0; i < names.length; i++) {
//            tmp[i] = names[i];
//        }
//        tmp[tmp.length - 1] = newName;
//        names = tmp;
//    }*/

}