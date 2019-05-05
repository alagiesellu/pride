package com.filter.iguru;

import java.io.FileNotFoundException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/* 
 * Service URL : http://localhost:8080/SpamFilterService/rest/email/{mail subject}/{mail message}
 * 
 * {mail subject} should be NULL if mail dosen't have a subject.
*/

@Path("email")
public class SpamService {

	@GET
	@Path("{sub}/{msg}")
	@Produces(MediaType.TEXT_PLAIN)
	public String mail(@PathParam("sub") String subject, @PathParam("msg") String msg) throws FileNotFoundException {

		ScannerFactory scannerFactory = new ScannerFactory();

		// get object of WithSubject class or WithoutSubject class
		SpamScanner scanMsg = scannerFactory.getScanner(subject);

		// scan mail
		scanMsg.scan(subject, msg);

		// return scan results
		return scanMsg.result();

	}

}
