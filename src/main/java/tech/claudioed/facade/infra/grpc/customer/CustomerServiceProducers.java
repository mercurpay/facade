package tech.claudioed.facade.infra.grpc.customer;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.claudioed.customer.grpc.CustomerServiceGrpc;

@Configuration
public class CustomerServiceProducers {

  private final String customerSvcUrl;

  private final Integer customerSvcPort;

  public CustomerServiceProducers(
      @Value("${customer.url}") String vaultSvcUrl, @Value("${customer.port}") Integer vaultSvcPort) {
    this.customerSvcUrl = vaultSvcUrl;
    this.customerSvcPort = vaultSvcPort;
  }

  @Bean("customerManagedChannel")
  public ManagedChannel issuerManagedChannel(){
      return ManagedChannelBuilder.forAddress(this.customerSvcUrl,this.customerSvcPort).usePlaintext().build();
  }

  @Bean("customerServiceStub")
  public CustomerServiceGrpc.CustomerServiceBlockingStub channel(@Qualifier("customerManagedChannel") ManagedChannel managedChannel){
      return CustomerServiceGrpc.newBlockingStub(managedChannel);
  }

}
