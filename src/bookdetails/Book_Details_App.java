package bookdetails;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Book_Details_App 
{
   public static void main(String[] args) 
   {     /*the options for the process */
	   ArrayList< BookDetails> bookDetails=new ArrayList<>();
	   ArrayList< UserDetails> userDetailsList=new ArrayList<>();
	   ArrayList< IssueBook> issueBooklist=new ArrayList<>();
	   
	   UserDetails userdetails1=new UserDetails("A1","testa1","admin");
	   UserDetails userdetails2=new UserDetails("A2","testa2","admin");
	   UserDetails userdetails3=new UserDetails("A3","testa3","admin");
	   UserDetails userdetails4=new UserDetails("U1","testu1","user");
	   UserDetails userdetails5=new UserDetails("U2","testu2","user");
	   userDetailsList.add(userdetails1);
	   userDetailsList.add(userdetails2);
	   userDetailsList.add(userdetails3);
	   userDetailsList.add(userdetails4);
	   userDetailsList.add(userdetails5);
	   
	   for(int j=0;j<=10;j--)
	   {    
	     System.out.println("Enter 1 to add");
		 System.out.println("Enter 2 to delete");
		 System.out.println("Enter 3 to search ");
		 System.out.println("enetr 4 to Display books");
		 System.out.println("enter 5 to Serailization");
		 System.out.println("enter 6 to Deserailization");
		 System.out.println("enetr 7 to issue a book");
		 System.out.println("enetr 8 to Display issued books");
		 Scanner myObj = new Scanner(System.in);

		String number=myObj.nextLine(); 
		    switch(number)
		    {  
		    case "1":  /*To add a new book details*/
		    	System.out.println("how many books you wanted to add?");
		    	int numberOfBooksToAdd=myObj.nextInt(); 
		    	for(int i=0;i<numberOfBooksToAdd;i++)
		    	{
		    	addbookDetails(bookDetails);
		    	System.out.println("Book details added successfully");
		    	}
		    break;  
		    case "2": /* To delete a book details*/
		        {
		    	System.out.println("enter the Book Id:");
		    	String bookIdToDelete=myObj.nextLine();
		    	deletebookDetails(bookDetails,bookIdToDelete);
		        }
		    	
		    break;  
		    case "3": /* To search book details by book name or book writter*/
		        {
		    	System.out.println("search the book by");
		    	System.out.println("Enter 1 to search by Book Name");
		    	System.out.println("Enter 2 to search by Book writter");
		    	String searchBy=myObj.nextLine();
		    	SearchbookDetails(bookDetails,searchBy);
		        }
		    break; 
		    case "4": System.out.println(bookDetails);
		    break; 
		    case "5": serialization(bookDetails);
		    break; 
		    case "6": deserialization();
		    break; 
		   case "7": issueBook(userDetailsList,bookDetails,issueBooklist);
		   break;
		    case "8": System.out.println(issueBooklist);
		    break;
		    default:System.out.println("Not found");  
		    }
	   }
   }
     
 private static void issueBook(ArrayList<UserDetails> userDetailsList, ArrayList<BookDetails> bookDetails, ArrayList<IssueBook> issueBooklist) {
    Scanner myObj = new Scanner(System.in);
	System.out.println("validating login details of admin to issue a book");
	System.out.println("please enter userId");
	String userId=myObj.nextLine();
	System.out.println("Please enter Password");
	String userpassword=myObj.nextLine();
	for (UserDetails userDetails: userDetailsList)
	{
		if(userDetails.getUserId().equalsIgnoreCase(userId) && userDetails.getPassword().equalsIgnoreCase(userpassword) && userDetails.getRole().equalsIgnoreCase("admin"))
		{
			System.out.println("please enter a bookId to issue ");
			String bookId=myObj.nextLine();
			for(BookDetails book:bookDetails)
			{
				if(bookId.equalsIgnoreCase(book.getBookId()))
				{
					System.out.println("book ID: "+bookId+" issued successfully");
					issueBooklist.add(new IssueBook(bookId, userId));
					return;
				}
			}
		}
	}
	System.out.println("You dont have access to issue a book");
}



private static void deserialization() {

       ArrayList<BookDetails> bookDetails = new ArrayList<>();
        
       try
       {
           FileInputStream fis = new FileInputStream("bookDetails");
           ObjectInputStream ois = new ObjectInputStream(fis);

           bookDetails = (ArrayList) ois.readObject();

           ois.close();
           fis.close();
       } 
       catch (IOException ioe) 
       {
           ioe.printStackTrace();
           return;
           
       } 
       catch (ClassNotFoundException c) 
       {
           System.out.println("Class not found");
           c.printStackTrace();
           return;
       }
        
       //Verify list data
       for (BookDetails book : bookDetails) {
           System.out.println(book);
       }
}
private static void serialization(ArrayList<BookDetails> bookDetailsList) {
	   try
       {
		   FileOutputStream fos = new FileOutputStream("bookDetails");
           ObjectOutputStream oos = new ObjectOutputStream(fos);
           oos.writeObject(bookDetailsList);
           oos.close();
           fos.close();
           System.out.println("serailization is successful");
       } 
       catch (IOException ioe) 
       {
           ioe.printStackTrace();
       }
		  }  
//To add a new book details to the list start
   public static void addbookDetails(ArrayList<BookDetails> bookDetails)
   {   
	   Scanner myObj = new Scanner(System.in);
	   BookDetails book=new BookDetails();
	     System.out.println("Enter the bookId");
        String bookId=myObj.nextLine(); 
        System.out.println("Eneter the bookName");
        String bookName=myObj.nextLine(); 
        System.out.println("Eneter the writerName");
        String writerName=myObj.nextLine();
        System.out.println("Eneter the price");
        int price=myObj.nextInt();
        System.out.println("Eneter the quantity");
        int quantity=myObj.nextInt();
        
        book.setBookId(bookId);
        book.setBookName(bookName);
        book.setPrice(price);
        book.setWriterName(writerName);
        book.setQuantity(quantity);
        bookDetails.add(book);
   }
   //To add a new book details to the list end
   //To delete book details from the list start
   public static void deletebookDetails(ArrayList<BookDetails> bookDetails, String bookIdToDelete)
   {
	   ArrayList<BookDetails> totalBooks=bookDetails;
	   for(BookDetails book:bookDetails)
	   {
		   if(book.getBookId().equalsIgnoreCase(bookIdToDelete))
		   {
			   totalBooks.remove(book);
			   System.out.println("book with bookId  "+bookIdToDelete+" deleted successfully");
			   break;
		   }
	   }
	   
   }
    //To delete book details from the list end
   //To search book details by book name or writter name start
   public static void SearchbookDetails(ArrayList<BookDetails> bookDetails, String searchBy)
   {
	   Scanner myObj = new Scanner(System.in);
	   switch(searchBy){  
	    case "1":
	    	System.out.println("please enter the book name");
	    	String bookName=myObj.nextLine();
	   for(BookDetails book:bookDetails)
	   {
		   if(book.getBookName().equalsIgnoreCase(bookName))
		   {
			   
			   System.out.println("book details  for given book name "+bookName+"\n"+bookDetails);
			   return;
		   }
	   }
	   System.out.println("book with bookName  "+bookName+"  not found");
	   break;
	    case "2":
	    	System.out.println("please enter the writter name");
	    	String writterName=myObj.nextLine(); 
	    	 for(BookDetails book:bookDetails)
	  	   {
	  		   if(book.getWriterName().equalsIgnoreCase(writterName))
	  		   {
	  			   
	  			   System.out.println("book deatils for given writter name  "+writterName+"\n"+bookDetails);
	  			   return;
	  			   
	  		   }
	  	   }
	       System.out.println("book with writterName  "+writterName+"  not found");
	       
	       
	   }
   }  //To search book details by book name or writter name end
 



}



   
   
   
   
   

