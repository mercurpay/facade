package tech.claudioed.facade.domain.issuer.data;

import lombok.Data;

/** @author claudioed on 2019-05-26. Project facade */
@Data
public class RequestPayment {

  private String token;

  private Double value;

  private String type;

}
