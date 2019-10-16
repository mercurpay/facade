package tech.claudioed.facade.domain.customer.data;

import lombok.Data;

/**
 * @author claudioed on 2019-05-26.
 * Project facade
 */
@Data
public class CreateCustomerRequest {

  private String name;

  private String lastName;

  private String document;

  private String address;

  private String city;

  private String country;

  private String email;

  private String twoFactorEnabled;

}
