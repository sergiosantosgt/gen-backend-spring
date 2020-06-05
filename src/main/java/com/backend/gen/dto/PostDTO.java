package com.backend.gen.dto;

import com.backend.gen.domain.Post;
import com.backend.gen.domain.PostCategoria;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    private Date publication_date;

    private String title;
    private String subtitle;
    private String content;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "post_categoria",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "post_categoria_id")
    )
    private List<PostCategoria> postCategorias = new ArrayList<>();

    public PostDTO() {
    }

    public PostDTO(Post obj) {
        id = obj.getId();
        publication_date = obj.getPublication_date();
        title = obj.getTitle();
        subtitle = obj.getSubtitle();
        content = obj.getContent();
        postCategorias = obj.getPostCategorias();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getPublication_date() {
        return publication_date;
    }

    public void setPublication_date(Date publication_date) {
        this.publication_date = publication_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<PostCategoria> getPostCategorias() {
        return postCategorias;
    }

    public void setPostCategorias(List<PostCategoria> postCategorias) {
        this.postCategorias = postCategorias;
    }
}
