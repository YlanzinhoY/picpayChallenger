package github.ylanzey.picpaychallenger.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "tb_transfer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transfer{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @JoinColumn(name = "wallet_sender_id")
    @ManyToOne
    private Wallet sender;

    @ManyToOne
    @JoinColumn(name = "wallet_receiver_id")
    private Wallet receiver;

    @Column(name = "value")
    private BigDecimal value;

    public Transfer(Wallet sender, Wallet receiver, BigDecimal value) {
        this.value = value;
        this.receiver = receiver;
        this.sender = sender;
    }
}
