package ru.netology.repository;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.domain.PurchaseItem;
import ru.netology.manager.CartManager;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

class CartRepositoryTest {

    private CartRepository repository = Mockito.mock(CartRepository.class);

    private CartManager manager = new CartManager(repository);
    private PurchaseItem first = new PurchaseItem(1111, 1, "first", 100, 2);
    private PurchaseItem second = new PurchaseItem(22, 2, "second", 10, 1);
    private PurchaseItem third = new PurchaseItem(333, 3, "third", 1, 2);

    @Test
    public void shouldAddIfAlreadyContains() {
        PurchaseItem first = new PurchaseItem(1111, 1, "first", 100, 2);
        PurchaseItem second = new PurchaseItem(22, 2, "second", 10, 1);
        PurchaseItem third = new PurchaseItem(333, 3, "third", 1, 2);

        CartRepository repo = new CartRepository();
        repo.save(first);
        repo.save(second);

        repo.save(third);

        PurchaseItem[] expected = {first, second, third};
        PurchaseItem[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldCalculateSum() {
        //настройка заглушки
        PurchaseItem[] returned = {first, second, third};
        doReturn(returned).when(repository).findAll();

        int expected = 212;
        int actual = manager.sum();
        assertEquals(expected, actual);

        // удостоверяемся, что заглушка была вызвана
        // но это уже проверка "внутренней" реализации
        verify(repository).findAll();
    }


}