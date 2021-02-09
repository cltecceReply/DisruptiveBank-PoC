package com.example.disruptive.postings;

import java.util.UUID;

public class PostingInstructionBatch {
	
	private String client_id;
	private String client_batch_id = UUID.randomUUID().toString();
	private PostingInstruction[] posting_instructions;
	
	public PostingInstructionBatch() {
		super();
	}
	
	public PostingInstructionBatch(String client_id, PostingInstruction[] posting_instructions) {
		super();
		this.client_id = client_id;
		this.posting_instructions = posting_instructions;
	}

	public String getClient_id() {
		return client_id;
	}

	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}

	public String getClient_batch_id() {
		return client_batch_id;
	}

	public void setClient_batch_id(String client_batch_id) {
		this.client_batch_id = client_batch_id;
	}

	public PostingInstruction[] getPosting_instructions() {
		return posting_instructions;
	}

	public void setPosting_instructions(PostingInstruction[] posting_instructions) {
		this.posting_instructions = posting_instructions;
	}
}
