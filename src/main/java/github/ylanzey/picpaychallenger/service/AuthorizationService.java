package github.ylanzey.picpaychallenger.service;

import github.ylanzey.picpaychallenger.client.AuthorizationClient;
import github.ylanzey.picpaychallenger.entity.Transfer;
import github.ylanzey.picpaychallenger.exception.PicPayException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthorizationService {
    private final AuthorizationService authorizationService;
    private final AuthorizationClient authorizationClient;

    public boolean isAuthorized(Transfer transfer) {
        var res = authorizationClient.isAuthorized();

        if(res.getStatusCode().isError())
        {
            throw new PicPayException();
        }

        return  res.getBody().authorized();
    }

}
