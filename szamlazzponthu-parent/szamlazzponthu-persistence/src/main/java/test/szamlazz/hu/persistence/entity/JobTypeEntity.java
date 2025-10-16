package test.szamlazz.hu.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "job_type")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobTypeEntity {

    @Id
    @Column(length = 16, nullable = false)
    String code;
    
    @Column(name = "label_hu", length = 64, nullable = false)
    private String labelHu;

    @Column(name = "label_en", length = 64, nullable = false)
    private String labelEn;

}
