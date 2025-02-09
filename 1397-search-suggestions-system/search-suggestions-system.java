class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        //result array
        List<List<String>> result = new ArrayList<>();

        if(products.length == 0) return result;

        //handles lexicographic portion
        Arrays.sort(products);

        int left = 0;
        int right = products.length - 1;

        //loop through chars of searchWord and check through product array

        for(int i = 0; i < searchWord.length(); i++){

            //temp ans list 
            List<String> ans = new ArrayList<>();

            //the char that we are looking for
            char search = searchWord.charAt(i);

            //while length of product at left and right pointers in lesser than current it || chars are not hte same, increment pointers
            while(left <= right && (products[left].length() <= i || products[left].charAt(i) != search)){
                left++;
            }

            while(left <= right && (products[right].length() <= i || products[right].charAt(i) != search)){
                right--;
            } 

            if(right - left + 1 >= 3){
                ans.add(products[left]);
                ans.add(products[left + 1]);
                ans.add(products[left + 2]);
            }
            else if(right - left + 1 == 2){
                ans.add(products[left]);
                ans.add(products[left + 1]);
            }
            else if(right - left + 1 == 1){
                ans.add(products[left]);
            }

            result.add(ans);
        }

        return result;

    }
}