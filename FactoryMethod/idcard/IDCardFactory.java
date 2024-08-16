package FactoryMethod.idcard;

import FactoryMethod.framework.Product;

import java.util.Hashtable;

import FactoryMethod.framework.Factory;

public class IDCardFactory extends Factory {
    private Hashtable<Integer, IDCard> database;

    public IDCardFactory() {
        database = new Hashtable<Integer, IDCard>();
    }
    @Override
    protected Product createProduct(String owner) {
        for (Integer i = 0; i < database.size(); i++) {
            if (database.get(i).getOwner().equals(owner)) {
                System.out.println(owner + "のカードはすでに作成されています。");
                return database.get(i);
            }
        }
        var idcard = new IDCard(owner);
        database.put(database.size(), idcard);
        return idcard;
    }
    @Override
    protected void registerProduct(Product product) {
        System.out.println(product + "のカードを登録します。");
    }
}