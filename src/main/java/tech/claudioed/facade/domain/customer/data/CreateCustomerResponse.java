package tech.claudioed.facade.domain.customer.data;

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
public class CreateCustomerResponse {

  private String id;

  private String name;

  private String lastName;

  private String document;

  private String address;

  private String city;

  private String country;

  private String email;

  private String twoFactorEnabled;

}
