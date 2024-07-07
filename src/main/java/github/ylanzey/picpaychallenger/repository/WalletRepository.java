package github.ylanzey.picpaychallenger.repository;

import github.ylanzey.picpaychallenger.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
}
