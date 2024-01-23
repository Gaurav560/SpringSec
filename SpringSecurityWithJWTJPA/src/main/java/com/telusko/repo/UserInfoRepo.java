package com.telusko.repo;

import com.telusko.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepo extends JpaRepository<UserInfo,Integer> {
  Optional<UserInfo> findByName(String userName);
}
