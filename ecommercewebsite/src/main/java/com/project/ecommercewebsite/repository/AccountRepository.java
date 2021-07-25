package com.project.ecommercewebsite.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.ecommercewebsite.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
	Optional<Account> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);

	@Modifying
	@Query(value = "UPDATE public.account SET user_first_name=':user_first_name', user_last_name=':user_last_name', user_phonenumber=':user_phonenumber' WHERE email=':email' returning *", nativeQuery = true)
	Optional<Account> updateAccount(@Param("user_first_name") String user_first_name,
			@Param("user_last_name") String user_last_name, @Param("user_phonenumber") String user_phonenumber,
			@Param("email") String email);

	// update password
	@Modifying
	@Query(value = "UPDATE public.account SET userpassword=':userpassword' WHERE username=':username'", nativeQuery = true)
	void changePassword(@Param("userpassword") String userpassword, @Param("username") String username);

	@Modifying
	@Query(value = "DELETE FROM public.account WHERE email=':email'", nativeQuery = true)
	int delete(@Param("email") int email);
}
