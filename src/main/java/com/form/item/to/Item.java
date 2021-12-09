package com.form.item.to;

import com.form.item.to.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Item {

    private int amount;
    private Product product;

    public double getTotal() {
        return this.product.getPrice() * this.amount;
    }
}
