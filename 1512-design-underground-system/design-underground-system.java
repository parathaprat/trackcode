class UndergroundSystem {

    class Passenger{

        int checkInTime;
        int checkOutTime;
        String checkInLoc;
        String checkOutLoc;

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
        int totalNoTrips;
        long totalTimeTrips;

        Route(String startStation, String endStation){
            this.startStation = startStation;
            this.endStation = endStation;
        }

        double getAvgTime(){
            return (double) totalTimeTrips / totalNoTrips;
        }

        void addTrip(int startTime, int endTime){
            totalTimeTrips += endTime - startTime;
            totalNoTrips++;
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

            String routeKey = passenger.checkInLoc + "," + passenger.checkOutLoc;
            Route route = routeMap.getOrDefault(routeKey, new Route(passenger.checkInLoc, passenger.checkOutLoc));
            route.addTrip(passenger.checkInTime, passenger.checkOutTime);
            routeMap.put(routeKey, route);

            currentPassengerMap.remove(id);

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