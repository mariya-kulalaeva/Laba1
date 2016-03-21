/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesapp;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
public class FilesApp {

    public static void main(String[] args) throws FileNotFoundException, IOException {
		//FileNotFoundException-сообщение об ошибке при открытии "левого" файла, IOException-для ввода/вывода данных
		char ignore;//Если без игнор, то shop menu вылетает 3 раза 
	 char choice;	// выбор параметров меню в магазине
		 for (; ; ) //бесконечный цикл, так как меню должно быть бесконечным
  { do {
 System.out.println("Shop Menu");
System.out.println (" 1. Sold products");
 System.out.println(" 2. Sell Products");
 System.out.println(" 3. Details ");
 System.out.println(" 4. Exit ");
 System.out.println("  Enter number ");
 choice = (char) System.in.read();
 do { ignore = (char) System.in.read(); } while(ignore != '\n'); 
  } while( choice < '1' | choice > '3' & choice != '4');
  if (choice == '4') break;
 switch (choice) {
	 case '1':
	 {

System.out.println("Our Shop. All of our products");

		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		File file = new File("C:\\Users\\user\\Downloads\\test10.txt");
		try {
        //проверяем, что если файл не существует то создаем его
        if(!file.exists()){
            file.createNewFile();
        }
		//PrintWriter обеспечит возможности записи в файл
		 PrintWriter out = new PrintWriter(file.getAbsoluteFile());
       
            try(FileReader reader = new FileReader("C:\\Users\\user\\Downloads\\test.txt"))// выделяется память и указываем путь к файлу
        {   Scanner sc= new Scanner( new File ("C:\\Users\\user\\Downloads\\test.txt")); 
		sc.useDelimiter(";");
			
           // читаем посимвольно
            int c;
			int j=0;
			int i=0;
			list.add(new ArrayList<String>()); //Добавление элементов в массив, так как двумерный массив, то выделяется память под новую строку
             ArrayList<Integer> arrayListOfInteger= new ArrayList<Integer>();			// для того чтобы считать количество на складе в интеджер
            while((c=reader.read())!=-1)
			{//Считывает символы до конца строки, конец строки -1, проверяем, где конец файла
                 
				 if (sc.hasNext())//hasNext - если есть следующее слово, то дальше до ;  вернет true или false
				 {
					  if (j==3)
					 {
						 String Data = sc.next();
						  list.get(i).add(Data);
						  String ra= list.get(i).get(j);
						 if (i>0)// так как строчка с number не нужна
						 {
							 out.println(ra);
						 }
            //Записываем текст в файл
            
        
							j++;
							i++;
							j=0;
						 list.add(new ArrayList<String>());
					 }
					else{
					 
					 String Data = sc.next();//Считываем по словам 
					 
					 list.get(i).add(Data);//записывает слова из файла в наш list
					 j++;
					 if (j==4)
					 {
						 j=0;
						 i++;
						 list.add(new ArrayList<String>());//так как всего 4 столбца, то при достижении j=4, создаем новый список
					 }
				 }
				 }
            } 
        }
        catch(IOException ex){//Если файл не открылся
             
            System.out.println(ex.getMessage());//Сообщение об ошибке
        } 
finally {
            // После чего мы должны закрыть файл
            out.close();
        }
} catch(IOException e) {
        throw new RuntimeException(e);
    }		
	list.remove(list.size()-1);
		 int m= list.size(); //количество строк в двумерном массиве
		for (int k=0; k<m; k++) //строчки
		{
			for (int n=0; n<4; n++)//столбцы
			{
			System.out.print(list.get(k).get(n));
			}
			System.out.println();
		}
		
		// считать продажи предыдущие
		File files = new File("C:\\Users\\user\\Downloads\\test3.txt");
		 ArrayList<ArrayList<String>> list1 = new ArrayList<ArrayList<String>>();
        //проверяем, что если файл не существует то создаем его
        if(!files.exists()){
            files.createNewFile();
        }
		else
		{
			try(FileReader read1 = new FileReader("C:\\Users\\user\\Downloads\\test3.txt"))// выделяется память и указываем путь к файлу
        {   Scanner scan1= new Scanner( files); 
		scan1.useDelimiter(";");
		 int count1=0;
		 int ja=0;
		 int ia=0;
		 list1.add( new ArrayList<String>());
		 while((count1=read1.read())!=-1)
			{//Считывает символы до конца строки, конец строки -1, проверяем, где конец файла
                 
				 if (scan1.hasNext())//hasNext - если есть следующее слово, то дальше до ;  вернет true или false
				 {
					  if (ja==3)
					 {
						 String Data = scan1.next();
						  list1.get(ia).add(Data);
						 
            
        
							ja++;
							ia++;
							ja=0;
						 list1.add(new ArrayList<String>());
					 }
					else{
					 
					 String Data = scan1.next();//Считываем по словам 
					 
					 list1.get(ia).add(Data);//записывает слова из файла в наш list
					 ja++;
					}
		}
			}
		}
		 catch(IOException ex){//Если файл не открылся
             
            System.out.println(ex.getMessage());//Сообщение об ошибке
        } 
		
		list1.remove(list1.size()-1);
		}
		char answer,ignor;
		do{
			
			 System.out.println("Do you want to buy something of it? 1- Yes 0-No");
          answer = (char)System.in.read();
		  do {ignor=(char)System.in.read();} while( ignor != '\n'); 
		}  while (answer<'0' & answer>'1' );
		 int numbersold=0;	
		
  while (answer=='1')
  {
	 
	  System.out.println("Enter id of product");
	   Scanner sc1 = new Scanner(System.in);//Сканер можно использовать не только для ввода из файла, но и для простого ввода с клавиатуры
	   String Id;
	   Id = sc1.nextLine();// сделать сравнение перевод из стринг в инт через файл
	  
        int i2 = Integer.valueOf(Id);//перевод в int из string
		
		
		File fileid= new File("C:\\Users\\user\\Downloads\\fileid.txt");
		 if(!fileid.exists()){
            fileid.createNewFile();
        }
		 PrintWriter outid = new PrintWriter(fileid.getAbsoluteFile());
		 for(int index=1; index<list.size(); index++)
		 {
			 outid.print(list.get(index).get(0));
		 }	
         outid.close();	
         		 
			FileReader reader2 = new FileReader("C:\\Users\\user\\Downloads\\fileid.txt"); 
          Scanner scint= new Scanner( new File ("C:\\Users\\user\\Downloads\\fileid.txt")); 
		int cac;
		 ArrayList<Integer> listinteger= new ArrayList<Integer>();
		 while((cac=reader2.read())!=-1)
			{//Считывает символы до конца строки, конец строки -1, проверяем, где конец файла
                 
				 if (scint.hasNext())//hasNext - если есть следующее слово, то дальше до ;  вернет true или false
				 {
				    int data = scint.nextInt();
						 listinteger.add(data);
				 }
			}
			int indexn=0;
			for (int irt=0; irt<listinteger.size(); irt++)
	  {
		  if (i2==listinteger.get(irt))
		  {
			  indexn=irt+1;
		  }
	  }		
	   if (indexn==0)
	   {
		    System.out.println("We have no product");
	   }
	      else
	   { 
		FileReader reader1 = new FileReader("C:\\Users\\user\\Downloads\\test10.txt");
	  Scanner sc3= new Scanner(new File ("C:\\Users\\user\\Downloads\\test10.txt"));
	  ArrayList<Integer> list2 = new ArrayList<Integer>();
	  int ca=0;
	  while((ca=reader1.read())!=-1)
	  {
	  				 if (sc3.hasNext())
					 {
						 int datafail = sc3.nextInt();
						 list2.add(datafail);
						 
					 }
	  }
	   System.out.println("Enter number ");
	   Scanner sc2= new Scanner(System.in);
        String num;
         num= sc2.nextLine();	
		 int i3 = Integer.valueOf(num);
		 if (i3>list2.get(indexn-1))
		 {
			 System.out.println("We havent this number of products");
		 }
		 else
		 {  
	        	numbersold=list1.size();	
	  list1.add(new ArrayList<String>());// добавляет новую строку
	  list1.get(numbersold).add(Id);//добавляем id продажи в list1
	  for (int ir=1; ir<3;ir++)
	  {
	  list1.get(numbersold).add(list.get(indexn).get(ir));//записываем в list1 соответствующие данные по id продуктам
	  }
			 int i4 = list2.get(indexn-1)-i3;
			 String str5= Integer.toString(i4);
         list1.get(numbersold).add(num);		 
		 list.get(indexn).set(3,' '+str5);
		 
		 File file1 = new File("C:\\Users\\user\\Downloads\\test10.txt");
		 numbersold++;
		try {
        //проверяем, что если файл не существует то создаем его
        if(!file1.exists()){
            file1.createNewFile();
        }
		//PrintWriter обеспечит возможности записи в файл
		 PrintWriter out = new PrintWriter(file1.getAbsoluteFile());
       try {
            //Записываем текст у файл
			for (int ka=0;ka<list2.size();ka++)
			{
				String Data=list.get(ka+1).get(3);
				 out.println(Data);
			}
           
        } 
		finally {
            //После чего мы должны закрыть файл
           
            out.close();
        }
    } catch(IOException e) {
        throw new RuntimeException(e);
    }
		 
		 }
	  }
	do{
			
			 System.out.println("Do you want to buy something of it? 1- Yes 0-No");
          answer = (char)System.in.read();
		  do {ignor=(char)System.in.read();} while( ignor != '\n'); 
		}  while (answer<'0' & answer>'1' );  
		}
  File file2 = new File("C:\\Users\\user\\Downloads\\test.txt");
  PrintWriter out2 = new PrintWriter(file2.getAbsoluteFile());
  try {
        //проверяем, что если файл не существует то создаем его
        if(!file2.exists()){
            file2.createNewFile();
        }
		//PrintWriter обеспечит возможности записи в файл
		 
 	
  for (int irac=0; irac<list.size(); irac++)
  {
	  for (int jay=0; jay<4; jay++)
	  
	  {
		  String ra1=list.get(irac).get(jay)+';';
		 out2.print(ra1);
	  }
  }
  }
  finally {
            //После чего мы должны закрыть файл
           
            out2.close();
        }
	
	File file3 = new File("C:\\Users\\user\\Downloads\\test3.txt");
		 PrintWriter out3 = new PrintWriter(file3.getAbsoluteFile());
 	
  for (int irac=0; irac<list1.size(); irac++)
  {
	  for (int jay=0; jay<4; jay++)
	  
	  {
		  String ra1=list1.get(irac).get(jay)+';';
		 out3.print(ra1);
	  }
	 
  }
  out3.close();
	 }
  break;
  
  case '2':
{
	 ArrayList<ArrayList<String>> list3 = new ArrayList<ArrayList<String>>();
	  int c;
	  File file5 = new File("C:\\Users\\user\\Downloads\\test9.txt");
	  PrintWriter out = new PrintWriter(file5.getAbsoluteFile());
  try(FileReader reader = new FileReader("C:\\Users\\user\\Downloads\\test.txt"))// выделяется память и указываем путь к файлу
        {   Scanner sc= new Scanner( new File ("C:\\Users\\user\\Downloads\\test.txt")); 
		sc.useDelimiter(";");
		list3.add(new ArrayList<String>());
		int ii=0;
		int jj=0;
		 while((c=reader.read())!=-1)
		 {
			 if (sc.hasNext())//hasNext - если есть следующее слово, то дальше до ;  вернет true или false
				 {
			       if (jj==3)
					 {
						 String Data = sc.next();
						  list3.get(ii).add(Data);
						  String ra= list3.get(ii).get(0);// для будущего сравнения
						   if (ii>0) // подумать обязателдьно
						 {
							 out.println(ra);
						 }
			                jj++;
							ii++;
							jj=0;
						 list3.add(new ArrayList<String>());
					 }
					 else{
					 
					 String Data = sc.next();//Считываем по словам 
					 
					 list3.get(ii).add(Data);//записывает слова из файла в наш list
					 jj++;
					 }
				 }
		 }
		 }
		 catch(IOException ex){//Если файл не открылся
             
            System.out.println(ex.getMessage());//Сообщение об ошибке
        } 
		out.close();
		list3.remove(list3.size()-1);
		ArrayList<Integer> list4 = new ArrayList<Integer>();
		FileReader reader1 = new FileReader("C:\\Users\\user\\Downloads\\test9.txt");
	  Scanner sc3= new Scanner(new File ("C:\\Users\\user\\Downloads\\test9.txt"));
		int ca=0;
	  while((ca=reader1.read())!=-1)
	  {
	  				 if (sc3.hasNext())
					 {
						 int datafail = sc3.nextInt();
						 list4.add(datafail);
						 
					 }
	  }
	  System.out.println("Enter Id");
	 Scanner sc4 = new Scanner(System.in);//Сканер можно использовать не только для ввода из файла, но и для простого ввода с клавиатуры
	   String Id1;
	   Id1 = sc4.nextLine();
	  
        int i5 = Integer.valueOf(Id1);
	  int schet=0;
	  int nomer=0;
	  for (int in=0; in<list4.size(); in++)
	  {
           if (i5==list4.get(in))
		   {
			   nomer=in;
			   schet++;
			   
		   }
	  }
		   if (schet==1)
		   {
		   System.out.println("Enter number you want to add");
		   Scanner scsc= new Scanner(System.in);
        String num;
         num= scsc.nextLine();	
		 int inter = Integer.valueOf(num);
		  ArrayList<Integer> listint = new ArrayList<Integer>();
		  FileReader reader4 = new FileReader("C:\\Users\\user\\Downloads\\test10.txt"); 
          Scanner scinteger= new Scanner( new File ("C:\\Users\\user\\Downloads\\test10.txt"));
		   int car=0;
	  while((car=reader4.read())!=-1)
	  {
	  				 if (scinteger.hasNext())
					 {
						 int datafail = scinteger.nextInt();
						 listint.add(datafail);
						 
					 }
	  }
	  String strstr= Integer.toString(listint.get(nomer)+inter);
	  list3.get(nomer+1).set(3, strstr);
		   
	  }
	  else {
		  System.out.println("This Id is not existed. Lets add new product");
		  list3.add(new ArrayList<String>());
		  list3.get(list3.size()-1).add(Id1+' ');
		  int mal1=list3.size()-1;
		  System.out.println("Enter name");
		   Scanner sc5 = new Scanner(System.in);//Сканер можно использовать не только для ввода из файла, но и для простого ввода с клавиатуры
	   String name1;
	    name1 = sc5.nextLine();
		  list3.get(list3.size()-1).add(name1+' ');
		  System.out.println("Enter price");
		   Scanner sc6 = new Scanner(System.in);//Сканер можно использовать не только для ввода из файла, но и для простого ввода с клавиатуры
	   String price1;
	    price1 = sc6.nextLine();
	   list3.get(list3.size()-1).add(price1+' ');
	    System.out.println("Enter number");
		   Scanner sc7 = new Scanner(System.in);//Сканер можно использовать не только для ввода из файла, но и для простого ввода с клавиатуры
	   String number1;
	    number1 = sc7.nextLine();
		 list3.get(list3.size()-1).add(number1);
	   }	
		int mal= list3.size(); //количество строк в двумерном массиве
		for (int k=0; k<mal; k++) //строчки
		{
		for (int n=0; n<4; n++)//столбцы
			{
			System.out.print(list3.get(k).get(n));
			}
			System.out.println();
		}
		File filefile = new File("C:\\Users\\user\\Downloads\\test.txt");
	  PrintWriter outlist = new PrintWriter(filefile.getAbsoluteFile());
	  for (int al=0; al<list3.size(); al++)
	  {
		  for (int bal=0; bal<4; bal++)
		  {
			  outlist.print(list3.get(al).get(bal)+';'+' ');
		  }
	  }
	  outlist.close();
	   
          File filefiles = new File("C:\\Users\\user\\Downloads\\test10.txt");
	  PrintWriter outlists = new PrintWriter(filefiles.getAbsoluteFile());
	  for (int al=1; al<list3.size(); al++)
	  {
		  
			  outlists.println(list3.get(al).get(3));
		  
	  }
	  outlists.close();
}	//выводы файл
   break;
case '3':
 {
	
File filesold= new File("C:\\Users\\user\\Downloads\\test3.txt");
if(!filesold.exists()){
            System.out.println("No data for solds");
        }
		else{
ArrayList<ArrayList<String>> list7 = new ArrayList<ArrayList<String>>();

  FileReader reader0 = new FileReader("C:\\Users\\user\\Downloads\\test3.txt");// выделяется память и указываем путь к файлу
           Scanner scar= new Scanner( filesold); 
		scar.useDelimiter(";");
		list7.add(new ArrayList<String>());
		int chet=0;
		int ie=0;
		int je=0;
		while((chet=reader0.read())!=-1)
		 {
			 if (scar.hasNext())//hasNext - если есть следующее слово, то дальше до ;  вернет true или false
				 {
					if (je==3)
					{
						String dataf = scar.next();
						 list7.get(ie).add(dataf);
						 list7.add(new ArrayList<String>());
						 je=0;
						 ie++;
					}
					else{ 
					String dataf = scar.next();
						 list7.get(ie).add(dataf);
					 je++;
						
					}
						
					 }
				 
		}
		
		list7.remove(list7.size()-1);
		for (int it=0; it<list7.size(); it++)
		{
			for (int jae=0; jae<4; jae++)
			{
				System.out.print(list7.get(it).get(jae));
			}
			System.out.println();
		}
		File file04 = new File("C:\\Users\\user\\Downloads\\test3.txt");
		 PrintWriter out04 = new PrintWriter(file04.getAbsoluteFile());
 	
  for (int irac=0; irac<list7.size(); irac++)
  {
	   out04.print(list7.get(irac).get(2)+' ');
	    out04.print(list7.get(irac).get(3));
		out04.println();
	  
	 
  }
  out04.close();
  File file05 = new File("C:\\Users\\user\\Downloads\\test3.txt");
  ArrayList<Integer> list04 = new ArrayList<Integer>();
  ArrayList<Integer> list05 = new ArrayList<Integer>();
  FileReader reader04 = new FileReader("C:\\Users\\user\\Downloads\\test3.txt");// выделяется память и указываем путь к файлу
           Scanner scar04= new Scanner(file05); 
		   int chet1=0;
		   int i04=0;
		   int j04=0;
		   while((chet1=reader04.read())!=-1)
		 {
			 if (scar04.hasNext())//hasNext - если есть следующее слово, то дальше до ;  вернет true или false
				 {
						int dataf = scar04.nextInt();
						 list04.add(dataf);
						 int dataf1 = scar04.nextInt();
						 list05.add(dataf1);
					}
					}
					System.out.println("Solds Data");
					System.out.print("Id");
					System.out.print("     ");
					System.out.println("Price of sold");
		for (int ir=0; ir<list04.size(); ir++)
		{
			System.out.print(ir);
			System.out.print("     ");
			System.out.print(list04.get(ir)*list05.get(ir));
			System.out.println();
		}
		System.out.println("Enter Id of solds");
		   Scanner scsc1= new Scanner(System.in);
        String num1;
         num1= scsc1.nextLine();	
		 int value = Integer.valueOf(num1);
		 if (value<list04.size())
		 {
			 System.out.println("Full Information about product");
			 System.out.print("Id of product");  System.out.print("    ");
			 System.out.print("Name");   System.out.print("    ");
			 System.out.print("Price");  System.out.print("    ");
			  System.out.print("Number");   System.out.println();
			  for (int ist=0; ist<4; ist++)
			  {
				  System.out.print(list7.get(value).get(ist)); System.out.print("  ");
			  }
			 System.out.println();
		 }
		 else{
		     System.out.println("No id of solds");
		 }
		 File file09 = new File("C:\\Users\\user\\Downloads\\test3.txt");
		 PrintWriter out05 = new PrintWriter(file09.getAbsoluteFile());
 	
  for (int irac=0; irac<list7.size(); irac++)
  {
	  for (int jac=0; jac<4; jac++)
	  {
	   out05.print(list7.get(irac).get(jac)+';');
	  }
		out05.println();
	  
	 
  }
  out05.close();
		
 
 }
 }
   }
 
    }
}
}
