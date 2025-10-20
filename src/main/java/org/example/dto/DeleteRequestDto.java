package org.example.dto;

public class DeleteRequestDto {
    private String password;

    public DeleteRequestDto() {}
    public DeleteRequestDto(String password) { this.password = password; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}


