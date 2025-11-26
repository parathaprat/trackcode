class Solution {
    public int nextBeautifulNumber(int n) {

        List<Integer> list = new LinkedList<>();

        generate(0, list, new int[10]);

        Collections.sort(list);

        for(int num : list){
            if(num > n) return num;
        }

        return -1;
    }

    private void generate(long num, List<Integer> list, int[] count){

        if(num > 0 && isBeautiful(count)){
            list.add((int)num);
        }

        if(num > 1224444) return;

        for(int d = 1; d <= 7; d++){

            if(count[d] < d){
                count[d]++;
                generate(num * 10 + d, list,count);
                count[d]--;
            }
        }
    }

    private boolean isBeautiful(int[] count){

        for(int d = 1; d <= 7; d++){
            if(count[d] != 0 && count[d] != d) return false;
        }

        return true;
    }
}