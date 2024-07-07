package github.ylanzey.picpaychallenger.repository;

import github.ylanzey.picpaychallenger.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
    Optional<Wallet> findByCpfCnpjOrEmail(String s, String email);
}
