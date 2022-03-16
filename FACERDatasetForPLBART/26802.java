        public ViewHolder(View view) {
            super(view);
            this.view = view;
            this.time = (TextView) view.findViewById(R.id.date);
            this.temperature = (TextView) view.findViewById(R.id.temperature);
            this.wind = (TextView) view.findViewById(R.id.wind);
            this.humidity = (TextView) view.findViewById(R.id.humidity);
            this.pressure = (TextView) view.findViewById(R.id.pressure);
            this.weatherState = (SimpleDraweeView) view.findViewById(R.id.weather_state);
        }

