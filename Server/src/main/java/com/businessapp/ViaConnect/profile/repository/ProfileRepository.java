package com.businessapp.ViaConnect.profile.repository;

import com.businessapp.ViaConnect.profile.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Instruct Spring Boot that this is the Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
