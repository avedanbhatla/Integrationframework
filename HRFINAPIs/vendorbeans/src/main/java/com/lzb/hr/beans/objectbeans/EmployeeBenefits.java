package com.lzb.hr.beans.objectbeans;

import java.util.Map;


public  class EmployeeBenefits {

		private int empNo;
		private String medicalBen;
		private String dentalBen;
		private String visionBen;
		
	
		public EmployeeBenefits(int empNo, String medicalBen, String dentalBen, String visionBen) {
			super();
			this.empNo = empNo;
			this.medicalBen = medicalBen;
			this.dentalBen = dentalBen;
			this.visionBen = visionBen;
		}


		public EmployeeBenefits(){
			
		}

		
		public int getId() {
			return empNo;
		}
		public void setId(int empNo) {
			this.empNo = empNo;
		}

		public int getEmpNo() {
			return empNo;
		}


		public void setEmpNo(int empNo) {
			this.empNo = empNo;
		}


		public String getMedicalBen() {
			return medicalBen;
		}


		public void setMedicalBen(String medicalBen) {
			this.medicalBen = medicalBen;
		}


		public String getDentalBen() {
			return dentalBen;
		}


		public void setDentalBen(String dentalBen) {
			this.dentalBen = dentalBen;
		}


		public String getVisionBen() {
			return visionBen;
		}


		public void setVisionBen(String visionBen) {
			this.visionBen = visionBen;
		}


		@Override
		public String toString() {
			return "Employee [empNo=" + empNo + ", medicalBen=" + medicalBen + ", dentalBen=" + dentalBen
					+ ", visionBen=" + visionBen + "]";
		}
		
		
		
		
		
}

