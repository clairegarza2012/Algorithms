
public class Hashing {

	public static int hash(String str){
		int hash = 0;
		
		char[] arr = str.toCharArray();
		
		for (int i = 0; i < arr.length; i++){
			hash += Math.pow(10, i) * arr[i];
		}
		
		return hash;
	}
	
	public static void main(String[] args){
	
		System.out.println(hash("josh"));
		System.out.println(hash("darrius"));
		System.out.println(hash("daniel"));
		System.out.println(hash("claire"));
		System.out.println(hash("brian"));
		System.out.println(hash("yi"));
		System.out.println(hash("brittany"));
		System.out.println(hash("anthony"));
		System.out.println(hash("ansel"));
		System.out.println(hash("bastien"));
		System.out.println(hash("tyler"));

	}
	
}
