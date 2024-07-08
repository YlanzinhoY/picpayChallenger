package github.ylanzey.picpaychallenger.controller;

import github.ylanzey.picpaychallenger.dto.TransferDto;
import github.ylanzey.picpaychallenger.entity.Transfer;
import github.ylanzey.picpaychallenger.service.TransferService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TransferController {
    private final TransferService transferService;

    @PostMapping("/transfer")
    public ResponseEntity<Transfer> transfer(@RequestBody TransferDto transferDto) {
        var res = transferService.transfer(transferDto);

        return ResponseEntity.ok(res);
    }
}
