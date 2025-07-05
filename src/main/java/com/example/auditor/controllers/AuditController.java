package com.example.auditor.controllers;


import com.example.auditor.entities.PostEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")

public class AuditController {

    @Autowired
    private EntityManagerFactory manager;

    @GetMapping("/posts/{postId}")
    public List<PostEntity> getAllPostData(@PathVariable Long postId) {

        AuditReader reader = AuditReaderFactory.get(manager.createEntityManager());
        List<Number> revisions = reader.getRevisions(PostEntity.class,postId);
        return revisions.stream().map(
                number -> reader.find(PostEntity.class,postId,number)
        ).toList();
    }

}
