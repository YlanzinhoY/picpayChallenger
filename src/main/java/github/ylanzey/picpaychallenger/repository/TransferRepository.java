package github.ylanzey.picpaychallenger.repository;

import github.ylanzey.picpaychallenger.entity.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransferRepository extends JpaRepository<Transfer, UUID> {
}
