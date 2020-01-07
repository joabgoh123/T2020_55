package com.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.demo.bean.Customer;
import com.demo.bean.Transaction;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class HelloController {
	/*
	 * UserService userService = new UserService();
	 * 
	 * @RequestMapping("/list") public @ResponseBody List<User> index() { List<User>
	 * users = userService.getAllUsers(); return users; }
	 * 
	 */
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView frontPage(ModelMap model) {
		ModelAndView modelView = new ModelAndView("index");
		return modelView;
	}
	
	@RequestMapping(value = "/listOne", method = RequestMethod.GET)
	public ModelAndView listOne(ModelMap model, @RequestParam String id) {
		ModelAndView modelView = new ModelAndView("listOne");
		modelView.addObject(id);
		return modelView;
	}

	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public ModelAndView listAll(ModelMap model) {
		ModelAndView modelView = new ModelAndView("listAll");
		return modelView;
	}
	
	@RequestMapping(value = "/listAllTransaction", method = RequestMethod.GET)
	public ModelAndView listAllTransaction(ModelMap model,@RequestParam String id ,@RequestParam String fromDate ,@RequestParam String toDate ) {
		ModelAndView modelView = new ModelAndView("listAllTransactions");
		modelView.addObject(id);
		modelView.addObject(fromDate);
		modelView.addObject(toDate);
		return modelView;
	}

	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public @ResponseBody Customer getOneCustomer(@RequestParam String id) {
		System.out.println(id);
		final String uri = "http://techtrek-api-gateway.ap-southeast-1.elasticbeanstalk.com/customers/"+ id +"/details";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Identity", "T13");
		headers.set("Token", "44d7fd0b-c154-40b2-b8bc-890f9eca6f67");
		RestTemplate restTemplate = new RestTemplate();

		HttpEntity<String> entity = new HttpEntity<String>("body", headers);
		ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
		String result = response.getBody();
		ObjectMapper mapper = new ObjectMapper();
		Customer obj = null;
		try {
			obj = mapper.readValue(result, Customer.class);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}

	@RequestMapping(value = "/allCustomers", method = RequestMethod.GET)
	public @ResponseBody List<Customer> allCustomers() {
		List<Customer> allCustomers = new ArrayList<Customer>();
		for (int i = 1; i <= 3; i++) {
			String uri = "http://techtrek-api-gateway.ap-southeast-1.elasticbeanstalk.com/customers/" + i + "/details";
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.set("Identity", "T13");
			headers.set("Token", "44d7fd0b-c154-40b2-b8bc-890f9eca6f67");
			RestTemplate restTemplate = new RestTemplate();

			HttpEntity<String> entity = new HttpEntity<String>("body", headers);
			ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
			String result = response.getBody();
			ObjectMapper mapper = new ObjectMapper();
			Customer obj = null;
			try {
				obj = mapper.readValue(result, Customer.class);
				allCustomers.add(obj);
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(allCustomers);
		return allCustomers;
	}

	@RequestMapping(value = "/getTransactions", method = RequestMethod.GET)
	public @ResponseBody List<Transaction> getTransactionDetails(@RequestParam String id, @RequestParam String fromDate, @RequestParam String toDate) {

		List<Transaction> getAllTransactions = new ArrayList<Transaction>();
		String uri = "http://techtrek-api-gateway.ap-southeast-1.elasticbeanstalk.com/transactions/"+id+"?from="+fromDate+"&to="+toDate;
		System.out.println(uri);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Identity", "T13");
		headers.set("Token", "44d7fd0b-c154-40b2-b8bc-890f9eca6f67");
		RestTemplate restTemplate = new RestTemplate();
	    
		HttpEntity<String> entity = new HttpEntity<String>("body", headers);
		ResponseEntity<List<Transaction>> transactions = restTemplate.exchange(uri, HttpMethod.GET, entity, new ParameterizedTypeReference<List<Transaction>>() {
		});
		getAllTransactions = transactions.getBody();
	    return getAllTransactions;		
	}
}
