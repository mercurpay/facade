package tech.claudioed.facade.domain.vault.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tech.claudioed.facade.domain.vault.data.RequestNewToken;
import tech.claudioed.facade.domain.vault.data.Token;
import tech.claudioed.facade.domain.vault.data.TokenData;
import vault.DataByToken;
import vault.VaultServiceGrpc.VaultServiceBlockingStub;

/** @author claudioed on 2019-05-26. Project facade */
@Slf4j
@Service
public class VaultService {

  private final VaultServiceBlockingStub stub;

  public VaultService(VaultServiceBlockingStub stub) {
    this.stub = stub;
  }

  public TokenData fromToken(Token token) {
    log.info("From Token {}",token);
    final vault.Token data = vault.Token.newBuilder().setValue(token.getToken()).build();
    final DataByToken dataByToken = this.stub.fromToken(data);
    return TokenData.builder()
        .card(dataByToken.getCard())
        .customerId(dataByToken.getCustomerId())
        .issuerId(dataByToken.getIssuer())
        .build();
  }

  public Token newToken(RequestNewToken requestNewToken) {
    log.info("New Token {}",requestNewToken);
    final vault.RequestNewToken newToken = vault.RequestNewToken.newBuilder()
        .setCard(requestNewToken.getCard()).setCustomerId(requestNewToken.getCustomerId())
        .setIssuer(requestNewToken.getIssuerId()).build();
    final vault.Token tokenData = this.stub.newToken(newToken);
    return Token.builder().token(tokenData.getValue()).build();
  }
}
