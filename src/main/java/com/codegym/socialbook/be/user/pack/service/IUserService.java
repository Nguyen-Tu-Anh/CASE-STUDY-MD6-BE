package com.codegym.socialbook.be.user.pack.service;

import com.codegym.socialbook.be.user.pack.model.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService {
    // tìm 12 providers sắp xếp theo ngày gia nhập
    Page<Users> find12ProvidersSortByStartDate(Pageable page);
    Users findById(Long id);
    void save(Users user);
}
