package com.bookshop.page;

import com.bookshop.dto.RequestPageInfo;

public class PageInfoForSQL {
		// 开始行
		private int startRow;
		// 终止行
		private int pageSize;
		
		private boolean allPage;

		public int getStartRow() {
			return startRow;
		}

		public void setStartRow(int startRow) {
			this.startRow = startRow;
		}

		public int getPageSize() {
			return pageSize;
		}

		public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
		}
		
		public boolean isAllPage() {
			return allPage;
		}

		public void setAllPage(boolean allPage) {
			this.allPage = allPage;
		}
		
		public PageInfoForSQL() {
			this.setAllPage(true);
		}
		
		public PageInfoForSQL(int startRow, int pageSize) {
			this.setStartRow(startRow);
			this.setPageSize(pageSize);
			this.setAllPage(false);
		}

		public PageInfoForSQL(RequestPageInfo page) {
			this.startRow = (page.getPageNumber() - 1) * page.getPageSize();
	        this.pageSize = page.getPageSize();
	        this.setAllPage(false);
		}
}
