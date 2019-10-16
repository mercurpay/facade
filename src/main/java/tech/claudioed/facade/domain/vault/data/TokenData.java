package tech.claudioed.facade.domain.vault.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author claudioed on 2019-05-26.
 * Project facade
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TokenData {

  private String customerId;

  private String issuerId;

  private String card;

}
