# [삽질] JPA로 Recursive CTE 사용하기  

RDBMS에서 계층형 쿼리를 작성할때 Common Table Expression을 사용하여    
쿼리를 작성 할 수 있습니다.

일반적인 SQL에서는 WITH [ Recursive ] 라는 구문으로 작성가능합니다.    
해당 구문은 [[ANSI 표준]](https://en.wikipedia.org/wiki/SQL:1999) 이기 때문에 MySQL이나, MariaDB, Oracle 등  
대부분의 RDBMS에서 사용할 수 있습니다.

해당 구문을 JPA에서 **Native SQL을 사용하지 않고** 추상화 레벨을 유지하며,   
QueryDSL과 함께 사용할 수 있도록 하면서 겪은 삽질을 기록하였습니다.  

**Note) "공식적"으로 JPA는 CTE를 지원하지 않습니다**

본 글은 MariaDB 기준으로 작성하였습니다. 해당 코드는 [[여기]](https://github.com/SightStudio/blog-code/tree/develop/JPAwithRecursive) 서 확인할 수 있습니다.  

## 0. CTE 란?
Common Table Expression (이하 CTE) 이란, 해당 쿼리가 실행되는 동안 사용 할 수 있는    
임시 테이블입니다. 하지만 일반적인 임시테이블과는 다르게 자기 자신을 참조 할 수 있기 때문에   
SQL에서 재귀형태로 쿼리를 짤 때 간간히 사용됩니다.  

Non-Recursive와 Recursive 버전 2가지가 있으며, 이 글은 Recursive 한 경우를 다룹니다.  

## 1.  DDL 가정

![image](https://user-images.githubusercontent.com/50672087/110339829-f24e3600-806b-11eb-890f-fa5d4ebca418.png)

테스트에 사용된 DDL은 회사와 회사의 부서 정보를 가지고 있는 테이블 2개로 진행됩니다.
다만 여기서 부서 테이블은 자기 자신을 참조하여 하위부서를 무한으로 만들 수 있다고 가정합니다.

## 2. Native SQL을 사용한다면?

해당 부분을 Native SQL을 사용한다면 어떻게 작성 할 까요? 
Common Table Expression을 사용하면 다음과 같이 쉽게 작성 할 수 있습니다.

```sql
WITH RECURSIVE DepartmentCTE(
    company_seq, 
    dept_seq, 
    name, 
    depth, 
    parent_dept_seq, 
    created_at, 
    updated_at
) AS (
        SELECT dept.company_seq    ,
               dept.dept_seq       ,
               dept.name           ,
               dept.depth          ,
               dept.parent_dept_seq,
               dept.created_at     ,
               dept.updated_at
        FROM department dept
        WHERE dept.company_seq = $companySeq
            AND dept.depth = 0
        UNION ALL
        SELECT dept.company_seq     ,
               dept.dept_seq        ,
               dept.name            ,
               dept.depth           ,
               dept.parent_dept_seq ,
               dept.created_at      ,
               dept.updated_at
        FROM department dept
            INNER JOIN DepartmentCTE CTE
                ON (dept.parent_dept_seq = CTE.dept_seq)
    )
SELECT CTE.dept_seq       ,
       CTE.created_at     ,
       CTE.updated_at     ,
       CTE.company_seq    ,
       CTE.depth          ,
       CTE.name           ,
       CTE.parent_dept_seq
FROM DepartmentCTE CTE
ORDER BY CTE.depth,
         CTE.created_at
```

### 조회 결과  
아래와 같이 정상적으로 결과가 나오는 것을 볼 수 있습니다.  

![image](https://user-images.githubusercontent.com/50672087/110340900-1d855500-806d-11eb-94b9-a8715fa6a564.png)

## 3. 그럼 JPA 에서는?  

그렇다면 JPA 에서는 해당 구문을 어떻게 해야할까요?  
간단히 JPQL로 똑같이 짜면 될 것 같지만  

**아쉽게도 JPA(hibernate)는 Common Table Expression을 지원하지 않습니다. (무수한 삽질 끝에...)**  
~~이미 [[스택오버플로우]](https://stackoverflow.com/questions/48560788/querydsl-ignores-common-table-expression-alias-for-jpa-entities) 에서도 수많은 시도가 있었습니다.~~

### 대안?  

그렇다면 Native Query 만이 답일까요?

시도하다 실패한 이후 두가지 방법이 떠올랐습니다.
저는 글 작성전에는 2번을 택했지만, 이 글을 쓰는 시점에서는 차라리 1번을 낫다고 생각합니다. 

1. Jooq나 QueryDSL-SQL과 같은 Type-Safe한 Native SQL 사용   
2. (같은 고통을 느낀 사람이 만든) 라이브러리 사용  

### 4. BlazePersistence 소개  

https://github.com/Blazebit/blaze-persistence 

해당 라이브러리는 JPA Criteria API 기반의 래핑 라이브러리이며 (기능 확장)  
JPA에서 지원이 안되는 Common Table Expression 이나, Form 절 Subquery를 지원합니다. (???)
  - ( 찾아보니 둘다 Hibernate의 @Subselect를 사용하여 강제로 서브쿼리로 변경하여 사용하네요. [[하이버네이트 문서]](https://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html))  

[라이브러리를 만든 분도](https://download.oracle.com/javaee-archive/jpa-spec.java.net/users/2016/01/0970.html)    
2016년 당시 제가 겪은 불편함 때문에 BlazePersistence 라는 라이브러리를 만들었다고 하는걸 보면...  저만 삽질한게 아니였나봅니다.   

지원하는 않는 RDB도 있으니 [[공식 문서]](https://persistence.blazebit.com/documentation/1.5/core/manual/en_US/#anchor-ctes-dbms-compatibility) 를 참고해주세요

해당 라이브러를 의존성에 추가하고 (코드참고)   
다음과 같이 criteria용 bean을 생성합니다.

![image](https://user-images.githubusercontent.com/50672087/110463303-17e34a00-8115-11eb-8dcd-96f674af2f63.png)

이후 아래와 같이 코드를 작성하면 정상적으로 Recursive CTE 구문이 적용되는 것을 확인할 수 있습니다. 

```kotlin
class DepartmentRepositoryImpl: DepartmentRepositoryCustom,
    QuerydslRepositorySupport(Department::class.java) {

    companion object {
        private const val ROOT_DEPTH = 0
    }

    @Autowired
    lateinit var criteriaBuilderFactory: CriteriaBuilderFactory

    override fun findByCompanySeqWithRecursiveCte(companySeq: Long): List<DepartmentCTE> {
        val dept = QDepartment.department
        val deptCTE = QDepartmentCTE.departmentCTE

        val parentDept = QDepartmentCTE("parent")

        return BlazeJPAQuery<DepartmentCTE>(entityManager, criteriaBuilderFactory)
            .withRecursive(
                deptCTE, BlazeJPAQuery<DepartmentCTE>().unionAll(

                    BlazeJPAQuery<DepartmentCTE>()
                        .from(dept)
                        .bind(deptCTE.company, dept.company)
                        .bind(deptCTE.seq, dept.seq)
                        .bind(deptCTE.name, dept.name)
                        .bind(deptCTE.depth, dept.depth)
                        .bind(deptCTE.parent, dept.parent)
                        .bind(deptCTE.createdAt, dept.createdAt)
                        .bind(deptCTE.updatedAt, dept.updatedAt)
                        .where(
                            eqCompanySeq(dept.company, companySeq),
                            eqRootDepth(dept)
                        ),

                    BlazeJPAQuery<DepartmentCTE>()
                        .from(dept)
                        .join(parentDept)
                        .on(eqComment(dept.parent, parentDept))
                        .bind(deptCTE.company, dept.company)
                        .bind(deptCTE.seq, dept.seq)
                        .bind(deptCTE.name, dept.name)
                        .bind(deptCTE.depth, dept.depth)
                        .bind(deptCTE.parent, dept.parent)
                        .bind(deptCTE.createdAt, dept.createdAt)
                        .bind(deptCTE.updatedAt, dept.updatedAt)
                )
            )
            .select(deptCTE)
            .from(deptCTE)
            .orderBy(deptCTE.depth.asc(), deptCTE.createdAt.asc())
            .fetch()
    }
}
```   

![image](https://user-images.githubusercontent.com/50672087/110465398-b2448d00-8117-11eb-8bc6-c33aa0aa0f64.png)

### 여담) Recursive CTE 실행계획  

![image](https://user-images.githubusercontent.com/50672087/110465686-18c9ab00-8118-11eb-96f6-024660ee1291.png)

실제 실행계획을 보면 2번 ID 에서 임시 테이블이 생성되는 것을 확인 할 수 있습니다.  

한가지 또 주의해야할 점이 있다면 CTE는 실제 테이블이 아니기 때문에 인덱스가 걸리지 않습니다.   
실행계획에서 **<derived2>** 테이블의 type이 ALL 인것으로 보아 CTE 테이블 자체는 항상 풀스캔을 하는것으로 보입니다.    
고로 Recursive CTE를 사용하려면 한번에 많은 행을 SELECT 하는 것을 피하도록 해야겠네요.    

(CTE 없이 SELECT 하는것과 Recursive CTE로 처리하는 것의 성능 차이는 상황에 따라 다른듯하다. **실행계획을 보자**)  

### 후기 
사실 막상 삽질하고 나서 보니 크게 기록할 만한 내용은 아닌것 같지만,  
들인 시간이 아까워 블로그에 포스팅합니다.  

CTE 쓰려면 그냥 Native SQL 쓰는게 낫습니다. (Jooq, QueryDSL-SQL, 혹은 그냥 jdbcTemplate)

### Reference
https://mariadb.com/kb/en/explain/
https://persistence.blazebit.com/documentation/1.5/core/manual/en_US/#ctes

