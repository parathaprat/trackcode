class Solution {

    //create a transaction class for easy access
    //1st pass transactions to populate map (name -> list transaction)
    //2nd pass to check validity, adding to ans list

    class Transaction{

        String name;
        int time;
        int amount;
        String city;

        Transaction(String line){

            String[] split = line.split(",");
            name = split[0];
            time = Integer.parseInt(split[1]);
            amount = Integer.parseInt(split[2]);
            city = split[3];

        }
    }

    public List<String> invalidTransactions(String[] transactions) {

        List<String> res = new ArrayList<>();
        HashMap<String, List<Transaction>> map = new HashMap<>();

        for(String transaction : transactions){

            Transaction t = new Transaction(transaction);

            map.putIfAbsent(t.name, new ArrayList<>());
            map.get(t.name).add(t);

        }

        for(String transaction : transactions){

            Transaction t = new Transaction(transaction);

            if(!isValid(t, map)) res.add(transaction);
        }

        return res;
    }

    private boolean isValid(Transaction t, Map<String, List<Transaction>> map){

        if(t.amount > 1000) return false;

        for(Transaction ta : map.get(t.name)){
            
            if(Math.abs(ta.time - t.time) <= 60 && !ta.city.equals(t.city)) return false;

        }

        return true;
    }
}