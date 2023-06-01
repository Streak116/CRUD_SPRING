package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import bLogic.CreateObject;
import bLogic.Fetch;
import dao.SuperDAO;
import model.Superhero;

@Controller
public class CRUD {

	SuperDAO sd;

	@Autowired
	public CRUD(SuperDAO shd) {
		sd = shd;
	}

	@RequestMapping(value = "/crudddd", method = { RequestMethod.GET,
			RequestMethod.POST }, consumes = "application/json")
	public @ResponseBody Superhero handleRequest(@Validated @RequestBody(required = false) Superhero superhero,
			Model model) {
		if (superhero != null) {
			System.out.println("In Controller (POST)");

			// Access the form data from the 'superhero' parameter
			String name = superhero.getName();

			// Create a new Superhero object
			Superhero response = new Superhero();
			response.setName(name);

			// You can perform further operations with the received data

			// Return the response object
			return response;
		} else {
			System.out.println("In Controller (GET)");

			// Handle GET request logic here

			// Return appropriate response
			return null;
		}
	}

	// Other methods for handling additional request methods if needed

	@PostMapping("/ccrud") // correct one
	@ResponseBody
	public String handleFormSubmissio2n(@RequestBody String formData) {
		// Process the form data and concatenate string values
		// You can customize the logic here based on your requirements
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			Superhero superhero = objectMapper.readValue(formData, Superhero.class);
			return superhero.getName();
		} catch (Exception e) {
			System.out.println(e);
		}
		// Return the concatenated result
		return "Seting";
	}

	@PostMapping("/crrud")
	@ResponseBody
	public String handleFormSubmission3(@ModelAttribute Superhero superhero) {
		// Process the form data
		// You can customize the logic here based on your requirements
		String result = "Received superhero: " + superhero.getName();

		// Return the result
		return result;
	}

	@PostMapping("/add")
	@ResponseBody
	public String addReacord(@RequestBody String jsonData, String action) {
		CreateObject o = new CreateObject();
		Superhero s = CreateObject.getObject(jsonData);
		System.out.println(s);
		Fetch.add(s, sd);

		return "Record added. click read";
	}

	@PostMapping("/read")
	@ResponseBody
	public String readReacord(@RequestBody String jsonData, String action) {
		List<Superhero> superheroes = Fetch.fetchAllRecords(sd);
		ObjectMapper om = new ObjectMapper();
		try {
			String json = om.writeValueAsString(superheroes);
			System.out.println(json);
			return json;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	@PostMapping("/delete")
	@ResponseBody
	public String deleteReacord(@RequestBody String jsonData, String action) {
		CreateObject o = new CreateObject();
		Superhero s = CreateObject.getObject(jsonData);
		Fetch.delete(s, sd);
		return "Record deleted. click read";

	}

	@PostMapping("/edit")
	@ResponseBody
	public String editReacord(@RequestBody String jsonData, String action) {
		CreateObject o = new CreateObject();
		Superhero s = CreateObject.getObject(jsonData);
		Fetch.edit(s, sd);
		return "Record edited. click read";

	}

}
