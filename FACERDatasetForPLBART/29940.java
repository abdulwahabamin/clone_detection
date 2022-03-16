        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.weather_daily_list_item, parent, false);

            return new MyViewHolder(itemView);
        }

