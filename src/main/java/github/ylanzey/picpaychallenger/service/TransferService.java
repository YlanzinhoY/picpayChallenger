package github.ylanzey.picpaychallenger.service;

import github.ylanzey.picpaychallenger.dto.TransferDto;
import github.ylanzey.picpaychallenger.entity.Transfer;
import github.ylanzey.picpaychallenger.entity.Wallet;
import github.ylanzey.picpaychallenger.exception.InsufficientBalanceException;
import github.ylanzey.picpaychallenger.exception.TransferNotAllowedForWalletTypeException;
import github.ylanzey.picpaychallenger.exception.WalletNotFoundException;
import github.ylanzey.picpaychallenger.repository.TransferRepository;
import github.ylanzey.picpaychallenger.repository.WalletRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransferService {

    private final AuthorizationService authorizationService;
    private final NotificationService notificationService;
    private final TransferRepository transferRepository;
    private final WalletRepository walletRepository;

    public Transfer transfer(TransferDto transferDto) {
        var sender = walletRepository.findById(transferDto.payer())
                .orElseThrow(() -> new WalletNotFoundException(transferDto.payer()));

        var receiver = walletRepository.findById(transferDto.payee())
                .orElseThrow(() -> new WalletNotFoundException(transferDto.payee()));
        
        
        validateTransfer(transferDto, sender);

    }

    private void validateTransfer(TransferDto transferDto, Wallet sender) {

        if(!sender.isTransferAllowedForWalletType()) {
            throw new TransferNotAllowedForWalletTypeException();
        }

        if(sender.isBalancerBiggerThan(transferDto.value())){
            throw new InsufficientBalanceException();
        }

        if()

    }
}
