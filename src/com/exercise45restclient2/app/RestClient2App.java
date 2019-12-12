package com.exercise45restclient2.app;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.exercise45restclient2.model.Product;

public class RestClient2App {

	public static void main(String[] args) {
		// le decimos a la app que es un cliente
		Client client = ClientBuilder.newClient();			
		 
		
		//target URI AL QUE QUEREMOS APUNTAR endpoint
		WebTarget webTarget = client.target("http://localhost:8080/Exercise45WebServicesRest/").path("Products");
		 
		//Creando el request que envia un formato json
		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
		 
		//creamos el producto
		Product myProduct = new Product();
		myProduct.setIdProduct(1);
		myProduct.setNameProduct("Nopalitos");
		myProduct.setPriceProduct(40.5);
		
		//mi entidad muy produc serializamela como json:.....ENTITY manda el objeto
		Response response = invocationBuilder.post(Entity.entity(myProduct, MediaType.APPLICATION_JSON));
		
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}

}
