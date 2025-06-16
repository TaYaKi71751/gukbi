package com.human.service;

import java.util.List;

import com.human.dto.ReplyDto;
import com.human.vo.PageMaker;

public interface ReplyService {
	public void boardReplyCreate(ReplyDto dto) throws Exception;
	public void reReplyCreate(ReplyDto dto) throws Exception;
	public void boardReplyStep(int rGroup, int rStep) throws Exception;
	
	public void boardReplyUpdate(ReplyDto dto) throws Exception;
	
	public void boardReplyDelete(int rId) throws Exception;
	
	public List<ReplyDto> replyList(int bId, PageMaker pm) throws Exception;
	public int replyCount(int bId) throws Exception;
	
	public ReplyDto readParent(int rId) throws Exception;
}
