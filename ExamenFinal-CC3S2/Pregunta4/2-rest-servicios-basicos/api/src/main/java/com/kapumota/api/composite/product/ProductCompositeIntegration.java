package com.kapumota.api.composite.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kapumota.api.core.product.Product;
import com.kapumota.api.core.product.ProductService;
import com.kapumota.api.core.recommendation.Recommendation;
import com.kapumota.api.core.recommendation.RecommendationService;
import com.kapumota.api.core.review.Review;
import com.kapumota.api.core.review.ReviewService;

@ComponentScan(basePackages = "com.kapumota.api.composite.product")
public class ProductCompositeIntegration implements ProductService,
RecommendationService, ReviewService{

    private RestTemplate restTemplate;
    private String productServiceUrl;
    private String recommendationServiceUrl;
    private String reviewServiceUrl;
    private ObjectMapper jsonMapper;

    @Override
    public List<Review> getReviews(int productId) {
        String url = reviewServiceUrl + productId;
        //codigo "complicado" que devuelve la lista de reseñas
        ResponseEntity<List<Review>> response = restTemplate.exchange(
            url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Review>>() {}
        );
        List<Review> reviews = response.getBody();
        return reviews;
    }

    @Override
    public List<Recommendation> getRecommendations(int productId) {
        String url = recommendationServiceUrl + productId;
        //codigo "complicado" que devuelve la lista de recomendaciones
        ResponseEntity<List<Recommendation>> response = restTemplate.exchange(
            url, HttpMethod.GET, null,
            new ParameterizedTypeReference<List<Recommendation>>() {}
        );
        List<Recommendation> recommendations = response.getBody();
        return recommendations;
    }

    @Override
    public Product getProduct(int productId) {
        String url = productServiceUrl + productId;
        //obtener el producto
        Product product = restTemplate.getForObject(url, Product.class);
        return product;
    }

    public ProductCompositeIntegration(RestTemplate restTemplate, ObjectMapper jsonMapper,
                                   @Value("${app.product-service.host}") String productServiceHost,
                                   @Value("${app.product-service.port}") int productServicePort,
                                   @Value("${app.recommendation-service.host}") String recommendationServiceHost,
                                   @Value("${app.recommendation-service.port}") int recommendationServicePort,
                                   @Value("${app.review-service.host}") String reviewServiceHost,
                                   @Value("${app.review-service.port}") int reviewServicePort) {
    // guardar los objetos inyectados y sus valores
    this.restTemplate = restTemplate;
    this.jsonMapper = jsonMapper;

    // creamos las url para acceder a los objetos core
    this.productServiceUrl = "http://" + productServiceHost + ":" + productServicePort + "/product/";
    this.recommendationServiceUrl = "http://" + recommendationServiceHost + ":" + recommendationServicePort + "/recommendation?productId=";
    this.reviewServiceUrl = "http://" + reviewServiceHost + ":" + reviewServicePort + "/review?productId=";
}


    public String getProductServiceUrl() {
        return productServiceUrl;
    }

    public String getReviewServiceUrl() {
        return reviewServiceUrl;
    }

    public String getRecommendationServiceUrl() {
        return recommendationServiceUrl;
    }
}
