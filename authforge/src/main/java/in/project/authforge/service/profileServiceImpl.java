package in.project.authforge.service;

import in.project.authforge.entity.UserEntity;
import in.project.authforge.io.ProfileRequest;
import in.project.authforge.io.ProfileResponse;
import in.project.authforge.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class profileServiceImpl implements profileService {

    private final UserRepository repo;

    @Override
    public ProfileResponse createProfile(ProfileRequest request) {
        UserEntity newProfile = convertToUserEntity(request);
        if(!repo.existsByEmail(request.getEmail())){
            newProfile = repo.save(newProfile);
            return convertToProfileResponse(newProfile);
        }
        throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already exists!");
    }

    private ProfileResponse convertToProfileResponse(UserEntity newProfile) {
        return ProfileResponse.builder()
                .name(newProfile.getName())
                .email(newProfile.getEmail())
                .userId(newProfile.getUserId())
                .isAccountVerified(newProfile.getIsAccountVerified())
                .build();
    }

    private UserEntity convertToUserEntity(ProfileRequest request) {
        return UserEntity.builder()
                .email(request.getEmail())
                .userId(UUID.randomUUID().toString())
                .name(request.getName())
                .password(request.getPassword())
                .isAccountVerified(false)
                .resetOtp(null)
                .resetOtpExpireAt(0L)
                .verifyOtp(null)
                .verifyOtpExpireAt(0L)
                .build();
    }
}
