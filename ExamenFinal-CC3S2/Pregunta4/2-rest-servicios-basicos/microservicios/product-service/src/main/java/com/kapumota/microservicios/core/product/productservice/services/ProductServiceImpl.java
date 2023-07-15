package com.kapumota.microservicios.core.product.productservice.services;

import com.kapumota.api.core.product.Product;
import com.kapumota.api.core.product.ProductService;
import com.kapumota.microservicios.common.exceptions.InvalidInputException;
import com.kapumota.microservicios.common.exceptions.NotFoundException;
import com.kapumota.util.http.ServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductServiceImpl implements ProductService {

  private static final Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);

  private final ServiceUtil serviceUtil;

  @Autowired
  public ProductServiceImpl(ServiceUtil serviceUtil) {
    this.serviceUtil = serviceUtil;
  }

  @Override
  public Product getProduct(int productId) {
    LOG.debug("/producto devuelto para el id del producto={}", productId);

    if (productId < 1) {
      throw new InvalidInputException("Id del producto incorrecto: " + productId);
    }

    if (productId == 13) {
      throw new NotFoundException("No hay producto para el Id del producto: " + productId);
    }

    return new Product(productId, "nombre-" + productId, 123, serviceUtil.getServiceAddress());
  }
}
