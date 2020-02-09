//Author: Evy Eve
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

class Main {

  public static void main(String[] args) throws FileNotFoundException, IOException {
		
		HashMap<String, String> country = new HashMap<String, String>();
		try
		{
			//Using BufferedReader class to FileReader to read from csv & store in hashmap
			BufferedReader br = new BufferedReader(new FileReader("countryCodes.csv"));
			String line = "";
			while((line = br.readLine()) != null)
			{
				String[] codes = line.split(",");
				country.put(codes[0], codes[1]);
			}
			br.close(); //Close BufferedReader after reading from file
    }
		//Catch FileNotFoundException if file can't be located
		catch(FileNotFoundException prg)
		{
			System.err.println("Error - Program Terminated: " + prg.toString());
		}

    //Using Scanner to read user input
			Scanner sc = new Scanner(System.in);
			String answer = "", name = "";
      
      while(!answer.toLowerCase().contains("n")) {

        System.out.println("Enter a country's name or the ISO Alpha Code: ");
        name = sc.nextLine();

			//Check to see if country code is valid key in hashmap
			if(name.length() == 3 && country.containsKey(name.toUpperCase()))
			{
				System.out.println("Country Code: " + name.toUpperCase() + "\nCountry Name: " + country.get(name.toUpperCase()));
			}
			//Check to see if value entered is valid country name in hashmap
			else
			{
				//Searches through keyset to see if value is in hashmap then print out key & value
				for(String key : country.keySet())
				{
					//compares value in hashmap to value entered
					if(country.get(key).toLowerCase().equals(name.toLowerCase()))
					{ 
						System.out.println("Country Code: " + key + "\nCountry Name: " + country.get(key));
					}
          while(country.get(key).toLowerCase().contains(name.toLowerCase()) && !answer.toLowerCase().contains("y"))
          {
            System.out.print("Did you mean: ");
            System.out.println(country.get(key));
            System.out.print("Yes or No? :");
	  	      answer = sc.nextLine();

            if(answer.toLowerCase().contains("y"))
            {
              System.out.println("Country Code: " + key + "\nCountry Name: " + country.get(key));
            }
            break;
          }
        }
      }
      System.out.println("Would you like to check again? Or \"no\" to exit " );
	  	answer = sc.nextLine();
      
      if(answer.toLowerCase().contains("n"))
      {
        sc.close();
        System.out.println("Program terminated");
        break;
      }
      answer="";
		}
	}
}