package kr.co.pr.board.model;

import java.sql.Timestamp;

public class BoardVO {

		private int boardID;
		private String writer;
		private String title;
		private String content;
		private Timestamp regDate;
		private int hit;
		
		public BoardVO() {}

		public BoardVO(int boardID, String writer, String title, String content, Timestamp regDate, int hit) {
			super();
			this.boardID = boardID;
			this.writer = writer;
			this.title = title;
			this.content = content;
			this.regDate = regDate;
			this.hit = hit;
		}

		public int getBoardID() {
			return boardID;
		}

		public void setBoardID(int boardID) {
			this.boardID = boardID;
		}

		public String getWriter() {
			return writer;
		}

		public void setWriter(String writer) {
			this.writer = writer;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public Timestamp getRegDate() {
			return regDate;
		}

		public void setRegDate(Timestamp regDate) {
			this.regDate = regDate;
		}

		public int getHit() {
			return hit;
		}

		public void setHit(int hit) {
			this.hit = hit;
		}
		
		
}



