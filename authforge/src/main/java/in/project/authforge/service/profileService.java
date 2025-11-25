package in.project.authforge.service;

import in.project.authforge.io.ProfileRequest;
import in.project.authforge.io.ProfileResponse;

public interface profileService {
    ProfileResponse createProfile(ProfileRequest request);
}
