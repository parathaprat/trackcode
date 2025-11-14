class Solution {

    class Transaction{

        String name;
        int time;
        int amount;
        String city;

        public Transaction(String line){

            String[] split = line.split(",");
            name = split[0];
            time = Integer.parseInt(split[1]);
            amount = Integer.parseInt(split[2]);
            city = split[3];

        }
    }

    public List<String> invalidTransactions(String[] transactions) {

        List<String> invalid = new ArrayList<>();
        Map<String, List<Transaction>> map = new HashMap<>();

        //1st pass: populate transaction map
        for(String transaction : transactions){

            Transaction t = new Transaction(transaction);
            map.putIfAbsent(t.name, new ArrayList<>());
            map.get(t.name).add(t);
            
        }

        //2nd pass: check validity for each name
        for(String transaction : transactions){

            Transaction t = new Transaction(transaction);
            
            if(!isValid(t, map.getOrDefault(t.name, new ArrayList<>()))){
                invalid.add(transaction);
            }
        }

        return invalid;
    }

    //is transaction > 100 || if neighors are elow 60 mins and in diff citys, return false;
    private boolean isValid(Transaction t, List<Transaction> list){

        if(t.amount > 1000) return false;

        for(Transaction ta : list){

            if(Math.abs(ta.time - t.time) <= 60 && !ta.city.equals(t.city)) return false;
        }

        return true;
    }
}