package kr.co.pr.board.page;

public class PageVO {
	
	private int page;
	private int countPerPage;
	
	public PageVO() {
		page = 1;
		countPerPage = 10;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getCountPerPage() {
		return countPerPage;
	}

	public void setCountPerPage(int countPerPage) {
		this.countPerPage = countPerPage;
	}

	@Override
	public String toString() {
		return "PageVO [page=" + page + ", countPerPage=" + countPerPage + "]";
	}

	
}
