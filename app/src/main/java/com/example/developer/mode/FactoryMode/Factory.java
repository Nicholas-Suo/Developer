package com.example.developer.mode.FactoryMode;
//if only one product,we can create the static Factory ,which includes static createProduct() method.
//if has many kind of products,we can create many concrete Factory for per product.
// we can also create the Factory using java reflection,the following code.
public abstract class Factory {
     public abstract <T extends Product> T createProduct(Class<T> tClass);
    }

