package org.example.dto;

public class CommentRequestDto {
    private String content;
    private String author;
    private String password;

    public CommentRequestDto() {}
    public CommentRequestDto(String content, String author, String password) {
        this.content = content;
        this.author = author;
        this.password = password;
    }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}


