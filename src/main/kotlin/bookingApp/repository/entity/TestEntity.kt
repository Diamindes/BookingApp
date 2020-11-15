package bookingApp.repository.entity

import java.io.Serializable
import javax.persistence.*

//@JsonSerialize
@Entity
@Table(name = "testTable")
class TestEntity (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    val firstName: String,
    val lastName: String
): Serializable