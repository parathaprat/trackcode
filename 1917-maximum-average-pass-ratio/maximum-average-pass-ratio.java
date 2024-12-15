class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        
        //map heap -> {gain, pass, total} sorted by decending order of gain
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        //this loop populates heap with all classes and potential gain when student is added
        for(int[] clas : classes){
            int pass = clas[0];
            int total = clas[1];

            double gain = calculateGain(pass, total);

            maxHeap.offer(new double[] {gain, pass, total});
        }

        //this loop adds each extra student to classes with max potenctial gain
        while(extraStudents-- > 0){

            double[] top = maxHeap.poll();
            double gain = top[0];
            int pass = (int)top[1];
            int total = (int)top[2];

            //adding 1 student to class with max gain potential
            pass++;
            total++;

            double newGain = calculateGain(pass, total);

            //adding class with new potential gain with student added to heap
            maxHeap.offer(new double[] {newGain, pass, total});
        }

        double totalPassRatio = 0.0;

        //this loop calculates total pass ratio; get each element from maxHeap and calculate
        while(!maxHeap.isEmpty()){

            double[] top = maxHeap.poll();

            //gain is calculated seperately since we are storing potencial gain if a student is added in heap
            int pass = (int)top[1];
            int total = (int)top[2];

            totalPassRatio += (double)pass/total;
        }

        return totalPassRatio/ classes.length;

    }

    //custom function to calculate potencial gain
    private double calculateGain(int pass, int total) {
        return ((double) (pass + 1) / (total + 1)) - ((double) pass / total);
    }
}