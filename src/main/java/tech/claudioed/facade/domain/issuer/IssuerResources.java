package tech.claudioed.facade.domain.issuer;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.claudioed.facade.domain.issuer.data.Account;
import tech.claudioed.facade.domain.issuer.data.CardBalance;
import tech.claudioed.facade.domain.issuer.data.RequestCard;
import tech.claudioed.facade.domain.issuer.data.RequestCharge;
import tech.claudioed.facade.domain.issuer.data.RequestPayment;
import tech.claudioed.facade.domain.issuer.data.Transaction;
import tech.claudioed.facade.domain.issuer.service.IssuerService;

/**
 * @author claudioed on 2019-05-26.
 * Project facade
 */
@RestController
@RequestMapping("/facade/api/issuers")
public class IssuerResources {

  private final IssuerService issuerService;

  public IssuerResources(IssuerService issuerService) {
    this.issuerService = issuerService;
  }

  @PostMapping("/cards")
  public Account newCard(@RequestBody RequestCard requestCard){
    return this.issuerService.requestCard(requestCard);
  }

  @PostMapping("/transactions")
  public Transaction transaction(@RequestBody RequestPayment requestPayment){
    return this.issuerService.transaction(requestPayment);

  }

  @PostMapping("/charges")
  public CardBalance charge(@RequestBody RequestCharge charge){
    return this.issuerService.chargeCard(charge);
  }

}
