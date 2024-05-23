package shop.mtcoding.bank.domain.transaction;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shop.mtcoding.bank.domain.account.Account;

@NoArgsConstructor
@Getter
@EntityListeners(AuditingEntityListener.class)
@Table(name = "transaction_tb")
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Account withdrawAccount;
    private Account depositAccount;
    
    private Long amount;

    private Long withdrawAccountBalance; // 1111 계좌 -> 1000원 -> 500원 -> 200원
    private Long depositAccountBalance;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionEnum gubun; // WITHDRAW, DEPOSIT, TRANSFER, ALL

    // 계좌가 사라져도 로그는 남아야 한다.
    private String sender;
    private String receiver;
    private String tel;

    @CreatedDate // Insert
    @Column(nullable = false)
    private LocalDateTime createedAt;

    @LastModifiedDate // Insert, Update
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Builder
    public Transaction(Long id, Account withdrawAccount, Account depositAccount, Long amount,
            Long withdrawAccountBalance, Long depositAccountBalance, TransactionEnum gubun, String sender,
            String receiver, String tel, LocalDateTime createedAt, LocalDateTime updatedAt) {
        this.id = id;
        this.withdrawAccount = withdrawAccount;
        this.depositAccount = depositAccount;
        this.amount = amount;
        this.withdrawAccountBalance = withdrawAccountBalance;
        this.depositAccountBalance = depositAccountBalance;
        this.gubun = gubun;
        this.sender = sender;
        this.receiver = receiver;
        this.tel = tel;
        this.createedAt = createedAt;
        this.updatedAt = updatedAt;
    }

    
}
