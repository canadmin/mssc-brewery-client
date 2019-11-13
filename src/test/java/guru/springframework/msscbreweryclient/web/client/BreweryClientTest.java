package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;
    // Beer
    @Test
    void getBeerById() {
        BeerDto dto = client.getBeerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void testSaveNewBeer(){
        //given
        BeerDto beerDto = BeerDto.builder().beerName("new Beer").build();

        URI uri = client.saveNewBeer(beerDto);
        System.out.println(uri.toString());
    }

    @Test
    void testUpdateBeer(){
        BeerDto beerDto = BeerDto.builder().beerName("new Beer").build();
        client.updateBeer(UUID.randomUUID(),beerDto);
    }

    @Test
    void deleteBeerById(){
        client.deleteBeerById(UUID.randomUUID());
    }
    //Customer
    @Test
    void getCustomerById(){
        CustomerDto dto = client.getCustomerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void saveNewCustomer(){
        CustomerDto customerDto = CustomerDto.builder().name("Can Yard").build();
        URI uri=client.saveBewCustomer(customerDto);
        System.out.println(uri);
    }

    @Test
    void updateCustomer(){
        CustomerDto dto = CustomerDto.builder().name("Ali veli").build();
        client.updateCustoemr(UUID.randomUUID(), dto);

    }
    @Test
    void deleteCustomer(){
        client.deleteCustomer(UUID.randomUUID());
    }


}