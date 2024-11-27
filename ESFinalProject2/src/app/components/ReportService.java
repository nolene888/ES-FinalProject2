package app.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import app.repository.FeedbackRepository;
import app.repository.UserRepository;
import app.repository.CategoryRepository;  // Import CategoryRepository
import app.entity.Category;  // Import Category entity

import java.util.HashMap;
import java.util.Map;

@Component
public class ReportService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private CategoryRepository categoryRepository;  


    public Map<String, Integer> generateFeedbackReport() {
        Map<String, Integer> report = new HashMap<>();

        // 1. First, add all categories to the report with an initial count of 0
        categoryRepository.findAll().forEach(category -> {
            report.put(category.getName(), 0);
        });

        // 2. Count feedback by category
        feedbackRepository.findAll().forEach(feedback -> {

            Long categoryId = feedback.getCategoryId();
            categoryRepository.findById(categoryId).ifPresent(category -> {
                String categoryName = category.getName();  
                report.put(categoryName, report.getOrDefault(categoryName, 0) + 1);
            });
        });

        return report;
    }
}
