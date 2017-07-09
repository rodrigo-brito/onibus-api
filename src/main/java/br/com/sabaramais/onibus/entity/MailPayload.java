package br.com.sabaramais.onibus.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MailPayload{		
    @JsonProperty("name")
    private String name;
    @JsonProperty("email")
    private String email;
    @JsonProperty("message")
    private String message;
    
    public MailPayload(){}

    @JsonCreator
    public MailPayload(@JsonProperty("name") String name,
    		@JsonProperty("email") String email,
    		@JsonProperty(value="message", required = true) String message) {
        this.name = name;
        this.email = email;
        this.message = message;
    }
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}