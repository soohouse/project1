package kr.co.pr.board.page;

public class PageCreator {
	
	private PageVO paging;
	private int totalCount;
	private int beginPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	
	private final int displayBtn = 10;
	
	private void calPage() {
		
		this.endPage = (int) Math.ceil(paging.getPage()/(double)this.displayBtn) * this.displayBtn;
		
		//this.beginPage = (int) Math.floor(paging.getPage() / (double) paging.getCountPerPage()) * paging.getCountPerPage() +_1;
		
		beginPage = (endPage - displayBtn) +1;
		
		prev = (beginPage == 1) ? false : true;
		
		next = (totalCount <= (endPage * paging.getCountPerPage())) ? false : true;
		
		if(!next) {
			endPage = (int) (Math.ceil(totalCount)/(double) paging.getCountPerPage());
		}
	}

	public PageVO getPaging() {
		return paging;
	}
	
	public void setPaging(PageVO paging) {
		this.paging = paging;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getBeginPage() {
		return beginPage;
	}

	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "PageCreator [paging=" + paging + ", totalCount=" + totalCount + ", beginPage=" + beginPage
				+ ", endPage=" + endPage + ", prev=" + prev + ", next=" + next + ", displayBtn=" + displayBtn + "]";
	}

	
	
}
