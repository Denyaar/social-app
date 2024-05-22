/**
 * Created by tendaimupezeni for social-app
 * Date: 5/13/24
 * Time: 10:58 AM
 */

package com.denyaar.socialapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String user;

    private String content;

    @Column(name = "post-likes")
    private int like;

    @Column(name = "post-unlikes")
    private int unlike;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
            @JoinColumn(name = "postId")
    List<Comment> comments = new ArrayList<>();
}
