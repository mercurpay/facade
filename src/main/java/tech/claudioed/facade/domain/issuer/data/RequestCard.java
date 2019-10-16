package tech.claudioed.facade.domain.issuer.data;

import lombok.Data;

/** @author claudioed on 2019-05-26. Project facade */
@Data
public class RequestCard {

  private String card;

  private String customer;

  private String issuer;

  private Double balance;

}
