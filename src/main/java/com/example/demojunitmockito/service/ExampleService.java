package com.example.demojunitmockito.service;

import com.example.demojunitmockito.repository.ExampleRepository;
import com.example.demojunitmockito.util.ExampleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExampleService {

    @Autowired
    private ExampleRepository repository;

    public String getPresentation() {
        return ExampleUtil.getFirstSentence() + repository.getName() +
                ExampleUtil.getLastSentence()+ repository.getAlias();
    }
}
