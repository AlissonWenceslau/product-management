package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Product> list = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for(int i=0;i<n;i++) {
			System.out.println("Product #"+ i+1 + " data: ");
			System.out.print("Common, used or imported (c/u/i)? ");
			char choose = sc.next().charAt(0);
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			
			//Capturing choose of user
			if(choose == 'c') {
				list.add(new Product(name, price));
			}else if(choose == 'u') {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date data = sdf.parse(sc.next());
				list.add(new UsedProduct(name, price, data));
			}else{
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				list.add(new ImportedProduct(name, price, customsFee));
			}
		}
		
		System.out.println();
		System.out.println("PRICE TAGS:");
		for(Product p : list) {
			System.out.println(p.priceTag());
		}
		sc.close();

	}

}
