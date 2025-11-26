class UndergroundSystem {

    class Passenger{

        String checkInLoc;
        String checkOutLoc;
        int checkInTime;
        int checkOutTime;

        Passenger(String checkInLoc, int checkInTime){
            this.checkInLoc = checkInLoc;
            this.checkInTime = checkInTime;
        }

        void checkout(String checkOutLoc, int checkOutTime){
            this.checkOutLoc = checkOutLoc;
            this.checkOutTime = checkOutTime;
        }
    }

    class Route{
        String startStation;
        String endStation;
        int totalNoTrip;
        long totalTripTime;

        Route(String startStation, String endStation){
            this.startStation = startStation;
            this.endStation = endStation;
        }

        void addTrip(int startTime, int endTime){
            totalTripTime += endTime - startTime;
            totalNoTrip++;
        }

        double getAvgTime(){
            return (double) totalTripTime / totalNoTrip;
        }
    }

    Map<Integer, Passenger> currentPassengerMap;
    Map<String, Route> routeMap;


    public UndergroundSystem() {
        currentPassengerMap = new HashMap<>();
        routeMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {

        if(!currentPassengerMap.containsKey(id)){
            Passenger passenger = new Passenger(stationName, t);
            currentPassengerMap.put(id, passenger);
        }
    }
    
    public void checkOut(int id, String stationName, int t) {

        if(currentPassengerMap.containsKey(id)){

            Passenger passenger = currentPassengerMap.get(id);
            passenger.checkout(stationName, t);
            currentPassengerMap.remove(id);

            String routeKey = passenger.checkInLoc + "," + passenger.checkOutLoc;
            routeMap.putIfAbsent(routeKey, new Route(passenger.checkInLoc, passenger.checkOutLoc));

            Route route = routeMap.get(routeKey);
            route.addTrip(passenger.checkInTime, passenger.checkOutTime);
        }
        
    }
    
    public double getAverageTime(String startStation, String endStation) {

        return routeMap.get(startStation + "," + endStation).getAvgTime();
        
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */