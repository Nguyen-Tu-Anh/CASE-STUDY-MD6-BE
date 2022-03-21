package com.codegym.socialbook.be.user.pack.service;

import com.codegym.socialbook.be.user.pack.dto.request.SearchForm;
import com.codegym.socialbook.be.user.pack.model.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;

public interface IUserService {
    // tìm 12 providers sắp xếp theo ngày gia nhập
    Page<Users> find12ProvidersSortByStartDate(Pageable page);
    //tìm theo id
    Users findById(Long id);
    // lưu
    void save(Users user);
    // lấy 12 provider được nhiều hẹn hò nhất
    Page<Users> find12ProvidersSortByCountOfDate(Pageable page);
    // show toàn bộ user
    Page<Users> showALl(Pageable page);
    // tìm kiếm user
    Page<Users> search(SearchForm searchForm,Pageable page);
    //remove admin
    void removeAdmin(Long id);
    //cho lên thành admin
    void makeAdmin(Long id);
//    List<Users> findListUsersByName(String name);
//    List<Users> findListUsersByAge(int maxAge, int minAge);
//    List<Users> findListUsersByCity(String address);
//    List<Users> findListUsersByGender(String gender);;
}
