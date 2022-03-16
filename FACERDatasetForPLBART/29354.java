    /**
     * 使当�?线程�?�眠制定的毫秒数
     * @param time
     * 指定当�?线程�?�眠多久，以毫秒为�?��?
     */
    private void sleep(int time){
        try{
            Thread.sleep(time);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

