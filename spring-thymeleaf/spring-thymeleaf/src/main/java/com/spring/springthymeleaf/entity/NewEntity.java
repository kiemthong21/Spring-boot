package com.spring.springthymeleaf.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "news")
public class NewEntity extends BaseEntity {
    @Column
    private String title;
    @Column
    private String thumbnail;
    @Column(name = "shortdescription")
    private String shortDescrition;
    @Column
    private String content;

    @ManyToOne
    @JoinColumn(name = "category_id")

    private CategoryEntity category;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getShortDescrition() {
        return shortDescrition;
    }

    public void setShortDescrition(String shortDescrition) {
        this.shortDescrition = shortDescrition;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

}
