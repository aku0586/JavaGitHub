package test_pac;

public class test_In {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i;
		
		i=999999999;
		
		System.out.println(i);
		
		String st_test= "             1111111111   ";
		String st_test1 = "          1111111111      "+ st_test;
		String st_test2 = "          1111111111      "+ st_test1;
		String st_test3 = "         1111111111      "+ st_test2;
		String st_test4 = "        1111111111        "+ st_test3;
		
		System.out.println(st_test4);
			String a = "first";
		for (int i1=1; i1<1000; i1++){
		
			
			a = a + i1;
			
			System.out.println(i1+"번째" + a);
			
			
		}
		
	}

}
