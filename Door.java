//*******************************
//Name: Danielle Coulter
//Title: Door.java (with Lab5.java)
//Description: Classes
//Time spent: 3 hours
//Date: 11/10/2016
//*******************************

public class Door{

	//Since we're testing the "Door" Class methods @param args are not used
	public String stateOfdoor; //Either open or closed
	private String nameOfdoor; //Name of door
	public Door(String nameOfdoor, String stateOfdoor)
	{
		 
		// Initialize name of door
		this.nameOfdoor = nameOfdoor;
		this.stateOfdoor = stateOfdoor;
	}
	
	public String getStateOfDoor(){
		
		return stateOfdoor;
	}
	
	public void setStateOfdoor(String stateOfdoor){
		
		this.stateOfdoor = stateOfdoor;
	}
	
	public void setNameOfdoor (String nameOfdoor){
		
		this.nameOfdoor = nameOfdoor;
	}
	
	public String getNameOfdoor(){
		
		return nameOfdoor;
	}
	
	public void openDoor(){
		
		if (stateOfdoor.equals("open"))
		{
			System.out.println("Door is opened.");
		}
		else{
			stateOfdoor = "open";
			System.out.println("Door is now opening...");
		}//end "open door" if statement
	}
	
	public void closeDoor(){
			
			if (stateOfdoor.equals("open"))
			{
				stateOfdoor = "closed";
				System.out.println("The door is now closing...");
			}
			else{
				System.out.println("The Door is closed.");
			}//end of "close door" if statement
		}
	
	public String toStirngs(){
		
		return "Door Name: " + nameOfdoor + '\n' + "StateOfdoor; " + stateOfdoor;
	}
}

