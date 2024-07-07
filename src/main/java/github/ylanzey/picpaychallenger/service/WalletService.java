package github.ylanzey.picpaychallenger.service;

import github.ylanzey.picpaychallenger.dto.CreateWalletDto;
import github.ylanzey.picpaychallenger.entity.Wallet;
import github.ylanzey.picpaychallenger.repository.WalletRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WalletService {

    private final WalletRepository walletRepository;

    public Wallet createWallet(CreateWalletDto dto) {

        var walletdb = walletRepository.findByCpfCnpjOrEmail(dto.cpfCnpj(), dto.email());

        if(walletdb.isPresent())
        {

        }

        return walletRepository.save(dto.toWallet());
    }
}
