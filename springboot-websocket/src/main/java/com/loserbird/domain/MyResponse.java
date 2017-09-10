package com.loserbird.domain;

public class MyResponse {
	private String responseMessage;
    public MyResponse(String responseMessage){
        this.responseMessage = responseMessage;
    }
    public String getResponseMessage(){
        return responseMessage;
    }
}
