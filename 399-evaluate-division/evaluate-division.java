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
                HashSet<String> visit = new HashSet<>();
                double[] ans = {-1.0};
                double temp = 1.0;

                dfs(dividend, divisor, temp, gr, visit, ans);

                finalAns[i] = ans[0];
            }
        }

        return finalAns;
    }

    private void dfs(String node, String dest, double temp, HashMap<String, HashMap<String, Double>> gr, HashSet<String> visit, double[] ans){

        if(visit.contains(node)) return;

        if(node.equals(dest)) ans[0] = temp;

        visit.add(node);

        for(Map.Entry<String, Double> entry : gr.get(node).entrySet()){

            String ne = entry.getKey();
            Double val = entry.getValue();

            dfs(ne, dest, temp * val, gr, visit, ans);
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