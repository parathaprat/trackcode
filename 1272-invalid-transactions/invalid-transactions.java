class Solution {

    class Transaction{

        String name;
        int time;
        int amount;
        String city;

        Transaction(String line){

            String[] details = line.split(",");

            this.name = details[0];
            this.time = Integer.parseInt(details[1]);
            this.amount = Integer.parseInt(details[2]);
            this.city = details[3];

        }
    }

    //map(name -> transactions)

    public List<String> invalidTransactions(String[] transactions) {

        List<String> invalid = new ArrayList<>();
        Map<String, List<Transaction>> map = new HashMap<>();

        for(String transaction : transactions){

            Transaction t = new Transaction(transaction);

            map.putIfAbsent(t.name, new ArrayList<>());
            map.get(t.name).add(t);

        }

        for(String transaction : transactions){

            Transaction t = new Transaction(transaction);

            if(!isValid(t, map)) invalid.add(transaction);
        }

        return invalid;
    }

    private boolean isValid(Transaction t, Map<String, List<Transaction>> map){

        if(t.amount > 1000) return false;

        for(Transaction tp : map.get(t.name)){

            if(Math.abs(tp.time - t.time) <= 60 && !t.city.equals(tp.city)) return false;
        }

        return true;
    }
}