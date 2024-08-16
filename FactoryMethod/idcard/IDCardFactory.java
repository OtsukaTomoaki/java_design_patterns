package FactoryMethod.idcard;

import FactoryMethod.framework.Product;
import FactoryMethod.framework.Factory;

public class IDCardFactory extends Factory {
    @Override
    protected Product createProduct(String owner) {
        return new IDCard(owner);
    }
    @Override
    protected void registerProduct(Product product) {
        System.out.println(product + "のカードを登録します。");
    }
}