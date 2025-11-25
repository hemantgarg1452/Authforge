package in.project.authforge.controller;

import in.project.authforge.io.ProfileRequest;
import in.project.authforge.io.ProfileResponse;
import in.project.authforge.service.profileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2.0")
public class profileController {

    private final profileService service;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ProfileResponse register(@Valid @RequestBody ProfileRequest request){
        // send a welcome email....
        return service.createProfile(request);
    }
}
