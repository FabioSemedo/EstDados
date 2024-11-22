class Foo{
	
public static void main(String[] args){
	Boo temp = new Boo("Fabio", 20);
	System.out.println(temp.name + " "+ temp.age);

  }
}

class Boo{
	String name;
	int age;
	Boo(String s, int a){
	 this.name = s; this.age = a;
	}
}