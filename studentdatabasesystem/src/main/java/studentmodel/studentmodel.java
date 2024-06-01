package studentmodel;

public class studentmodel {
	
		private String Rollno;
		private String Name;
		private String Email;
		private String Branch;
		public String getRollno() {
			return Rollno;
		}
		public void setRollno(String Rollno) {
			Rollno = Rollno;
		}
		public String getName() {
			return Name;
		}
		public void setName(String Name) {
			this.Name = Name;
		}
		public String getEmail() {
			return Email;
		}
		public void setEmail(String Email) {
			this.Email = Email;
		}
		public String getBranch() {
			return Branch;
		}
		public void setBranch(String Branch) {
			this.Branch = Branch;
		}
		public studentmodel(String Rollno, String name, String email, String branch) {
			super();
			Rollno= Rollno;
			this.Name = name;
			this.Email = email;
			this.Branch = branch;
		}
		public studentmodel() {
			super();
			// TODO Auto-generated constructor stub
		}
		

	}


