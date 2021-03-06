package shop.services;


import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import shop.domain.Customer;
import shop.domain.Customers;

/**
 * @author <a href="mailto:bill@burkecentral.com">Bill Burke</a>
 * @version $Revision: 1 $
 */
@Path("/customers")
public interface CustomerResource
{
   @POST
   @Consumes("application/xml")
   Response createCustomer(Customer customer, @Context UriInfo uriInfo);

   @GET
   @Produces("application/xml")
   Customers getCustomers(@QueryParam("start") int start,
                          @QueryParam("size") @DefaultValue("2") int size,
                          @QueryParam("firstName") String firstName,
                          @QueryParam("lastName") String lastName,
                          @Context UriInfo uriInfo);

   @GET
   @Path("{id}")
   @Produces({"application/xml", "application/json"})
   Customer getCustomer(@PathParam("id") int id);
}
