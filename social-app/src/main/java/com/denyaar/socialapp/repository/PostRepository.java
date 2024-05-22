/**
 * Created by tendaimupezeni for social-app
 * Date: 5/13/24
 * Time: 11:09 AM
 */

package com.denyaar.socialapp.repository;

import com.denyaar.socialapp.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post,Long> {
}
