import lombok.NoArgsConstructor
import lombok.experimental.Accessors
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.annotation.Version
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime


@Table
class Item constructor(
    @Id
    var id: Long? = null,
    //@Version
    var version: Long? = null,
    var description: String? = null) {
    override fun toString(): String {
        return "Item(id=$id, version=$version, description=$description)"
    }
}