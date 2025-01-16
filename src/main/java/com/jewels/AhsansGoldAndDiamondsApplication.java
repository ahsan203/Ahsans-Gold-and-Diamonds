package com.jewels;

import com.jewels.entities.Gold;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AhsansGoldAndDiamondsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AhsansGoldAndDiamondsApplication.class, args);
	}

	CommandLineRunner startPoint()
	{
		return (args)->{

			Gold gold1 = new Gold();
			gold1.setProductId(123);

			System.out.println(gold1);
	};
	}

}
