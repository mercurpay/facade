package tech.claudioed.facade.domain.vault;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.claudioed.facade.domain.vault.data.RequestNewToken;
import tech.claudioed.facade.domain.vault.data.Token;
import tech.claudioed.facade.domain.vault.data.TokenData;
import tech.claudioed.facade.domain.vault.service.VaultService;

/**
 * @author claudioed on 2019-05-26.
 * Project facade
 */
@RestController
@RequestMapping("/facade/api/vault")
public class VaultResources {

  private final VaultService vaultService;

  public VaultResources(VaultService vaultService) {
    this.vaultService = vaultService;
  }

  @PostMapping("/detoken")
  public TokenData fromToken(@RequestBody Token token){
    return this.vaultService.fromToken(token);
  }

  @PostMapping("/token")
  public Token newToken(@RequestBody RequestNewToken requestNewToken){
    return this.vaultService.newToken(requestNewToken);
  }

}
