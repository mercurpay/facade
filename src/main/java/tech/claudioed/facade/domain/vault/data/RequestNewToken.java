package tech.claudioed.facade.domain.vault.data;

import lombok.Data;

/**
 * @author claudioed on 2019-05-26.
 * Project facade
 */
@Data
public class RequestNewToken {

  private String customerId;

  private String issuerId;

  private String card;

}
