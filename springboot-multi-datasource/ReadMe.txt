

1. JPA Mapping in ORM tool

Hibernate is ORM (Object Realtional Mapping) Tools and used to map the databases and JPA is another layer of Hibernate

1. Mapping
1.1 BiDirectional Mapping - Mapped bet PK and FK of the both table/entities

1.2 Uni Directional mapping - Mapped in one entity and hibernate automatically query it and get it mapped and then get the reault

Student

@OneToOne
@JoinColumn(name = "student_id")
Addresss address

recommend to iDirectional mapping

2. OneToOne 

Student

@OneToOne (mapped = "Address")
Addresss address

Address

@JoinColumn(name = "student_id")
@OneToOne
Student student

2. OneToMany 

Department

@OneToMany (mapped = "Department")
List<Student> students

Student

@JoinColumn(name = "dept_id")
@ManyToOne
Student student

2. OneToMany 

Course

@ManyToMany (mapped = "Course")
List<Student> students

Student

@JoinColumn(name = "course_id", name="stud_id")
@ManyToMany
Student student


Composite Key : having two primary key in a table, make as composite key and set as @EmbededId
