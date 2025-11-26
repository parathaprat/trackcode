class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        //dividend -> divisor, value
        //divisor -> dividend, 1/value

        HashMap<String, HashMap<String, Double>> gr = buildGraph(equations, values);

        double[] finalAns = new double[queries.size()];

        for(int i = 0; i < queries.size(); i++){

            String dividend = queries.get(i).get(0);
            String divisor = queries.get(i).get(1);

            if(!gr.containsKey(dividend) || !gr.containsKey(divisor)) finalAns[i] = -1.0;
            else{
                
               double[] ans = {-1.0};
               double temp = 1.0;
               HashSet<String> visit = new HashSet<>();

               dfs(dividend, divisor, ans, temp, visit, gr);
               finalAns[i] = ans[0];
            }
        }

        return finalAns;
    }

    private void dfs(String node, String dest, double[] ans, double temp, HashSet<String> visit, HashMap<String, HashMap<String, Double>> gr){

        if(visit.contains(node)) return;

        if(node.equals(dest)) ans[0] = temp;
        visit.add(node);

        for(Map.Entry<String, Double> e : gr.get(node).entrySet()){
            
            String nei = e.getKey();
            Double val = e.getValue();

            dfs(nei, dest, ans, temp * val, visit, gr);
        }
    }

    private HashMap<String, HashMap<String, Double>> buildGraph(List<List<String>> equations, double[] values){

        HashMap<String, HashMap<String, Double>> gr = new HashMap<>();

        for(int i = 0; i < equations.size(); i++){

            String dividend = equations.get(i).get(0);
            String divisor = equations.get(i).get(1);

            gr.putIfAbsent(dividend, new HashMap<>());
            gr.putIfAbsent(divisor, new HashMap<>());

            gr.get(dividend).put(divisor, values[i]);
            gr.get(divisor).put(dividend, 1 / values[i]);
        }

        return gr;
    }
}