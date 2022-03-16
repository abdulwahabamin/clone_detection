    public Cal(String date) {
        //2007-11-17 17:40:29
        super();
        //System.out.println("generating date for: "+date);
        if(date!=null) {
        String[] sp1 = date.split(" ");
        String[] sp2 = sp1[0].split("-");
        String[] sp3 = sp1[1].split(":");
        int month = Integer.parseInt(sp2[1]);
       
        this.set(Integer.parseInt(sp2[0]),--month, Integer.parseInt(sp2[2])
            , Integer.parseInt(sp3[0]), Integer.parseInt(sp3[1]));
        }
    }

