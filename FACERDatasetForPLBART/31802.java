        @Override
        public LocationHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(org.thosp.yourlocalweather.LocationsActivity.this);
            View v = inflater.inflate(R.layout.city_item, parent, false);
            return new LocationHolder(v);
        }

