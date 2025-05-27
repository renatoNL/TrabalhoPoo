package Musicboxd.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PublicationRecordDto(@NotBlank String title, @NotNull String comment, @NotNull int rating, boolean liked) {
}
