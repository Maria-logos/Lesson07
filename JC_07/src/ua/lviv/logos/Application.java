package ua.lviv.logos;

import java.util.Scanner;

public class Application {
	
	static void menu()
	{
		System.out.println("Press 1 to ensure if such month exists");
		System.out.println("Press 2 to show all months from the same season");
		System.out.println("Press 3 to show all months with the same days count");
		System.out.println("Press 4 to show all months with the less days count");
		System.out.println("Press 5 to show all months with the more days count");
		System.out.println("Press 6 to show next season");
		System.out.println("Press 7 to show previous season");
		System.out.println("Press 8 to show all months with pair days count");
		System.out.println("Press 9 to show all months with unpair days count");
		System.out.println("Press 10 to show if month has pair days count");
	}

	public static void main(String[] args) {
		
		System.out.println("Enter month: ");
		
		Months [] monthMas = Months.values();
		Seasons [] seasonMas = Seasons.values();
		try (Scanner scan = new Scanner(System.in)) {
			String month = scan.next().toUpperCase();
			menu();
			
			while (true)
			{
				
				switch (scan.next())
				{
				    case "1":
					{
						if (null != monthExists(month))
						{
						    System.out.println("Such month exists! ");
						}
						
						
						break;
					}

					case "2":
					{
				        Months enteredMonth = monthExists(month);
						if (null != enteredMonth)
						{
							
							String monthString = "";
							for (Months m : monthMas)
							{
								if (m.getSeason().name().equals(enteredMonth.getSeason().name()))
								{
									monthString += m.name() + "  ";
								}
							}
							System.out.println("List of months with the same season : " + monthString);
						}
						
					}
					case "3":
					{
				        Months enteredMonth = monthExists(month);
						if (null != enteredMonth)
						{
							
							String monthString = "";
							for (Months m : monthMas)
							{
								if (m.getDays() == enteredMonth.getDays())
								{
									monthString += m.name() + "  ";
								}
							}
							System.out.println("List of months with the same days " + enteredMonth.getDays() + " count : " + monthString);
						}						
					}
					case "4":
					{
				        Months enteredMonth = monthExists(month);
						if (null != enteredMonth)
						{
							
							String monthString = "";
							for (Months m : monthMas)
							{
								if (m.getDays() < enteredMonth.getDays())
								{
									monthString += m.name() + "  ";
								}
							}
							System.out.println("List of months with the less then " + enteredMonth.getDays() + " days count : " + monthString);
						}						
					}
					case "5":
					{
				        Months enteredMonth = monthExists(month);
						if (null != enteredMonth)
						{
							
							String monthString = "";
							for (Months m : monthMas)
							{
								if (m.getDays() > enteredMonth.getDays())
								{
									monthString += m.name() + "  ";
								}
							}
							System.out.println("List of months with the more then " + enteredMonth.getDays() + " days count : " + monthString);
						}						
					}
					case "6":
					{
				        Months enteredMonth = monthExists(month);
						if (null != enteredMonth)
						{
							if (enteredMonth.getSeason().ordinal() == (seasonMas.length -1))
							{
								System.out.println("Next season " + seasonMas[0]);
							}
							else
							{
								System.out.println("Next season " + seasonMas[enteredMonth.getSeason().ordinal() + 1]);
							}
							
						}						
					}
					case "7":
					{
				        Months enteredMonth = monthExists(month);
						if (null != enteredMonth)
						{
							if (enteredMonth.getSeason().ordinal() == 0)
							{
								System.out.println("Next season " + seasonMas[seasonMas.length -1]);
							}
							else
							{
								System.out.println("Next season " + seasonMas[enteredMonth.getSeason().ordinal() - 1]);
							}
							
						}						
					}
					case "8":
					{
						String monthList = "";
						for (Months m : Months.values())
						{						    
							if (m.getDays() % 2 == 0)
								monthList += m.name() + " ";									
						}

					    System.out.println("All months with pair days count: " + monthList);			
					}
					case "9":
					{
						String monthList = "";
						for (Months m : Months.values())
						{						    
							if (m.getDays() % 2 == 1)
								monthList += m.name() + " ";									
						}

					    System.out.println("All months with unpair days count: " + monthList);			
					}
					case "10":
					{
						Months enteredMonth = monthExists(month);
						if (null != enteredMonth)
						{
							if (enteredMonth.getDays() % 2 == 0)
							{
								System.out.println("Month " + enteredMonth.name() + " has pair days count");
							}
							else
							{
								System.out.println("Month " + enteredMonth.name() + " has unpair days count");
							}
							
						}					
					}
				}
					
			
			// TODO Auto-generated method stub

			}
		}
	}

	private static Months monthExists(String month) {
		Months monthElement = null;
		monthElement = Months.valueOf(month);
		for (Months m : Months.values())
		{
		    
			if (m.name().equals(month))
		    	monthElement	 =  m;				
		
		}
		if (null == monthElement)
			System.out.println("Such month does not exist! ");
		return monthElement;
	}

}
