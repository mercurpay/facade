package tech.claudioed.facade.infra.grpc.issuer;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import issuer.IssuerServiceGrpc;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IssuerServiceProducers {

  private final String issuerSvcUrl;

  private final Integer issuerSvcPort;

  public IssuerServiceProducers(
      @Value("${issuer.url}") String vaultSvcUrl, @Value("${issuer.port}") Integer vaultSvcPort) {
    this.issuerSvcUrl = vaultSvcUrl;
    this.issuerSvcPort = vaultSvcPort;
  }

  @Bean("issuerManagedChannel")
  public ManagedChannel issuerManagedChannel(){
      return ManagedChannelBuilder.forAddress(this.issuerSvcUrl,this.issuerSvcPort).usePlaintext().build();
  }

  @Bean("issuerServiceStub")
  public IssuerServiceGrpc.IssuerServiceBlockingStub channel(@Qualifier("issuerManagedChannel") ManagedChannel managedChannel){
      return IssuerServiceGrpc.newBlockingStub(managedChannel);
  }

}
