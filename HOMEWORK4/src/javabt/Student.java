package javabt;
class Student {
    int studentID;
    String fullName;
    String gender;
    double pythonScore;
    double javaScore;
    double averageScore;
    String result;


	 public Student(int studentID, String fullName, String gender, double pythonScore, double javaScore) {
	        this.studentID = studentID;
	        this.fullName = fullName;
	        this.gender = gender;
	        this.pythonScore = pythonScore;
	        this.javaScore = javaScore;
	        this.averageScore = (javaScore * 2 + pythonScore) / 3;
	        this.result = calculateResult();
	    }

	    private String calculateResult() {
	        if (averageScore >= 5) {
	            return "Pass";
	        } else if (gender.equals("Nam")) {
	            return "Fail";
	        } else {
	            return "Pass";
	        }
	    }

	    @Override
	    public String toString() {
	        return "Ma sinh vien: " + studentID +
	                ", Ho va Ten: " + fullName +
	                ", Gioi tinh: " + gender +
	                ", Diem python: " + pythonScore +
	                ",Diem Java: " + javaScore +
	                ", Diem trung binh: " + averageScore +
	                ", ket qua: " + result;
	    }
	}

