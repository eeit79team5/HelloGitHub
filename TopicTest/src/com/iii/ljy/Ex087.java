package com.iii.ljy;

public class Ex087 {
	Ex087() {
	}
	Ex087(int age, String name, String no) {		
	}
	
	public class person {
		
		public person() {
			System.out.println("hihiglen");
		}

		public person(int age, String name, String no) {
			this.age = age;
			this.name = name;
			this.no = no;
		}

		private int age;
		private String name;
		private String no;

		public int getAge() {
			return age;
		}

		public String getName() {
			return name;
		}

		public String getNo() {
			return no;
		}
	}

	public static void main(String[] args) {
		Ex087 pr1 = new Ex087();
		System.out.println(pr1);
		System.out.println(pr1.person(11, "glen2", "9527"));
		// person person1= new person();
		// Person person2= new Person(11,"glhf","9527");
		// System.out.println("Person1:"+person1.getName());
		// System.out.println("Person2:"+person2.getName());
		System.out.println("pr1:" + pr1);
	}
	private char[] person(int i, String string, String string2) {
		// TODO Auto-generated method stub
		return null;
	}
}
// ans:lab05.ex087$person@7f4ec
// ans:pr1:lab05.ex087@c791b9