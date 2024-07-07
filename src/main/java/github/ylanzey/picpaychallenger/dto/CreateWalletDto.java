package github.ylanzey.picpaychallenger.dto;

import github.ylanzey.picpaychallenger.entity.Wallet;
import github.ylanzey.picpaychallenger.entity.WalletType;

public record CreateWalletDto(String fullname,
                              String cpfCnpj,
                              String email,
                              String password,
                              WalletType.Enum walletType) {
    public Wallet toWallet(){
        return new Wallet(
                fullname,
                cpfCnpj,
                email,
                password,
                walletType.get()
        );
    }
}
