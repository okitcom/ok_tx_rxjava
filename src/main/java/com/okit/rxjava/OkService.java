package com.okit.rxjava;

import com.okit.client.TransactionRequest;
import com.okit.client.ticket.TSPTicketsRequest;
import com.okit.client.ticket.Ticket;

import io.reactivex.Observable;

import java.util.List;

import com.okit.client.Authorisation;
import com.okit.client.AuthorisationRequest;
import com.okit.client.Transaction;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface OkService {

	//-- Transaction 
	
    @Headers({
	        "content-type: application/json"
	})
	@POST("/works/api/v2/payment/transactions.json")
	abstract Observable<Transaction> requestTransaction(@Body TransactionRequest transactionInitiation);
    
    @Headers({
	        "content-type: application/json"
	})
	@GET("/works/api/v2/payment/transactions/{guid}.json")
    abstract Observable<Transaction> checkTransactionStatus(@Path("guid") String guid);
    
    @Headers({
        "content-type: application/json"
    })
    @GET("/works/api/v2/payment/transactions/{guid}/refunds")
    abstract Observable<Transaction> refundTransaction(@Path("guid") String guid);    
    
    
    // --- Authentication and Authorisation

    @Headers({
        "content-type: application/json"
	})
	@POST("/works/api/v2/open/authorisationrequests.json")
	abstract Observable<Authorisation> requestAuthorisation(@Body AuthorisationRequest authorisationRequest);
	
	@Headers({
	        "content-type: application/json",
	})
	@GET("/works/api/v2/open/authorisationrequests/{guid}.json")
	abstract Observable<Authorisation> checkAuthorisationStatus(@Path("guid") String guid);
	
	//-- Ticketing
	
//    @Headers({
//        "content-type: application/json"
//	})
//    @POST("/works/api/v2/ticketing/tickets.json")
//    abstract Observable<List<Ticket>> createTickets(@Body List<Ticket> tickets);
//    
//    @Headers({
//        "content-type: application/json"
//	})
//    @POST("/works/api/v2/ticketing/tickets/push.json")
//    abstract Observable<APIResult> pushTickets(@Body List<Ticket> tickets);    
    
    @Headers({
        "content-type: application/json"
	})
    @POST("/works/api/v2/okticket/tickets/push")
    abstract Observable<APIResult> createAndPushTickets(@Body TSPTicketsRequest externalTickets);
}
