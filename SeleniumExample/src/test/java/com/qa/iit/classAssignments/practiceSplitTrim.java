package com.qa.iit.classAssignments;

public class practiceSplitTrim {
	
	public static void main(String[] args) {
		
		String str = "Symptom: Booking an Appointment with Dr.Charlie on date::2/6/2020 for symptom fever";
		
		String[] strArray = str.split(":", 2);
		System.out.println(strArray.length);
		for (String string : strArray) {
			System.out.println(string);
		}
		for (int i=0;i<strArray.length; i++){
			System.out.println(strArray[i]);
		}
		
		
	}

}
