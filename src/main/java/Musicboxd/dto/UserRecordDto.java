package Musicboxd.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRecordDto(@NotBlank String name, @NotBlank String bio, @NotNull String email, @NotNull String gender, @NotNull String password) {
}
