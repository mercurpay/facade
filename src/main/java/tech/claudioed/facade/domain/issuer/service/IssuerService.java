package tech.claudioed.facade.domain.issuer.service;

import issuer.IssuerServiceGrpc.IssuerServiceBlockingStub;
import org.springframework.stereotype.Service;
import tech.claudioed.facade.domain.issuer.data.Account;
import tech.claudioed.facade.domain.issuer.data.CardBalance;
import tech.claudioed.facade.domain.issuer.data.RequestCard;
import tech.claudioed.facade.domain.issuer.data.RequestCharge;
import tech.claudioed.facade.domain.issuer.data.RequestPayment;
import tech.claudioed.facade.domain.issuer.data.Transaction;

/** @author claudioed on 2019-05-26. Project facade */
@Service
public class IssuerService {

  private final IssuerServiceBlockingStub stub;

  public IssuerService(IssuerServiceBlockingStub stub) {
    this.stub = stub;
  }

  public Transaction transaction(RequestPayment requestPayment) {
    final issuer.RequestPayment payment =
        issuer.RequestPayment.newBuilder()
            .setType(requestPayment.getType())
            .setToken(requestPayment.getToken())
            .setValue(requestPayment.getValue())
            .build();
    final issuer.Transaction transaction = this.stub.requestPayment(payment);
    return Transaction.builder().id(transaction.getId()).status(transaction.getStatus()).build();
  }

  public Account requestCard(RequestCard requestCard) {
    final issuer.RequestCard card =
        issuer.RequestCard.newBuilder()
            .setBalance(requestCard.getBalance())
            .setCard(requestCard.getCard())
            .setCustomer(requestCard.getCustomer())
            .setIssuer(requestCard.getIssuer())
            .build();
    final issuer.Account account = this.stub.requestCard(card);
    return Account.builder().id(account.getId()).build();
  }

  public CardBalance chargeCard(RequestCharge charge) {
    final issuer.RequestCharge requestCharge =
        issuer.RequestCharge.newBuilder()
            .setToken(charge.getToken())
            .setValue(charge.getValue())
            .build();
    final issuer.CardBalance cardBalance = this.stub.requestCharge(requestCharge);
    return CardBalance.builder()
        .token(cardBalance.getToken())
        .balance(cardBalance.getBalance())
        .build();
  }
}
