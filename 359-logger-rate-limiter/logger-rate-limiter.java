class Logger {

    //Queue -> timestamp, message
    //set -> Active 10s message set

    class Log{

        int timestamp;
        String message;

        Log(int timestamp, String message){
            this.timestamp = timestamp;
            this.message = message;
        }
    }

    Queue<Log> q;
    Set<String> set;

    public Logger() {
        q = new LinkedList<>();
        set = new HashSet<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        
        if(!q.isEmpty() && timestamp - q.peek().timestamp >= 10){
            set.remove(q.peek().message);
            q.poll();
        }

        if(set.contains(message)) return false;

        set.add(message);
        q.add(new Log(timestamp, message));
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */