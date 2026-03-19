//apackage com.jpmc.midascore.service;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import com.jpmc.midascore.foundation.Transaction;
//
//@Service
//public class IncentiveService {
//    private final WebClient webClient;
//
//    public IncentiveService(@Value("${incentive.api.url}") String apiUrl) {
//        this.webClient = WebClient.create(apiUrl);
//    }
//
//    public float getIncentive(Transaction transaction) {
//        IncentiveRequest request = new IncentiveRequest(
//            transaction.getSenderId(),
//            transaction.getRecipientId(),
//            transaction.getAmount()
//        );
//
//        return webClient.post()
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(request)
//            .retrieve()
//            .bodyToMono(IncentiveResponse.class)
//            .blockOptional()
//            .map(IncentiveResponse::incentiveAmount)
//            .orElse(0.0f);
//    }
//}
//
//// Request/Response DTOs
//public record IncentiveRequest(long senderId, long recipientId, float amount) {}
//public record IncentiveResponse(float incentiveAmount) {}