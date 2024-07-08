package github.ylanzey.picpaychallenger.service;

import github.ylanzey.picpaychallenger.dto.TransferDto;
import github.ylanzey.picpaychallenger.entity.Transfer;
import github.ylanzey.picpaychallenger.entity.Wallet;
import github.ylanzey.picpaychallenger.exception.InsufficientBalanceException;
import github.ylanzey.picpaychallenger.exception.TransferNotAllowedForWalletTypeException;
import github.ylanzey.picpaychallenger.exception.TransferNotAuthorizedException;
import github.ylanzey.picpaychallenger.exception.WalletNotFoundException;
import github.ylanzey.picpaychallenger.repository.TransferRepository;
import github.ylanzey.picpaychallenger.repository.WalletRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@AllArgsConstructor
public class TransferService {

    private final AuthorizationService authorizationService;
    private final NotificationService notificationService;
    private final TransferRepository transferRepository;
    private final WalletRepository walletRepository;

    @Transactional
    public Transfer transfer(TransferDto transferDto) {
        var sender = walletRepository.findById(transferDto.payer())
                .orElseThrow(() -> new WalletNotFoundException(transferDto.payer()));

        var receiver = walletRepository.findById(transferDto.payee())
                .orElseThrow(() -> new WalletNotFoundException(transferDto.payee()));
        
        
        validateTransfer(transferDto, sender);

        sender.debit(transferDto.value());
        receiver.credit(transferDto.value());

        var transfer = new Transfer(sender, receiver, transferDto.value());

        walletRepository.save(sender);
        walletRepository.save(receiver);
        var transferResult = transferRepository.save(transfer);

        CompletableFuture.runAsync(() -> notificationService.SendNotification(transferResult));

        return transferResult;

    }

    private void validateTransfer(TransferDto transferDto, Wallet sender) {

        if(!sender.isTransferAllowedForWalletType()) {
            throw new TransferNotAllowedForWalletTypeException();
        }

        if(!sender.isBalancerBiggerThan(transferDto.value())){
            throw new InsufficientBalanceException();
        }

        if(!authorizationService.isAuthorized(transferDto)) {
            throw new TransferNotAuthorizedException();
        }

    }
}
