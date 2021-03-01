package com.FullStack.profile.repository;



import com.FullStack.profile.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Instruct Spring Boot that this is the Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
