package looking.demo.entitles;

import  looking.demo.model.ProductStatus;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String name;
    private String type;
    private String desc;
    private double price;
    private int status ; // quy định trạng thái của sản phẩm
    private String image;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdDate;


    public boolean isActive() {
        return this.status == ProductStatus.PRODUCT_ACTIVE;
    }
    public boolean isInactive() {
        return this.status == ProductStatus.PRODUCT_INACTIVE;
    }
    public boolean isCancel() {
        return this.status == ProductStatus.PRODUCT_CANCEL;
    }
}
