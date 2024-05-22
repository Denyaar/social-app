/**
 * Created by tendaimupezeni for social-app
 * Date: 5/13/24
 * Time: 11:11 AM
 */

package com.denyaar.socialapp.repository;

import com.denyaar.socialapp.model.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {
}
