package com.example.productorderservice.product;

interface ProductPort {

    public void save(final Product product);

    Product getProduct(Long productId);
}
