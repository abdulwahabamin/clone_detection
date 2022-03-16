    private void performDone() {
        if (selectedCity == null) {
            cityTextViewGenerator.getCityFromText(true);
            if (selectedCity == null) {
                Toast.makeText(getBaseContext(), "Please choose a location", Toast.LENGTH_SHORT).show();
                return;
            }
        }

        launchHomeScreen();
    }

