package com.account.response;

public class PageResponse {
	
	public enum ResponseStatusEnum {SUCCESS, ERROR, WARNING, NO_ACCESS};
	
	  private ResponseStatusEnum  operationStatus;
	  private String  operationMessage;

}
