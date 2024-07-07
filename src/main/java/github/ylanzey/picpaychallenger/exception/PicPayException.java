package github.ylanzey.picpaychallenger.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

//RFC 7807 -> padroes de erro nas API's springboot
public class PicPayException extends RuntimeException {
    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);

        pb.setTitle("PicPay internal server error");

        return pb;
    }
}
