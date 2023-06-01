package bLogic;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.Superhero;

public class CreateObject {
	public static Superhero getObject(String jsonData) {
		try {
			// Create an ObjectMapper instance
			ObjectMapper objectMapper = new ObjectMapper();

			// Read the JSON string and map it to a List of Map<String, String>
			List<Map<String, String>> formFields = objectMapper.readValue(jsonData,
					new TypeReference<List<Map<String, String>>>() {
					});

			// Create a Superhero object and set its properties from the form data
			Superhero superhero = new Superhero();
			for (Map<String, String> field : formFields) {
				String fieldName = field.get("name");
				String fieldValue = field.get("value");

				// Skip the 'action' field
				if (fieldName.equals("action")) {
					continue;
				}

				// Set the corresponding property in the Superhero object
				// based on the field name
				switch (fieldName) {
				case "name":
					superhero.setName(fieldValue);
					break;
				case "alias":
					superhero.setAlias(fieldValue);
					break;
				case "gender":
					superhero.setGender(fieldValue);
					break;
				case "age":
					superhero.setAge(Integer.parseInt(fieldValue));
					break;
				case "powers":
					superhero.setPowers(fieldValue);
					break;
				case "team":
					superhero.setTeam(fieldValue);
					break;
				case "id":
					superhero.setId(Integer.parseInt(fieldValue));
					break;

				// Set other properties accordingly
				// ...
				}
			}

			// Process the superhero object as needed
			// ...

			// Return the appropriate response
			return superhero;
		} catch (IOException e) {
			// Handle any errors that occur during JSON deserialization
			e.printStackTrace();
			return null;
		}
	}

}
