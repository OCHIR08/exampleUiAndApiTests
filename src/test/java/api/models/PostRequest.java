package api.models;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostRequest {
    private String title;
    private String body;
    private Integer userId;  // Лучше Integer, а не String
}
