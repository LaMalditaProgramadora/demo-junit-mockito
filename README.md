Frase original: Hola, mi nombre es Jimena Ruiz y soy LaMalditaProgramadora

Mockeando Repository (Autowired)
---------------------------------
Se debe obtener: Hola, mi nombre es Tommy Oliver y soy Lord Drakkon

1. Mockeamos el repository

      @Mock
      private ExampleRepository repository;

2. Inyectamos el mock en el servicio

      @InjectMocks
      private ExampleService service;

3. Creamos un método para ejecutar antes de los test. Allí mockeamos los métodos que queremos.

        @BeforeEach
        public void init() {
            when(repository.getName()).thenReturn("Tommy Oliver");
            when(repository.getAlias()).thenReturn("Lord Drakkon");
        }

Mockeando métodos estáticos (Util)
---------------------------------
Se debe obtener: Hello, my name is Tommy Oliver and I'm Lord Drakkon

1. Mockear la clase en el método a ejecutar antes de los tests (init)

        MockedStatic<ExampleUtil> util = mockStatic(ExampleUtil.class);
        util.when(() -> ExampleUtil.getFirstSentence()).thenReturn("Hello, my name is ");
        util.when(() -> ExampleUtil.getLastSentence()).thenReturn(" and I'm ");

2. Crear dentro de la carpeta test la siguiente estructura
	test > resources > mockito-extensions
	y aquí crear el archivo org.mockito.plugins.MockMaker

3. El archivo org.mockito.plugins.MockMaker debe contener: 
mock-maker-inline
