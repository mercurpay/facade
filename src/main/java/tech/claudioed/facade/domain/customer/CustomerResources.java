package tech.claudioed.facade.domain.customer;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.claudioed.facade.domain.customer.data.CreateCustomerRequest;
import tech.claudioed.facade.domain.customer.data.CreateCustomerResponse;
import tech.claudioed.facade.domain.customer.service.CustomerService;

/**
 * @author claudioed on 2019-05-26.
 * Project facade
 */
@RestController
@RequestMapping("/facade/api/customers")
public class CustomerResources {

  private final CustomerService customerService;

  public CustomerResources(@RequestBody CustomerService customerService) {
    this.customerService = customerService;
  }

  @PostMapping
  public CreateCustomerResponse newCustomer(@RequestBody CreateCustomerRequest request){
    return this.customerService.create(request);
  }

}
