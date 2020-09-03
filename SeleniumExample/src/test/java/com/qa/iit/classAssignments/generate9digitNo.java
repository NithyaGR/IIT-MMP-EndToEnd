package com.qa.iit.classAssignments;

import java.util.Calendar;

public class generate9digitNo {

	public static void main(String[] args) {
		String ssnValue = Calendar.getInstance().getTimeInMillis()%1000000000+"";
		System.out.println(ssnValue); //54708017

	}

}
