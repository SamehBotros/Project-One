package com.revature.projectone.dao;

import com.revature.projectone.pojo.ErrorPojo;
import com.revature.projectone.pojo.RequestPojo;
import com.revature.projectone.pojo.UsersPojo;
import com.revature.projectone.service.RequestServicEmpliment;
import com.revature.projectone.service.RequestServicList;
import com.revature.projectone.service.UsersServicEmpliment;
import com.revature.projectone.service.UsersServicList;

import exception.ApplicationException;
import io.javalin.Javalin;

public class RequestControlerMain {

	public static void main(String[] args) {

		// pathParam - http://localhost:4040/api/request/3
		// queryParam - http://localhost:4040/api/request/Id=5&req_flag=true

		RequestServicList requestServic = new RequestServicEmpliment();
		UsersServicList usersServic = new UsersServicEmpliment();

		// Javalin has embedded server
		// config.enableCorsForAllOrigins() to stop the blocked by CORS Policy because
		// Browser stop request from server to another server
		Javalin server = Javalin.create((config) -> config.enableCorsForAllOrigins()).start(4040);

		// Javalin server = Javalin.create(). start(4040);

		// http://localhost:4040/MyFirstEndPint
		// two argument string and callback function
		server.get("MyFirstEndPint", (ctx) -> {
			// callback function tell here what to do when the hello endpoint is requested
			// for
			System.out.println("Hello endpoint is requested!!");
			ctx.result("Hello endpoint For test!!");
		});
		// ----------- add request------------------------------------------------------------------------------------------

		// post endpoint to add request
		// http://localhost:4040/api/request
		server.post("api/request", (ctx) -> {
			RequestPojo returnRequestPojo = requestServic.addRequest(ctx.bodyAsClass(RequestPojo.class));
			System.out.println(returnRequestPojo);
			// json take the object and convert to json
			ctx.json(returnRequestPojo);
		});

		// -----------update user Profile-----------------------------------------------------------------------------------

		// end point to update user Profile
		// http://localhost:4040
		// resource or front point
		// api/users/update/2
		server.put("api/users/update/{userId}", (ctx) -> {
			UsersPojo updateProfile = usersServic.updateUserProfile(ctx.bodyAsClass(UsersPojo.class));
			ctx.json(updateProfile);
		});

		// ------------View all Pending Request------------------------------------------------------------------------------

		// http://localhost:4040/api/request/pending
		server.get("api/request/pending", (ctx) -> {
			ctx.json(requestServic.allPendingRequsts());
		});
		// ------------- View all Resolved Request---------------------------------------------------------------------------

		// http://localhost:4040/api/request/resolve
		server.get("api/request/resolve", (ctx) -> {
			ctx.json(requestServic.allResolvedRequsts());
		});
		// ---------------approve Request-------------------------------------------------------------------------------------

		// http://localhost:4040/api/request
		server.patch("api/request/{reqId}", (ctx) -> {
			ctx.json(requestServic.approveRequest(Integer.parseInt(ctx.pathParam("reqId"))));
		});
		// ---------------reject Request--------------------------------------------------------------------------------------

		// http://localhost:4040/api/request/reject
		server.patch("api/request/reject/{reqId}", (ctx) -> {
			ctx.json(requestServic.removeRequest(Integer.parseInt(ctx.pathParam("reqId"))));
		});

		// ---------------User Resolve Request---------------------------------------------------------------------------------

		// http://localhost:4040/api/request/resolve/2
		server.get("api/request/resolve/{reqId}", (ctx) -> {
			ctx.json(requestServic.userResolveRequest(Integer.parseInt(ctx.pathParam("reqId"))));
		});

		// ------------------ User Pending Requesters--------------------------------------------------------------------------

		// http://localhost:4040/api/request/pend/4
		server.get("api/request/pend/{reqId}", (ctx) -> {
			ctx.json(requestServic.userPendingRequestes(Integer.parseInt(ctx.pathParam("reqId"))));
		});

		// -----------------SpecificRequest--------------------------------------------------------------------------------------

		// http://localhost:4040/api/request/spacific/
		server.get("api/request/spacific/{reqId}", (ctx) -> {
			ctx.json(requestServic.spacificEmployeeRequests(Integer.parseInt(ctx.pathParam("reqId"))));
		});

		// --------------------Login---------------------------------------------------------------------------------------------

		// http://localhost:4040/api/users/login
		server.post("api/users/login", (ctx) -> {
			System.out.print(ctx.bodyAsClass(UsersPojo.class));
			UsersPojo userPojo = usersServic.logIn(ctx.bodyAsClass(UsersPojo.class));
			// json take the object and convert to json
			ctx.json(userPojo);
		});

		// ---------------getUserByName------------------------------------------------------------------------------------------

		// http://localhost:4040/api/users/byusername
		server.post("api/users/byusername", (ctx) -> {
			System.out.print(ctx.bodyAsClass(UsersPojo.class));
			UsersPojo userPojo = usersServic.getUserByName(ctx.bodyAsClass(UsersPojo.class));
			// json take the object and convert to json
			ctx.json(userPojo);
		});

		// -----------------user Profile-------------------------------------------------------------------------------------------

		// http://localhost:4040/api/users/profile
		server.get("api/users/profile/{userId}", (ctx) -> {
			ctx.json(usersServic.userProfile(Integer.parseInt(ctx.pathParam("userId"))));
		});

		// ---------------all Employees---------------------------------------------------------------------------------------------

		// http://localhost:4040/api/users/employee
		server.get("api/users/employee", (ctx) -> {
			ctx.json(usersServic.allEmployees());
		});

		// ----------- register ----------------------------------------------------------------------------------------------------

		// post endpoint to add request
		// http://localhost:4040/api/users/register
		server.post("api/users/register", (ctx) -> {
			UsersPojo userPojo = usersServic.register(ctx.bodyAsClass(UsersPojo.class));
			ctx.json(userPojo);
		});
		
		
		// ------------exeption ------------------------------------------------------------------------------------------------------

		// what has to be done if an exeption happend
		server.exception(ApplicationException.class, (ae, ctx) -> {
			ErrorPojo error = new ErrorPojo();
			error.setErrorMessage(ae.getMessage());
			ctx.json(error).status(500);
		});

	}

}
