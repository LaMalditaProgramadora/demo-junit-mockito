package com.example.demojunitmockito;

import com.example.demojunitmockito.repository.ExampleRepository;
import com.example.demojunitmockito.service.ExampleService;
import com.example.demojunitmockito.util.ExampleUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoJunitMockitoApplicationTests {

    @Mock
    private ExampleRepository repository;

    @InjectMocks
    private ExampleService service;

    @BeforeEach
    public void init() {
        when(repository.getName()).thenReturn("Tommy Oliver");
        when(repository.getAlias()).thenReturn("Lord Drakkon");

        MockedStatic<ExampleUtil> util = mockStatic(ExampleUtil.class);
        util.when(() -> ExampleUtil.getFirstSentence()).thenReturn("Hello, my name is ");
        util.when(() -> ExampleUtil.getLastSentence()).thenReturn(" and I'm ");
    }

    @Test
    public void testPresentation1() {
        String presentation = service.getPresentation();
        System.out.println(presentation);
        assertEquals("Hola, mi nombre es Jimena Ruiz y soy LaMalditaProgramadora", presentation);
    }

    @Test
    public void testPresentation2() {
        String presentation = service.getPresentation();
        System.out.println(presentation);
        assertEquals("Hola, mi nombre es Tommy Oliver y soy Lord Drakkon", presentation);
    }

    @Test
    public void testPresentation3() {
        String presentation = service.getPresentation();
        System.out.println(presentation);
        assertEquals("Hello, my name is Tommy Oliver and I'm Lord Drakkon", presentation);
    }

}
