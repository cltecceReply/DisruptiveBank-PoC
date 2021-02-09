package com.example.disruptive.postings;

import java.util.UUID;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class PostingRequest {
		
	private String request_id = UUID.randomUUID().toString();
	private PostingInstructionBatch posting_instruction_batch;
	
	public PostingRequest(PostingInstructionBatch posting_instruction_batch) {
		super();
		
		this.posting_instruction_batch = posting_instruction_batch;
	}
	
	public PostingRequest(String request_id, PostingInstructionBatch posting_instruction_batch) {
		super();
		this.request_id = request_id;
		this.posting_instruction_batch = posting_instruction_batch;
	}
	
	public String getRequest_id() {
		return request_id;
	}
	public void setRequest_id(String request_id) {
		this.request_id = request_id;
	}
	public PostingInstructionBatch getPosting_instruction_batch() {
		return posting_instruction_batch;
	}
	public void setPosting_instruction_batch(PostingInstructionBatch posting_instruction_batch) {
		this.posting_instruction_batch = posting_instruction_batch;
	}
}
