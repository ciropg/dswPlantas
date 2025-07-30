package dsw.sighierbabackend.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hierbas")
public class Hierba {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_comun", length = 100, nullable = false)
    private String nombreComun;

    @Column(name = "nombre_cientifico", length = 150)
    private String nombreCientifico;

    @Column(columnDefinition = "text")
    private String descripcion;

    @Column(columnDefinition = "text")
    private String propiedades;

    @Column(columnDefinition = "text")
    private String usos;

    @CreationTimestamp
    @Column(name = "fecha_registro", updatable = false)
    private LocalDateTime fechaRegistro;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;
}
