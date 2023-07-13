package com.kapumota.api.composite.product;

import java.util.ArrayList;
import java.util.List;
import com.kapumota.util.http.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.kapumota.api.core.product.Product;
import com.kapumota.api.core.recommendation.Recommendation;
import com.kapumota.api.core.review.Review;

@RestController
public class ProductCompositeServiceImpl implements ProductCompositeService{

    private final ServiceUtil serviceUtil;
    private final ProductCompositeIntegration integration;

    @Autowired
    public ProductCompositeServiceImpl(ServiceUtil serviceUtil, ProductCompositeIntegration integration) {
        this.serviceUtil = serviceUtil;
        this.integration = integration;
    }


    @Override
    public ProductAggregate getProduct(int productId) {
        Product product = integration.getProduct(productId);
        List<Recommendation> recommendations = integration.getRecommendations(productId);
        List<Review> reviews = integration.getReviews(productId);
        return createProductAggregate(product, recommendations,
                reviews, serviceUtil.getServiceAddress());
    }

    private ProductAggregate createProductAggregate(Product product, List<Recommendation> recommendations, List<Review> reviews, String serviceAddress) {
        // Creamos la lista con el resumen de recomendaciones
        List<RecommendationSummary> recommendationSummaries = new ArrayList<>();
        for (Recommendation r : recommendations) {
            recommendationSummaries.add(new RecommendationSummary(r.getRecommendationId(), r.getAuthor(), r.getRate()));
        }

        // Creamos una lista con el resumen de reseñas
        List<ReviewSummary> reviewSummaries = new ArrayList<>();
        for (Review r : reviews) {
            reviewSummaries.add(new ReviewSummary(r.getReviewId(), r.getAuthor(), r.getSubject()));
        }

        // Creamos un objeto que tendrá las direcciones URL de los servicios que tiene el servicio compuesto
        ServiceAddresses serviceAddresses = new ServiceAddresses(
                serviceAddress,
                integration.getProductServiceUrl(),
                integration.getReviewServiceUrl(),
                integration.getRecommendationServiceUrl()
        );

        // Crea y devuelve el Producto agregado
        return new ProductAggregate(
                product.getProductId(),
                product.getName(),
                product.getWeight(),
                recommendationSummaries,
                reviewSummaries,
                serviceAddresses
        );
    }



}
