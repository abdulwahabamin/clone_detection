    private int getMaxTemperature(ArrayList<Integer> topTemp) {
        int max=topTemp.get(0);
        for(int i=0;i<topTemp.size()-1;i++){
                if(max<topTemp.get(i+1)){
                    max=topTemp.get(i+1);
                }
        }
        return max;
    }

