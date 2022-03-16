    private int getMinTemperature(ArrayList<Integer> lowTemp){
        int min=lowTemp.get(0);
        for(int i=0;i<lowTemp.size()-1;i++){
            if(min>lowTemp.get(i+1)){
                min=lowTemp.get(i+1);
            }
        }
        return min;
    }

