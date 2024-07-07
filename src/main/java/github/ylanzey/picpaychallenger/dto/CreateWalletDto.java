package github.ylanzey.picpaychallenger.dto;

import github.ylanzey.picpaychallenger.entity.Wallet;
import github.ylanzey.picpaychallenger.entity.WalletType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateWalletDto(
        @NotBlank String fullname,
        @NotBlank String cpfCnpj,
        @NotBlank String email,
        @NotBlank String password,
        @NotNull WalletType.Enum walletType) {
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
