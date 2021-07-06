package ca.nsidetech.tuumde.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;

    private String description;

    @OneToMany(
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    private Set<Category> subCategories;

    @OneToMany
    private Set<Gig> gigs;

    private boolean isSubCategory;

    @CreationTimestamp
    private Date creationDate;

    @UpdateTimestamp
    private Date modificationDate;

    public Category() {
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Category> getSubCategories() {
        return subCategories;
    }

    public Set<Gig> getGigs() {
        return gigs;
    }

    public void setGigs(Set<Gig> gigs) {
        this.gigs = gigs;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public boolean isSubCategory() {
        return isSubCategory;
    }

    public void setSubCategory(boolean subCategory) {
        isSubCategory = subCategory;
    }

//    @ManyToOne(optional = false)
//    private Category categories;
//
//    public Category getCategories() {
//        return categories;
//    }
//
//    public void setCategories(Category categories) {
//        this.categories = categories;
//    }
}
