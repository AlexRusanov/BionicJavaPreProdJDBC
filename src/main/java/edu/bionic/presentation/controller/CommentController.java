package edu.bionic.presentation.controller;

import edu.bionic.domain.Comment;
import edu.bionic.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("comments")
public class CommentController {

    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public String addNewComment(@ModelAttribute Comment comment) {
        // validation
        if (comment.getRating() > 5) comment.setRating(5);
        else if (comment.getRating() < 1) comment.setRating(1);

        commentService.createNew(comment);
        return "redirect:/products/" + comment.getProductId();
    }
}
