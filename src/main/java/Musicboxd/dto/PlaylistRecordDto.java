package Musicboxd.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record PlaylistRecordDto(@NotNull List<String> userPlaylist,@NotBlank String playlistName) {
}
