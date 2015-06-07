package comp102x.project.task;

public class CharValidator {
	
	public boolean validateChar(char c) {
		String character = Character.toString(c);
		if(character.matches("[a-zA-Z0-9]+$"))
		{
		    return true;
		  }
		
		return false;
	}

}
