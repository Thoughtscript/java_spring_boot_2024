# Spring Boot 2024

[![](https://img.shields.io/badge/Spring%20Boot-3.5.0-green.svg)](https://spring.io/projects/spring-boot)
[![](https://img.shields.io/badge/Gradle-7.5.1-darkslategray.svg)](https://gradle.org/)
[![](https://img.shields.io/badge/Maven-3.9.9-white.svg)](https://maven.apache.org/download.cgi)
[![](https://img.shields.io/badge/Docker-blue.svg)](https://www.docker.com/) 
[![](https://img.shields.io/badge/Postgres-16.2-lightblue.svg)](https://hub.docker.com/_/postgres)

## Use

### Docker Compose

```bash
docker-compose up

# If using Docker Compose Engine V2:
docker compose up
```

### From Source

Maven:
```bash
mvn clean
mvn install
mvn spring-boot:run
```

Gradle:
```bash
./gradlew clean
./gradlew build
./gradlew run
```

SSL:
```bash
keytool -genkey \
  -alias bootexample \
  -keystore bootexample.p12 \
  -storetype PKCS12 \
  -keyalg RSA \
  -storepass af3DF*34afefwefehu \
  -validity 730 \
  -keysize 4096
```

### Default Credentials

> Some default credentials are supplied (to simplify spinning up the example). These are "dummy" credentials (although valid) and aren't or shouldn't be used in any live or PRODUCTION deployment. (In a real-world enterprise app, such credentials would be stored in a service like AWS KMS and be made available or injected during the build.)

1. [springboot/src/main/resources/application.yml](springboot/src/main/resources/application.yml)
2. [springboot/src/main/java/io/thoughtscript/bootexample/config/SecurityConfiguration.java](springboot/src/main/java/io/thoughtscript/bootexample/config/SecurityConfiguration.java)
    * `user` and `password` are the default Spring Security credentials. Use them to log in and call the API as needed.
3. [postgresql/init_sql.sql](postgresql/init_sql.sql)

### Comments

1. Uses Hikari [Connection Pooling](/springboot/src/main/resources/application.yml#L35) and postgres [Max Connections](docker-compose.yml#L6)
2. Uses `@EnableCaching` through [Spring Cache](springboot/src/main/java/io/thoughtscript/bootexample/config/CacheConfiguration.java#L7)
3. Uses Virtual Threads through [application.yml](springboot/src/main/resources/application.yml#L39)
4. Uses Hibernate `@Cacheable` within the Entity Framework [domain](springboot/src/main/java/io/thoughtscript/bootexample/domain/ManyToManyRelation.java#L20)
5. Uses `@Transactional(readOnly = true)` on [Services](springboot/src/main/java/io/thoughtscript/bootexample/services/ManyToManyRelationService.java#L14)

## API

Endpoint testing is supplied through `bash`:

```bash
bash test_curl.sh
```

### Get All Examples

https://localhost:8080/api/example/all

```JSON
[
    {
        "id": 1,
        "name": "aa",
        "oneToOneRelation": {
            "id": 1,
            "name": "a"
        },
        "oneToManyRelations": [
            {
                "id": 1,
                "name": "aaa",
                "examplefk": 1
            },
            {
                "id": 2,
                "name": "bbb",
                "examplefk": 1
            }
        ],
        "manyonerelationfk": 1,
        "manyToManyRelations": [
            {
                "id": 1,
                "name": "aaaaa"
            },
            {
                "id": 2,
                "name": "bbbbb"
            }
        ]
    },
    {
        "id": 2,
        "name": "bb",
        "oneToOneRelation": {
            "id": 2,
            "name": "b"
        },
        "oneToManyRelations": [
            {
                "id": 3,
                "name": "ccc",
                "examplefk": 2
            },
            {
                "id": 4,
                "name": "ddd",
                "examplefk": 2
            }
        ],
        "manyonerelationfk": 2,
        "manyToManyRelations": []
    },
    {
        "id": 3,
        "name": "cc",
        "oneToOneRelation": {
            "id": 3,
            "name": "c"
        },
        "oneToManyRelations": [
            {
                "id": 5,
                "name": "aaa",
                "examplefk": 3
            },
            {
                "id": 6,
                "name": "bbb",
                "examplefk": 3
            }
        ],
        "manyonerelationfk": 3,
        "manyToManyRelations": []
    },
    {
        "id": 4,
        "name": "dd",
        "oneToOneRelation": {
            "id": 4,
            "name": "d"
        },
        "oneToManyRelations": [
            {
                "id": 7,
                "name": "ccc",
                "examplefk": 4
            },
            {
                "id": 8,
                "name": "ddd",
                "examplefk": 4
            }
        ],
        "manyonerelationfk": 4,
        "manyToManyRelations": []
    },
    {
        "id": 52,
        "name": "aa",
        "oneToOneRelation": {
            "id": 52,
            "name": "a"
        },
        "oneToManyRelations": [
            {
                "id": 52,
                "name": "aaa",
                "examplefk": 52
            },
            {
                "id": 53,
                "name": "bbb",
                "examplefk": 52
            }
        ],
        "manyonerelationfk": 52,
        "manyToManyRelations": [
            {
                "id": 52,
                "name": "aaaaa"
            },
            {
                "id": 53,
                "name": "bbbbb"
            }
        ]
    },
    {
        "id": 53,
        "name": "bb",
        "oneToOneRelation": {
            "id": 53,
            "name": "b"
        },
        "oneToManyRelations": [
            {
                "id": 54,
                "name": "ccc",
                "examplefk": 53
            },
            {
                "id": 55,
                "name": "ddd",
                "examplefk": 53
            }
        ],
        "manyonerelationfk": 53,
        "manyToManyRelations": []
    },
    {
        "id": 54,
        "name": "cc",
        "oneToOneRelation": {
            "id": 54,
            "name": "c"
        },
        "oneToManyRelations": [
            {
                "id": 56,
                "name": "aaa",
                "examplefk": 54
            },
            {
                "id": 57,
                "name": "bbb",
                "examplefk": 54
            }
        ],
        "manyonerelationfk": 54,
        "manyToManyRelations": []
    },
    {
        "id": 55,
        "name": "dd",
        "oneToOneRelation": {
            "id": 55,
            "name": "d"
        },
        "oneToManyRelations": [
            {
                "id": 58,
                "name": "ccc",
                "examplefk": 55
            },
            {
                "id": 59,
                "name": "ddd",
                "examplefk": 55
            }
        ],
        "manyonerelationfk": 55,
        "manyToManyRelations": []
    }
]
```

### Get All Many To Many Relations

https://localhost:8080/api/relations/many/many/all

Suppressed `List<Example>` field.

```JSON
[
    {
        "id": 1,
        "name": "aaaaa"
    },
    {
        "id": 2,
        "name": "bbbbb"
    },
    {
        "id": 3,
        "name": "ccccc"
    },
    {
        "id": 4,
        "name": "ddddd"
    },
    {
        "id": 52,
        "name": "aaaaa"
    },
    {
        "id": 53,
        "name": "bbbbb"
    },
    {
        "id": 54,
        "name": "ccccc"
    },
    {
        "id": 55,
        "name": "ddddd"
    }
]
```

### Get All One To Many Relations

https://localhost:8080/api/relations/one/many/all

```JSON
[
    {
        "id": 1,
        "name": "aaa",
        "examplefk": 1
    },
    {
        "id": 2,
        "name": "bbb",
        "examplefk": 1
    },
    {
        "id": 3,
        "name": "ccc",
        "examplefk": 2
    },
    {
        "id": 4,
        "name": "ddd",
        "examplefk": 2
    },
    {
        "id": 5,
        "name": "aaa",
        "examplefk": 3
    },
    {
        "id": 6,
        "name": "bbb",
        "examplefk": 3
    },
    {
        "id": 7,
        "name": "ccc",
        "examplefk": 4
    },
    {
        "id": 8,
        "name": "ddd",
        "examplefk": 4
    },
    {
        "id": 52,
        "name": "aaa",
        "examplefk": 52
    },
    {
        "id": 53,
        "name": "bbb",
        "examplefk": 52
    },
    {
        "id": 54,
        "name": "ccc",
        "examplefk": 53
    },
    {
        "id": 55,
        "name": "ddd",
        "examplefk": 53
    },
    {
        "id": 56,
        "name": "aaa",
        "examplefk": 54
    },
    {
        "id": 57,
        "name": "bbb",
        "examplefk": 54
    },
    {
        "id": 58,
        "name": "ccc",
        "examplefk": 55
    },
    {
        "id": 59,
        "name": "ddd",
        "examplefk": 55
    }
]
````

### Get All One To One Relations

https://localhost:8080/api/relations/one/one/all

```JSON
[
    {
        "id": 1,
        "name": "a"
    },
    {
        "id": 2,
        "name": "b"
    },
    {
        "id": 3,
        "name": "c"
    },
    {
        "id": 4,
        "name": "d"
    },
    {
        "id": 52,
        "name": "a"
    },
    {
        "id": 53,
        "name": "b"
    },
    {
        "id": 54,
        "name": "c"
    },
    {
        "id": 55,
        "name": "d"
    }
]
```

### Get All Many To One Relations

https://localhost:8080/api/relations/many/one/all

```JSON
[
    {
        "id": 1,
        "name": "aaaa",
        "example": {
            "id": 1,
            "name": "aa",
            "oneToOneRelation": {
                "id": 1,
                "name": "a"
            },
            "oneToManyRelations": [
                {
                    "id": 1,
                    "name": "aaa",
                    "examplefk": 1
                },
                {
                    "id": 2,
                    "name": "bbb",
                    "examplefk": 1
                }
            ],
            "manyonerelationfk": 1,
            "manyToManyRelations": [
                {
                    "id": 1,
                    "name": "aaaaa"
                },
                {
                    "id": 2,
                    "name": "bbbbb"
                }
            ]
        }
    },
    {
        "id": 2,
        "name": "bbbb",
        "example": {
            "id": 2,
            "name": "bb",
            "oneToOneRelation": {
                "id": 2,
                "name": "b"
            },
            "oneToManyRelations": [
                {
                    "id": 3,
                    "name": "ccc",
                    "examplefk": 2
                },
                {
                    "id": 4,
                    "name": "ddd",
                    "examplefk": 2
                }
            ],
            "manyonerelationfk": 2,
            "manyToManyRelations": []
        }
    },
    {
        "id": 3,
        "name": "cccc",
        "example": {
            "id": 3,
            "name": "cc",
            "oneToOneRelation": {
                "id": 3,
                "name": "c"
            },
            "oneToManyRelations": [
                {
                    "id": 5,
                    "name": "aaa",
                    "examplefk": 3
                },
                {
                    "id": 6,
                    "name": "bbb",
                    "examplefk": 3
                }
            ],
            "manyonerelationfk": 3,
            "manyToManyRelations": []
        }
    },
    {
        "id": 4,
        "name": "dddd",
        "example": {
            "id": 4,
            "name": "dd",
            "oneToOneRelation": {
                "id": 4,
                "name": "d"
            },
            "oneToManyRelations": [
                {
                    "id": 7,
                    "name": "ccc",
                    "examplefk": 4
                },
                {
                    "id": 8,
                    "name": "ddd",
                    "examplefk": 4
                }
            ],
            "manyonerelationfk": 4,
            "manyToManyRelations": []
        }
    },
    {
        "id": 52,
        "name": "aaaa",
        "example": {
            "id": 52,
            "name": "aa",
            "oneToOneRelation": {
                "id": 52,
                "name": "a"
            },
            "oneToManyRelations": [
                {
                    "id": 52,
                    "name": "aaa",
                    "examplefk": 52
                },
                {
                    "id": 53,
                    "name": "bbb",
                    "examplefk": 52
                }
            ],
            "manyonerelationfk": 52,
            "manyToManyRelations": [
                {
                    "id": 52,
                    "name": "aaaaa"
                },
                {
                    "id": 53,
                    "name": "bbbbb"
                }
            ]
        }
    },
    {
        "id": 53,
        "name": "bbbb",
        "example": {
            "id": 53,
            "name": "bb",
            "oneToOneRelation": {
                "id": 53,
                "name": "b"
            },
            "oneToManyRelations": [
                {
                    "id": 54,
                    "name": "ccc",
                    "examplefk": 53
                },
                {
                    "id": 55,
                    "name": "ddd",
                    "examplefk": 53
                }
            ],
            "manyonerelationfk": 53,
            "manyToManyRelations": []
        }
    },
    {
        "id": 54,
        "name": "cccc",
        "example": {
            "id": 54,
            "name": "cc",
            "oneToOneRelation": {
                "id": 54,
                "name": "c"
            },
            "oneToManyRelations": [
                {
                    "id": 56,
                    "name": "aaa",
                    "examplefk": 54
                },
                {
                    "id": 57,
                    "name": "bbb",
                    "examplefk": 54
                }
            ],
            "manyonerelationfk": 54,
            "manyToManyRelations": []
        }
    },
    {
        "id": 55,
        "name": "dddd",
        "example": {
            "id": 55,
            "name": "dd",
            "oneToOneRelation": {
                "id": 55,
                "name": "d"
            },
            "oneToManyRelations": [
                {
                    "id": 58,
                    "name": "ccc",
                    "examplefk": 55
                },
                {
                    "id": 59,
                    "name": "ddd",
                    "examplefk": 55
                }
            ],
            "manyonerelationfk": 55,
            "manyToManyRelations": []
        }
    }
]
```

## Resources and Links

1. https://www.codejava.net/frameworks/spring-boot/connect-to-postgresql-database-examples
2. https://www.baeldung.com/spring-boot-security-autoconfiguration
3. https://www.baeldung.com/spring-postconstruct-predestroy
4. https://dev.to/jhonifaber/hibernate-onetoone-onetomany-manytoone-and-manytomany-8ba
5. https://stackoverflow.com/questions/56424524/getting-infinite-json-response-when-using-many-to-one-mapping-in-spring
6. https://www.baeldung.com/jackson-bidirectional-relationships-and-infinite-recursion
7. https://www.baeldung.com/hibernate-one-to-many
8. https://www.baeldung.com/spring-boot-hikari
9. https://docs.spring.io/spring-boot/reference/io/caching.html#io.caching.provider.simple
10. https://medium.com/@avi.singh.iit01/optimizing-performance-with-spring-data-jpa-85583362cf3a
11. https://thorben-janssen.com/hibernate-performance-tuning/
12. https://www.danvega.dev/blog/jdk-24-virtual-threads-without-pinning