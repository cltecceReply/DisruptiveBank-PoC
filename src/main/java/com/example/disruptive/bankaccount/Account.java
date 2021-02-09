package com.example.disruptive.bankaccount;

import java.util.Map;
import java.util.UUID;

public class Account {
	
	private String id = UUID.randomUUID().toString();
	private String product_id;
	private String[] permitted_denominations;
	private String status;
	private String[] stakeholder_ids;
	private Map<String, String> instance_param_vals;
	
	public Account() {
		super();
	}
	
	public Account(String product_id, String[] permitted_denominations, String status, String[] stakeholder_ids, Map<String, String> instance_param_vals) {
		super();
		this.product_id = product_id;
		this.permitted_denominations = permitted_denominations;
		this.status = status;
		this.stakeholder_ids = stakeholder_ids;
		this.instance_param_vals = instance_param_vals;
	}
	
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String[] getPermitted_denominations() {
		return permitted_denominations;
	}
	public void setPermitted_denominations(String[] permitted_denominations) {
		this.permitted_denominations = permitted_denominations;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String[] getStakeholder_ids() {
		return stakeholder_ids;
	}
	public void setStakeholder_ids(String[] stakeholder_ids) {
		this.stakeholder_ids = stakeholder_ids;
	}
	public Map<String, String> getInstance_param_vals() {
		return instance_param_vals;
	}
	public void setInstance_param_vals(Map<String, String> instance_param_vals) {
		this.instance_param_vals = instance_param_vals;
	}
	
	public String getId() {
		return this.id;
	}
	
	
}
