package work.board;


import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	
	private int num;
	private String mbrid;
	private String title;
	private String content;
	private Date regDate;
	private int readcount;
	private String ip;
	private int reRef;  // 글 그룹 번호
	private int reLev;  // 글 들여쓰기 레벨
	private int reSeq;  // 글 그룹 내에서의 순번
}