public class FindSubString {

	/**
	* @param args
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Count Sub-String Algorithm");
		String value = "ABCDCDCFGHFDSCDCUHJCDCDCUYH";
		String sub_value = "CDC"; 
		
		char[] full_string = value.toCharArray();
		char[] sub_string = sub_value.toCharArray();
		
		FindSubString solution = new FindSubString();
		int result = solution.count_substring(full_string, sub_string);

		System.out.println("Sub-String times is = "+result);

	}
	
	int count_substring(char[] full_string, char[] sub_string) {
		int size = sub_string.length;
		int result = 0;
		for (int i =0; i< (full_string.length - (size-1)); i++) {
			int count = 0;
			if(full_string[i] == sub_string[0]){
				count += 1;
				int x = i + 1;
				for (int j=0; j<size; j++){
					if(full_string[x] == sub_string[j]) {
						count += 1;
						x+=1;
					}
				}
				if(count == size) {
					result +=1;
				}
			}
		}
		return result;
	}
}
