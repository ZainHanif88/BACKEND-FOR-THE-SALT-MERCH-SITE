package se.jensenyh.javacourse.saltmerch.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.jensenyh.javacourse.saltmerch.backend.model.CartItem;
import se.jensenyh.javacourse.saltmerch.backend.repository.CartRepository;

import java.util.List;

@Service
public class CartService {

    @Autowired
    CartRepository db;

    public CartService(CartRepository repository) {
        this.db = repository;
    }


    public List<CartItem> getItems(int id) {

        return db.selectAllItems();
    }

    public int addItem(int id, String action, CartItem item) {

        return db.insertOrIncrementItem(item);
    }

    public int removeItem(int id, String action, CartItem item) {

        return db.deleteOrDecrementItem(item);
    }

    public void clearCartAndRestock(int id) {

        db.deleteAllItems(true);
    }

    public void clearCart(boolean buyout) {

        db.deleteAllItems(false);
    }
}