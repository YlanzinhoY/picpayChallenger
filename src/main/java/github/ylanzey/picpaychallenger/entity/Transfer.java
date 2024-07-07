package github.ylanzey.picpaychallenger.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_transfer")
public class Transfer{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
}
