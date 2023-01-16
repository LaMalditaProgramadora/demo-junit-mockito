package com.example.demojunitmockito.repository;

import org.springframework.stereotype.Repository;

@Repository
public class ExampleRepository {

    public String getName() {
        return "Jimena Ruiz";
    }

    public String getAlias() {
        return "LaMalditaProgramadora";
    }
}
