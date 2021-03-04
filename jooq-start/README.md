# [입문] Spring Boot Jooq에 대해 알아보자  

필자는 JPA로 개발할때 QueryDSL-jpa를 활용한 Type-Safe 한 SQL 작성을 굉장히 선호합니다.    
사람이 실수 할 수 있는 여지를 미연에 방지할 수 있기 때문입니다.     

<br>

하지만 회사에서 JPA가 아닌 프로젝트를 맡게 되었고 이로인해 **native sql** 에서도  
이런 type-safe한 쿼리를 작성할 수 없을까? 라는 물음으로 jooq를 찾아보게 되었습니다.  

<br>

~~(아 mybatis 쓰기 싫어요 ㅜㅜ)~~  

물론 사실 [QueryDSL](https://github.com/querydsl/querydsl) 도 querydsl-sql이라는 형태로  
native SQL을 지원하지만 주변에서 jooq의 평이 좋아 직업 한번 입문 해보기로 하였습니다.   

<br>

자세한 코드는 [[여기]](https://github.com/SightStudio/blog-code/tree/develop/jooq-start) 서 확인할 수 있습니다.
DB 스키마는 공식문서에서 제공하는 스키마를 살짝 각색하여 진행하였습니다. 

(링크의 **src/main/resources** 폴더 참고)

----

## 1. 설치

jooq는 문서가 굉장히 잘되어있는 편입니다. 심지어 ```spring-boot-start-jooq``` 까지   
제공해주기 때문에 아래와 같이 dependency를 입력받고 db 설정값만 입력하면 작동합니다.  
<br>   
```
implementation 'org.springframework.boot:spring-boot-starter-jooq'
```

jooq 또한 queryDSL과 같이 자바로 만들어진 전용 DSL을 생성합니다.    
jooq 측에서는 DSL을 생성하지 않고도 쓸 수 있는 방법을 제공하지만, 그러면 jooq를 쓸 이유가 없습니다.   

<br>

code generation 방법은 크게 

<br>

1) xml 
2) liquibase (또는 flyway) 기반의 code generation
3) JPA 엔티티 기반
4) 직접 데이터베이스 스캔

<br>
으로 나뉘며, 예제는 4번 방식으로 진행하였습니다.

자세한 설정은 코드나  [[공식 문서]](https://www.jooq.org/doc/3.14/manual) 를 보면 좋을듯하네요.
<br>

## 2. 예시 - 조회
### native sql
```sql
SELECT * 
FROM author
WHERE id = $id;
```

<br>

### jooq
```java
@Repository
@RequiredArgsConstructor
public class AuthorRepository {

    private final DSLContext dsl;

    public AuthorDto getAuthorById(Integer id) {
        return dsl.select()
                .from(AUTHOR)
                .where(AUTHOR.ID.eq(id))
                .fetchOneInto(AuthorDto.class);
    }
}
```
<br>

조회한 코드는 다음과 위와같이 fetch~into 함수를 통해 dto랑 매핑시킬 수 있습니다.
다음과 같이 자바 기반 DSL 을 사용하여 얻는 이점 중 제일 중요한건 다음과 같습니다.

<br>

**문자열 기반이 아니기 때문에 개발자가 실수로 오타를 치는 경우 원천 차단**
(기존 방식은 SQL 에러를 확인하는 순간이 직접 실행하는 시점)
  
<br>

## 3. 테스트 코드

<br>

jooq는 jdbcTest와 유사하게 ```@JooqTest``` 형태의 테스트 에너테이션을 제공합니다.  
물론 Repository Bean은 가져오지 않기 때문에 직접 Import해서 사용하는 편이 나아보입니다.  

### 테스트 코드 작성 예시  
아래의 사진과 같이 JooqRepoTest를 만들어 상속받는 구조로 테스트코드를 작성하면 됩니다.

![image](https://user-images.githubusercontent.com/50672087/109970781-d0397880-7d38-11eb-905f-67853519619b.png)

<br>

## 4. 입력한 값 가져오기

![image](https://user-images.githubusercontent.com/50672087/109972002-2eb32680-7d3a-11eb-98e1-4c1b14f772e2.png)

쿼리를 짜다보면 insert, delete 한 데이터를 다시 사용해야할 때가 있습니다. (PK포함)
Jooq에서는 다음과 같이 **returning()**을 사용해서 입력한 값을 다시 받을 수 있습니다.

해당 부분은 JDBC API의 [getGeneratedKeys()](https://docs.oracle.com/en/java/javase/11/docs/api/java.sql/java/sql/Statement.html#getGeneratedKeys()) 를 사용하여 구현되어있습니다. 

<br>

그렇다보니 다음과 같은 유사 JPA 코드도 가능합니다.  
![image](https://user-images.githubusercontent.com/50672087/109974341-cc0f5a00-7d3c-11eb-9706-a426f5ef7a58.png)


<br>

## 5. 복잡한 쿼리 가져오기

jooq의 불편한 점은 select 할때마다 해당 부분을 dto 클래스로 만들어줘야하는데요.       

왜냐하면 **jooq는 ORM이 아니기 때문입니다.**    

하지만 그렇다고 dto 재사용 없이 일일이 만들기는 찜찜해서 몇가지 삽질을 했었습니다.

특히 join을 사용할 때가 문제였는데요.

![image](https://user-images.githubusercontent.com/50672087/109975970-94a1ad00-7d3e-11eb-9d76-f411fd38d9b7.png)

<br>

다음과 같은 쿼리가 있고, 아래처럼 엔티티와 유사한   
두개의 테이블 DTO가 있다고 가정했을 때 매핑할 방법을 찾고 있었습니다.  

<br>

![image](https://user-images.githubusercontent.com/50672087/109976329-ffeb7f00-7d3e-11eb-9c13-02c2c9b95302.png)


아래의 경우에서 jooq는 서드파티 record_mapper를 사용하라고 나와있습니다.
저는 ModelMapper를 사용하여 진행하였습니다. [[문서]](https://www.jooq.org/doc/3.14/manual/sql-execution/fetching/pojos-with-recordmapper-provider/)

<br>

하지만 ModelMapper를 사용하면 아래와 같이 alias를 붙여 Object를 구별해야합니다. 
다른 매퍼들은 시도하지 않았지만 비슷한걸로 보이네요.

<br>

![image](https://user-images.githubusercontent.com/50672087/109977311-07f7ee80-7d40-11eb-8289-d424b5c5a1ef.png)


개인적으로는 [[mapStruct]](https://mapstruct.org/) 를 사용하면 쉽게 해결할 수 있을것 같지만,  
jooq를 공식적으로 지원하지 않기때문에 다음에 시도해보도록 해야겠네요.  


## 6. 마무리

팀에 Jooq를 도입할 수 있을지 고려하기 위해 잠시 맛만 보았지만   
어느정도 매력적인것 같네요. 아래는 jooq를 입문하면서 느낀점입니다. 

### 단점
- getter / setter 강제 
  getter는 이해하지만 setter가 강제되어야합니다. ~~(불편)~~

- ~~JPA에 맛들린 나머지 ORM처럼 쓰려함~~ 

### 장점
- 러닝 커브? 
  확실히 JPA보다는 러닝커브가 낮아 도입하기 쉬워보입니다.
  
- ORM이 아닌 다른 선택지 (mybatis, jdbcTemplate) 에서는 제일 나이스하다고 느낌

<br>

아직 걸음마 수준이지만, 기회가 된다면 좀 더 알아봐야겠습니다.

---- 

## Reference
https://www.jooq.org/doc/3.0/manual/
