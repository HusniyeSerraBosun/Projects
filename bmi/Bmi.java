package bmi;
import java.util.*;
public class Bmi {
	private String name;
	private int age;
	private double weight;
	private double height;
	
	public static final double POUND = 2.20462;
	public static final double INCH = 0.393701;
	
	public Bmi() {
		name= "John Black";
		age=25;
		weight=100;
		height=50;
	}
	public Bmi(String nameBmi,double weightBmi,double heightBmi) {
		name= nameBmi;
		age=20;
		weight=weightBmi;
		height=heightBmi;
	}
	public Bmi(String nameBmi,int ageBmi, double weightBmi,double heightBmi) {
		name=nameBmi;
		age=ageBmi;
		weight=weightBmi;
		height=heightBmi;
	}
	public String getName() {
		return name;
	}
	public void setName(String newName) {
		name=newName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int newAge) {
		age=newAge;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double newWeight) {
		weight=newWeight;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double newHeight) {
		height=newHeight;
	}
	public double getBMI() {
		double pounds=weight*POUND;
		double inches=height*INCH;
		double BMI=pounds*703/(inches*inches);
		return BMI;
	}
	public String getStatus() {
		double pounds=weight*POUND;
		double inches=height*INCH;
		double BMI=pounds*703/(inches*inches);
		String status=" ";
		
		if(BMI<18.5) {
			status="underweight";
		}else if(BMI<25) {
			status="normal";
		}else if(BMI<30) {
			status="overweight";
		}else if(BMI>=30) {
			status="obese";
		}
		return status;
	}
}
