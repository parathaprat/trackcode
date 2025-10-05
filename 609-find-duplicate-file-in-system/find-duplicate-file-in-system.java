class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        
        List<List<String>> al = new ArrayList<>();
        HashMap<String, List<String>> hashMap = new HashMap<>();

        for(String path : paths){

            String[] arr = path.split("\\ ");
            String dirPath = arr[0]; //directory path

            for(int i = 1; i < arr.length; i++){

                StringBuilder content = new StringBuilder();
                int j = 0;

                for(j = arr[i].length() - 2; j >= 0 && arr[i].charAt(j) != '('; j--){
                    content.insert(0, arr[i].charAt(j));
                } 

                String fileName = arr[i].substring(0, j);
                hashMap.putIfAbsent(content.toString(), new ArrayList<>());
                hashMap.get(content.toString()).add(dirPath + '/' + fileName);
            }
        }

        for(String string : hashMap.keySet()) {
            if(hashMap.get(string).size() >= 2){
                al.add(new ArrayList<>(hashMap.get(string)));
            }
        }

        return al;
    }
}