# Gimnasio Athlon backend
* Crear la base de datos y unilar con el backend 
* Tendremos unos modulos que contendran las entidades, repositorio, controloradores en la API 
RES 
-Hacemos la conexion con la base de datos entre MYSQL y el backend dentro de la carpeta resources 
y en el archivo application.properties con las siguientes lineas 

``` MYSQL 
spring.application.name=Gimnasio_Athlon
spring.datasource.url=jdbc:mysql://localhost:3306/Gimnasio_Athlon?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=cuervo
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
spring.jpa.hibernate.ddl-auto=update
```
*   **Modulo : Entidades**
------
    ## Entidad Login
``` JAVA 
 . Usaremos las siguientes anotaciones 
    @Entity
    @Table (name = "Login")
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
 . Con los siguientes atributos para la entidad login
    public class Login {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long usuarioID;
        
        private String nombreusuario;
        private String password;
        private String rol;

    }

```

*   **Modulo : Controlador**
------
    ## Controlador de login
```JAVA
    @RestController
    @RequestMapping("/api/logins")
    public class LoginController {

        @Autowired
        private LoginRepositorie loginRepositorie;
        
        /*Obtener todos los logins */
        @GetMapping
        public List <Login> obtener_todos_logins() {
            return loginRepositorie.findAll();
        }

        /*Obtener logins por medio de la ID */
        @GetMapping ("/{usuarioID}")
        public Login obtener_login_por_ID(@PathVariable("usuarioID") Long usuarioID ) {
            return loginRepositorie.findById(usuarioID).orElse(null);
        }

        /*Crear un login  */
        @PostMapping()
        public Login crear_login(@RequestBody Login  login) {
            return loginRepositorie.save(login);
        }

        /*Actualizar login */
        @PutMapping("/{usuarioID}")
        public Login actualizar_login(@PathVariable ("usuarioID") Long usuarioID, @RequestBody Login  login) {
            login.setUsuarioID(usuarioID);
            return loginRepositorie.save(login);  
        }
        
        /*Eliminar Login */
        @DeleteMapping("/{usuarioID}")
        public void eliminar_login(@PathVariable("usuarioID") Long login) {
            loginRepositorie.deleteById(login);
        }
    }
```
*   **Modulo : Repositorio**
------
    ## Repositorio Login
``` JAVA
. Tendremos un repositorio que sera base entre el controlador, el modelo y
la informacion que utilicemos 
    public interface LoginRepositorie  extends JpaRepository <Login, Long> {

    }

 ```
*   **Modulo : Config**
------
    ## corsConfig
``` JAVA
. es el uso compartido de recursos entre origenes 
    @Configuration
    @EnableWebMvc
    public class corsConfig  implements WebMvcConfigurer{
        
        @Override
        public void addCorsMappings(CorsRegistry registry){
            registry.addMapping("/*")
            .allowedOrigins("*")//Escribir la url del proyecto front a conectar
            .allowedMethods("*")//podemos especificar los metodos a permitir desfde el front
            .allowCredentials(true);//para que permita las credenciales
        }
    }
```


