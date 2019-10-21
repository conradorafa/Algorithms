    /*
     * Complete the 'longestChain' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING_ARRAY words as parameter.
     */
	 
	 public class LongestChain{
	 
		public static int longestChain(List<String> words) {
			int result =0;
			if(words.isEmpty() || words == null) {
				return result;
			}
			Collections.sort(words);

			Map<String, Integer> mapWord = new HashMap<String, Integer>();
			for(String word: words) {
				if(mapWord.containsKey(word)) {
					continue;
				} else {
					mapWord.put(word,1);
					for (int i=0; i<word.length(); i++){
						StringBuilder sb = new StringBuilder(word);
						sb.deleteCharAt(i);
						String nextString = sb.toString();
						if(mapWord.containsKey(nextString) && mapWord.get(nextString)+1 > mapWord.get(word)) {
							mapWord.put(word, mapWord.get(nextString)+1);
						}

					}

				}
				if (mapWord.get(word) > result) {
					result = mapWord.get(word);
				}
			}
			return result;
		}
	 
	 
	}

