package github.ylanzey.picpaychallenger.controller;

import github.ylanzey.picpaychallenger.dto.CreateWalletDto;
import github.ylanzey.picpaychallenger.entity.Wallet;
import github.ylanzey.picpaychallenger.repository.WalletRepository;
import github.ylanzey.picpaychallenger.service.WalletService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class WalletController {
    private final WalletService walletService;

    @PostMapping("/wallets")
    public ResponseEntity<Wallet> createWallet(@RequestBody CreateWalletDto dto) {
        var wallet = walletService.createWallet(dto);
        return ResponseEntity.ok(wallet);
    }

}
