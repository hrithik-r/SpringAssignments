package com.nissan.app;

import com.nissan.service.ProfessorServiceImpl;

public class DemoProfessorApp {

	public static void main(String[] args) {
		// Call
		ProfessorServiceImpl proService = new ProfessorServiceImpl();
		proService.menuDriven();
		
	}

}
