package org.mifos.processor.bulk.camel.routes;


import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.util.json.JsonArray;
import org.springframework.stereotype.Component;

@Component
public class Routes extends RouteBuilder {


    @Override
    public void configure() throws Exception {
        routeCheckTransactions();
        routeSampleTransactions();
    }

    private void routeCheckTransactions(){
        String id = "check-transactions";
        from("direct:"+id)
                .id(id)
                .log("Fetching transaction details")
                //set request params
                .to("/api/v1/batch/transactions")
                .process(exchange -> {
                    // get response body
                    // check successful transactions >= x%
                    // set zeebe variable readyForSample = true
                });
    }

    private void routeSampleTransactions(){
        String id = "sample-transactions";
        from("direct:" + id)
                .id(id)
                .log("Fetching transaction details")
                //set request params
                .to("/api/v1/batch/transactions")
                .process(exchange -> {
                    // get response body
                    // sample transactions
                    // store the sampled transaction ids in zeebe variable
                });
    }
}
