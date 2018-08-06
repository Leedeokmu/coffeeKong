package com.coffeekong.service;

import com.coffeekong.domain.SearchCriteria;
import com.coffeekong.model.Product;
import com.coffeekong.model.Review;
import com.coffeekong.repository.ProductRepository;
import com.coffeekong.repository.ReviewRepositry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ReviewRepositry reviewRepositry;

	// product
	public Page<Product> list(SearchCriteria cri, Pageable pageable) {
		return productRepository.findAllBySearchTypeAndKeyword(cri.getSearchType(), cri.getKeyword(), pageable);
	}

	public List<Product> listByCategory(String category) { return productRepository.findByCategory(category); }
	public Product getByPid(Integer pid) { return productRepository.getOne(pid); }

	@Transactional
	public void delete(int pid) { productRepository.delete(pid); }

	@Transactional
	public Product update(Product updatedProduct) { return productRepository.save(updatedProduct); }

	@Transactional
	public Product insert(Product product) {
		return productRepository.save(product);
	}

	// review
	public Page<Review> listReview(Integer pid, Pageable pageable) { return reviewRepositry.findAllByProductId(pid, pageable); }

	public Review addReview(Review review) { return reviewRepositry.save(review); }
	@Transactional
	public void deleteReview(Integer rid) {
		reviewRepositry.delete(rid);
	}
	
}
