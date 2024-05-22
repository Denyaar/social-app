/**
 * Created by tendaimupezeni for social-app
 * Date: 5/13/24
 * Time: 10:59 AM
 */

package com.denyaar.socialapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private String user;
    private String content;

}
