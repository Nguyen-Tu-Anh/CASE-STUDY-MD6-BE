package com.codegym.socialbook_be.user_pack.model;

import com.codegym.socialbook_be.security_pack.model.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "username"
        }),
        @UniqueConstraint(columnNames = {
                "email"
        })
})
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 3, max = 50)
    private String name;
    @NotBlank
    @Size(min = 3,max = 50)
    private String username;
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    @JsonIgnore
    @NotBlank
    @Size(min = 6,max = 100)
    private String password;
    @Lob
    private String avatar;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    Set<Role> roles = new HashSet<>();


    @NotBlank
    private String phoneNumber;
    @Min(18)
    private int age;
    private String gender;
    private String dateOfBirth;
    private String city;
    private String nationality;
    private int status;
    private String description;
    private String requirement;
    private Date startDate;
    private Date vipDate;
    private String facebookUrl;
    private Long countOfDate;
    private String identify;


    // it nhat 3 anh
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Image> images;

    // Có 3 roles : Customer,Admin và nhà cung cấp dịch vụ (NCCDV)
    @OneToOne
    private Role role;

    //Nhung thuoc tinh ben duoi la cua ben cung cap dich vu
    //ko bat buoc nhap luc dang ky la customer
    private double price;

    //List dich vu
    @ManyToMany
    private Set<ServiceOfProvider> serviceOfProviders;

    //Danh gia cua khach hang
    @ManyToMany
    private Set<Review> reviews;
    public Users() {
    }

    public Users(Long id, String name, String username, String email, String password, String avatar, Set<Role> roles) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
        this.roles = roles;
    }

    public Users(   @NotBlank
                    @Size(min = 3, max = 50) String name,
                    @NotBlank
                    @Size(min = 3,max = 50) String username,
                    @Size(max = 50)
                    @Email String email,
                    String avatar,
                    @NotBlank
                    @Size(min = 6,max = 100)String encode) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.avatar = avatar;
        this.password = encode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getVipDate() {
        return vipDate;
    }

    public void setVipDate(Date vipDate) {
        this.vipDate = vipDate;
    }

    public String getFacebookUrl() {
        return facebookUrl;
    }

    public void setFacebookUrl(String facebookUrl) {
        this.facebookUrl = facebookUrl;
    }

    public Long getCountOfDate() {
        return countOfDate;
    }

    public void setCountOfDate(Long countOfDate) {
        this.countOfDate = countOfDate;
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<ServiceOfProvider> getServiceOfProviders() {
        return serviceOfProviders;
    }

    public void setServiceOfProviders(Set<ServiceOfProvider> serviceOfProviders) {
        this.serviceOfProviders = serviceOfProviders;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }
}
