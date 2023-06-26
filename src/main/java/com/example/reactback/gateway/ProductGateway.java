package com.example.reactback.gateway;


import com.example.reactback.model.Product;
import com.example.reactback.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor
@Service
public class ProductGateway {

    private final ImageGateway imageGateway;
    private final ProductRepository repository;

    private static final String PATH = "./address-proof/";


    public Product save(final MultipartFile file) throws IOException {
        String path = imageGateway.saveImage(file, PATH);

        final var product = new Product();
        product.setPath(path);

        return repository.save(product);
    }


}
