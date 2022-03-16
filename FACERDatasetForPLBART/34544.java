        public void swape(int origin,int target){
            Log.d("weather", "src : " + origin + "   tar : " + target) ;
            if (origin < target) {
                for (int i = origin; i < target; i++) {
                    Collections.swap(weatherDatas, i, i + 1);
                }
            }
            if (origin > target) {
                for (int i = origin; i > target; i--) {
                    int l1 = i ;
                    int l2 = i - 1;
                    Log.d("weather", " swap " + l1 + " and " + l2);
                    Collections.swap(weatherDatas, i, i - 1);
                }
            }
            notifyItemMoved(origin, target);
            List<MyCity> myCities = new ArrayList<>();
            for(int i = 0;i<weatherDatas.size();i++){
                Log.d("weather","city name : " + weatherDatas.get(i).city +" city id: " + weatherDatas.get(i).cityId + " index = " + i);
                myCities.add(new MyCity(weatherDatas.get(i).cityId,String.valueOf(i)));
            }
            MyApplication.getInstance().getWeatherService().reStoreMyCitiesIndex(myCities);
        }

