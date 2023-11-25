package not.beat.cat.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "bank_accounts")
public class BankAccountInfo {
    @Id
    @Column(name = "form_id")
    private long formId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private Form form;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "category")
    private String category;
}
