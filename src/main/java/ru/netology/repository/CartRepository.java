package ru.netology.repository;

import ru.netology.domain.PurchaseItem;

public class CartRepository {
    private PurchaseItem[] items = new PurchaseItem[0];

    public void save(PurchaseItem item) {
        // создаем новый массив размером на единицу больше
        int length = items.length + 1;
        PurchaseItem[] tmp = new PurchaseItem[length];
        //itar + tab
        //копируем поэлементно
        //for (int i = 0; i < items.length; i++) {
        //    tmp[i] = items[i];
        //}
        System.arraycopy(items, 0, tmp, 0, items.length);
        //кладем последний наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public PurchaseItem[] findAll() {
        return items;
    }

    public void removeById(int id) {
        int length = items.length - 1;
        PurchaseItem[] tmp = new PurchaseItem[length];
        int index = 0;
        for (PurchaseItem item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        //меняем наши элементы
        items = tmp;
    }
}
