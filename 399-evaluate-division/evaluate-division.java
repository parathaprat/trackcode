class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        //dividend -> divisor, values
        //divisor -> dividend, 1/va;

        HashMap<String, HashMap<String, Double>> gr = buildGraph(equations, values);
        double[] finalAns = new double[queries.size()];

        for(int i = 0; i < queries.size(); i++){

            String dividend = queries.get(i).get(0);
            String divisor = queries.get(i).get(1);

            if(!gr.containsKey(dividend) || !gr.containsKey(divisor)) finalAns[i] = -1.0;
            else{

                Set<String> visit = new HashSet<>();
                double[] ans = {-1.0};
                double temp = 1.0;

                dfs(dividend, divisor, visit, ans, temp, gr);
                finalAns[i] = ans[0];
            }
        }

        return finalAns;
    }

    private void dfs(String node, String dest, Set<String> visit, double[] ans, double temp, HashMap<String, HashMap<String, Double>> gr){

        if(visit.contains(node)) return;
        if(node.equals(dest)) ans[0] = temp;

        visit.add(node);

        for(Map.Entry<String, Double> entry : gr.get(node).entrySet()){

            String nei = entry.getKey();
            Double val = entry.getValue();

            dfs(nei, dest, visit, ans, temp * val, gr);

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
            gr.get(divisor).put(dividend, 1.0 / values[i]);

        }

        return gr;
    }
}