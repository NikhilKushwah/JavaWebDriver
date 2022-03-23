package JavaStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class WordsStartwithA
{

//	@Test
	public void regular()
	{
		ArrayList<String> names=new ArrayList<String>();
		names.add("Alison");
		names.add("Ram");
		names.add("Alex");
		names.add("Laxman");
		int count=0;
		for(int i=0; i<names.size(); i++)
		{
			String list= names.get(i);
			if(list.startsWith("A"))
			{
				count++;
			}
		}
		System.out.println(count);
	}
	
	//@Test // Creating another class using streamFilters
	public void streamFilter()
	{
		ArrayList<String> names=new ArrayList<String>();
        names.add("Alison");
		names.add("Ram");
		names.add("Alex");
		names.add("Laxman");
		
		// Introducing Stream converting ti into streams
		//.filter (s->s) it is  a lambda expression
		Long c=names.stream().filter(s->s.startsWith("A")).count();
		System.out.println(c);
		// instead of storing all the name into ArrayList we can store it into Streams
		long d=Stream.of("Alison","Ram","Alex","Laxman").filter(s->
		{
			s.startsWith("A"); // This is not giving the right output even in the course it is same
			return true; // If this is written false then it will not count 
		}).count();
		System.out.println(d);
		
		// printing the names which contains more letters then 4 using streams and lambda Expression
		//.forEach is a terminal operation which gives the results
		//names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		//if you want to print only one name which is greater then 4 letters
		names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
	}
	
	//@Test /// Creating one more class here for streamMap it is used to to uppercase or lowercase
	public void streamMap()
	{
		
		ArrayList<String> names=new ArrayList<String>();
        names.add("tom");
		names.add("bob");
		names.add("jack");
		
		
		//printing name with contains last letter "a" and converting it into uppercase using map 
		Stream.of("Alison","Rama","Alex","Laxmana").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		//creating arrayList and printing names which starts with a and in a sorted manner
		List<String> list=Arrays.asList("Alison","ARama","Ablex","Laxmana");
		list.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		//Merging 2 stream and making 1 big stream
		Stream<String> newStream=Stream.concat(names.stream(), list.stream());
		//newStream.sorted().forEach(s->System.out.println(s));  // we can not write on the stream again once it is modified
		boolean S=newStream.anyMatch(s->s.equalsIgnoreCase("Laxmana")); // This check and match the name is present or not in the List
		System.out.println(S);
		Assert.assertTrue(S);
		
	}
	@Test // creating another class collect helps to collect all the streams and convert it into list, set or map 
	public void streamCollect()
	{
		List<String> ls=Stream.of("Alison","Rama","Alex","Laxmana").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).collect(Collectors.toList());
		System.out.println(ls.get(1));
		
		// lets try it into integers suppose 
		List<Integer> values=Arrays.asList(3,8,12,7,9,12);
		// suppose interviewer ask to print a unique number and to sort the array so use distinct() to get unique number
		//values.stream().distinct().forEach(s->System.out.println(s));
		
		//if interviewer ask to return the 3rd index number
		List<Integer> li=values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(li.get(3));
		
	}
	
	
	
	
	
}
