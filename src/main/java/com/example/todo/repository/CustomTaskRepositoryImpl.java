package com.example.todo.repository;

import com.example.todo.models.TaskEntity;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CustomTaskRepositoryImpl implements CustomTaskRepository {

    private final EntityManager manager;

    @Override
    public List<TaskEntity> getTasks(Boolean all, String substring, Long accountId) {

        StringBuilder jpql = new StringBuilder("from TaskEntity t ");
        List<String> conditions = new ArrayList<>();

        if (Strings.isNotBlank(substring)) {
            conditions.add("t.description like :desc");
        }

        if (!all) {
                conditions.add("t.completed <> true");
        }

        jpql.append("where t.account.id = ").append(accountId);

        if (!conditions.isEmpty()) {
            jpql.append("where ")
                    .append(String.join(" and ", conditions));
        }

        TypedQuery<TaskEntity> typedQuery = manager.createQuery(jpql.toString(), TaskEntity.class);

        if (Strings.isNotBlank(substring)) {
            typedQuery.setParameter("desc","%" + substring + "%");
        }

        return typedQuery.getResultList();
    }
}
