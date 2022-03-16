        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            switch (position) {
                case 0: numberOfDays = 3; hoursForecast = false; break;
                case 1: numberOfDays = 4; hoursForecast = false; break;
                case 2: numberOfDays = 5; hoursForecast = false; break;
                case 3: numberOfDays = 3; hoursForecast = true; break;
                case 4: numberOfDays = 4; hoursForecast = true; break;
                case 5: numberOfDays = 5; hoursForecast = true; break;
            }
        }

