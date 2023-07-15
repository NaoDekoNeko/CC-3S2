package com.kapumota.api.composite.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.kapumota.api.core.product.Product;
import com.kapumota.api.core.product.ProductService;
import com.kapumota.api.core.recommendation.Recommendation;
import com.kapumota.api.core.recommendation.RecommendationService;
import com.kapumota.api.core.review.Review;
import com.kapumota.api.core.review.ReviewService;


@Component
public class ProductCompositeIntegration implements ProductService,
        RecommendationService, ReviewService {

    private final RestTemplate restTemplate;
    private final String productServiceUrl;
    private final String recommendationServiceUrl;
    private final String reviewServiceUrl;


    //no se me ocurrió otra cosa que hacer que se obtenga la dirección de cada servicio
    public ProductCompositeIntegration(
            RestTemplate restTemplate,
            @Value("${app.product-service.host}") String productServiceHost,
            @Value("${app.product-service.port}") int productServicePort,
            @Value("${app.recommendation-service.host}") String recommendationServiceHost,
            @Value("${app.recommendation-service.port}") int recommendationServicePort,
            @Value("${app.review-service.host}") String reviewServiceHost,
            @Value("${app.review-service.port}") int reviewServicePort
    ) {
        this.restTemplate = restTemplate;
        productServiceUrl = "http://" + productServiceHost + ":" + productServicePort;
        recommendationServiceUrl = "http://" + recommendationServiceHost + ":" + recommendationServicePort;
        reviewServiceUrl = "http://" + reviewServiceHost + ":" + reviewServicePort;
    }

    @Override
    public Product getProduct(int productId) {
        ResponseEntity<Product> response = restTemplate.getForEntity(productServiceUrl + "/product/" + productId, Product.class);
        return response.getBody();
    }

    @Override
    public List<Recommendation> getRecommendations(int productId) {
        ResponseEntity<List<Recommendation>> response = restTemplate.exchange(
                recommendationServiceUrl + "/recommendation?productId=" + productId,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Recommendation>>() {}
        );
        return response.getBody();
    }

    @Override
    public List<Review> getReviews(int productId) {
        ResponseEntity<List<Review>> response = restTemplate.exchange(
                reviewServiceUrl + "/review?productId=" + productId,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Review>>() {}
        );
        return response.getBody();
    }
}
