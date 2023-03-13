package com.unicard.usermanagement.service;

import com.unicard.usermanagement.exception.UserAlreadyExistAuthenticationException;
import com.unicard.usermanagement.dto.LocalUser;
import com.unicard.usermanagement.dto.SignUpRequest;
import com.unicard.usermanagement.model.User;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;

import java.util.Map;
import java.util.Optional;

public interface UserService {
    public User registerNewUser(SignUpRequest signUpRequest) throws UserAlreadyExistAuthenticationException;

    User findUserByEmail(String email);

    Optional<User> findUserById(Long id);

    LocalUser processUserRegistration(String registrationId, Map<String, Object> attributes, OidcIdToken idToken, OidcUserInfo userInfo);
}