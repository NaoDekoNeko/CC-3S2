package com.kapumota.microservicios.composite.product.productcompositeservice.services;

import java.util.ArrayList;
import java.util.List;

import com.kapumota.api.composite.product.*;
import com.kapumota.api.exceptions.NotFoundException;
import com.kapumota.util.http.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.kapumota.api.core.product.Product;
import com.kapumota.api.core.recommendation.Recommendation;
import com.kapumota.api.core.review.Review;

@RestController
public class ProductCompositeServiceImpl implements ProductCompositeService {
    ProductCompositeIntegration integration;
    ServiceUtil serviceUtil;

    @Autowired
    public ProductCompositeServiceImpl(ProductCompositeIntegration integration, ServiceUtil serviceUtil) {
        this.integration = integration;
        this.serviceUtil = serviceUtil;
    }

    @Override
    public ProductAggregate getProduct(int productId) {

        Product product = integration.getProduct(productId);
        if (product == null) {
            throw new NotFoundException("No se encontró el producto con id: " + productId);
        }
        List<Recommendation> recommendations = integration.getRecommendations(productId);
        List<Review> reviews = integration.getReviews(productId);

        return createProductAggregate(product, recommendations,
                reviews, serviceUtil.getServiceAddress());
    }


    private ProductAggregate createProductAggregate(Product product, List<Recommendation> recommendations, List<Review> reviews, String serviceAddress) {
        // Crear listas de resúmenes de recomendaciones y revisiones
        List<RecommendationSummary> recommendationSummaries = new ArrayList<>();
        for (Recommendation recommendation : recommendations) {
            recommendationSummaries.add(new RecommendationSummary(recommendation.getRecommendationId(), recommendation.getAuthor(), recommendation.getRate()));
        }

        List<ReviewSummary> reviewSummaries = new ArrayList<>();
        for (Review review : reviews) {
            reviewSummaries.add(new ReviewSummary(review.getReviewId(), review.getAuthor(), review.getSubject()));
        }

        // Crear objeto ServiceAddresses
        ServiceAddresses serviceAddresses = new ServiceAddresses();

        // Crear y devolver objeto ProductAggregate
        return new ProductAggregate(product.getProductId(), product.getName(), product.getWeight(), recommendationSummaries, reviewSummaries, serviceAddresses);
    }

}
