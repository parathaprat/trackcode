class Solution {

    class Transaction{

        String name;
        int time;
        int amount;
        String city;

        Transaction(String line){
            String[] tran = line.split(",");
            name = tran[0];
            time = Integer.parseInt(tran[1]);
            amount = Integer.parseInt(tran[2]);
            city = tran[3];
        }

    }
    public List<String> invalidTransactions(String[] transactions) {

        List<String> invalid = new ArrayList<>();
        //name -> transactions
        Map<String, List<Transaction>> map = new HashMap<>();

        //first pass -> populate map
        for(String transaction : transactions){

            Transaction t = new Transaction(transaction);

            map.putIfAbsent(t.name, new ArrayList<>());
            map.get(t.name).add(t);

        }

        //2nd pass -> check validity
        for(String transaction : transactions){

            Transaction t = new Transaction(transaction);

            if(!isValid(t, map.getOrDefault(t.name, new ArrayList<>()))){
                invalid.add(transaction);
            }
        }

        return invalid;
    }

    private boolean isValid(Transaction t, List<Transaction> list){

        if(t.amount > 1000) return false;

        for(Transaction ta : list){

            if(Math.abs(ta.time - t.time) <= 60 && !ta.city.equals(t.city)) return false;
        }

        return true;
    }
}