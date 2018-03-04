package com.coffeekong.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.coffeekong.domain.Criteria;
import com.coffeekong.domain.ProductVO;
import com.coffeekong.domain.ReviewVO;
import com.coffeekong.domain.SearchCriteria;
import com.coffeekong.mapper.ProductDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService {
	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	private ProductDAO dao;
	
	@Override
	public List<ProductVO> listByCategory(String category) throws Exception {
		return dao.listByCategory(category);
	}
	@Override
	public ProductVO getByPid(int pid) throws Exception {
		return dao.getByPid(pid);
	}
	@Override
	public List<ProductVO> list(SearchCriteria cri) throws Exception {
		return dao.list(cri);
	}
	@Override
	public int listCount(SearchCriteria cri) throws Exception {
		return dao.listCount(cri);
	}
	
	@Transactional
	@Override
	public void delete(int pid) throws Exception {
		dao.delete(pid);
	}
	@Override
	public void update(ProductVO pvo) throws Exception {
		dao.update(pvo);
	}
	@Override
	public void insert(ProductVO pvo) throws Exception {
		dao.insert(pvo);
	}
	@Override
	public List<ReviewVO> listReview(int pid, Criteria cri) throws Exception {
		return dao.listReview(pid, cri);
	}
	@Override
	public int listReviewCount(int pid) throws Exception {
		return dao.listReviewCount(pid);
	}
	@Override
	public void addReview(ReviewVO rvo) throws Exception {
		dao.addReview(rvo);
	}
	@Override
	public void deleteReview(int rid) throws Exception {
		dao.deleteReview(rid);
	}
	
}
