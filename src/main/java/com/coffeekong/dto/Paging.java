package com.coffeekong.dto;

import lombok.Data;

@Data
public class Paging {
    boolean isNowFirst;
    boolean isNowFinal;
    int startPage;
    int endPage;
    private int pageSize; // 게시 글 수
    private int firstPageNo; // 첫 번째 페이지 번호
    private int prevPageNo; // 이전 페이지 번호
    private int startPageNo; // 시작 페이지 (페이징 네비 기준)
    private int pageNo; // 페이지 번호
    private int endPageNo; // 끝 페이지 (페이징 네비 기준)
    private int nextPageNo; // 다음 페이지 번호
    private int finalPageNo; // 마지막 페이지 번호
    private int totalCount; // 게시 글 전체 수
    private int pageCount; // 현재 페이지 * 게시 글 수

    /**
     * @param totalCount the totalCount to set
     */
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount <= 0 ? 1 : totalCount;
        this.makePaging();
    }

    /**
     * 페이징 생성
     */
    private void makePaging() {
        if (this.totalCount == 0) return; // 게시 글 전체 수가 없는 경우
        if (this.pageNo == 0) this.setPageNo(1); // 기본 값 설정
        if (this.pageSize == 0) this.setPageSize(10); // 기본 값 설정

        int finalPage = (totalCount + (pageSize - 1)) / pageSize; // 마지막 페이지

        this.pageCount = pageSize * (pageNo == 1 ? 0 : pageNo - 1);

        if (this.pageNo > finalPage) this.setPageNo(finalPage); // 기본 값 설정

        if (this.pageNo < 0 || this.pageNo > finalPage) this.pageNo = 1; // 현재 페이지 유효성 체크

        this.isNowFinal = this.pageNo == finalPage ? true : false; // 마지막 페이지 (전체)
        this.isNowFirst = this.pageNo == 1 ? true : false; // 시작 페이지 (전체)

        this.startPage = ((this.pageNo - 1) / this.pageSize) * this.pageSize + 1; // 시작 페이지 (페이징 네비 기준)
        this.endPage = startPage + pageSize - 1; // 끝 페이지 (페이징 네비 기준)

        if (this.endPage > finalPage) { // [마지막 페이지 (페이징 네비 기준) > 마지막 페이지] 보다 큰 경우
            this.endPage = finalPage;
        }

        this.setFirstPageNo(1); // 첫 번째 페이지 번호

        if (this.isNowFirst) {
            this.setPrevPageNo(1); // 이전 페이지 번호
        } else {
            this.setPrevPageNo(((this.pageNo - 1) < 1 ? 1 : (this.pageNo - 1))); // 이전 페이지 번호
        }

        this.setStartPageNo(this.startPage); // 시작 페이지 (페이징 네비 기준)
        this.setEndPageNo(this.endPage); // 끝 페이지 (페이징 네비 기준)

        if (this.isNowFinal) {
            this.setNextPageNo(finalPage); // 다음 페이지 번호
        } else {
            this.setNextPageNo(((this.pageNo + 1) > finalPage ? finalPage : (this.pageNo + 1))); // 다음 페이지 번호
        }

        this.setFinalPageNo(finalPage); // 마지막 페이지 번호
    }
}