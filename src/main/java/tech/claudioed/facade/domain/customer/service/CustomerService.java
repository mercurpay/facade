package tech.claudioed.facade.domain.customer.service;

import org.springframework.stereotype.Service;
import tech.claudioed.customer.grpc.CustomerCreateRequest;
import tech.claudioed.customer.grpc.CustomerFindResponse;
import tech.claudioed.customer.grpc.CustomerServiceGrpc.CustomerServiceBlockingStub;
import tech.claudioed.facade.domain.customer.data.CreateCustomerRequest;
import tech.claudioed.facade.domain.customer.data.CreateCustomerResponse;

/**
 * @author claudioed on 2019-05-26.
 * Project facade
 */
@Service
public class CustomerService {

  private final CustomerServiceBlockingStub stub;

  public CustomerService(CustomerServiceBlockingStub stub) {
    this.stub = stub;
  }

  public CreateCustomerResponse create(CreateCustomerRequest request){
    final CustomerCreateRequest createRequest = CustomerCreateRequest.newBuilder()
        .setAddress(request.getAddress()).setCity(request.getCity())
        .setCountry(request.getCountry()).
            setDocument(request.getDocument()).setLastName(request.getLastName())
        .setName(request.getName()).setEmail(request.getEmail()).setTwoFactorEnabled(request.getTwoFactorEnabled()).build();
    final CustomerFindResponse response = this.stub.createCustomer(createRequest);
    return CreateCustomerResponse.builder().id(response.getId()).build();
  }

}
