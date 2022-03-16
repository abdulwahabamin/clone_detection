        @Override
        public void onClick(View v) {
            v.setBackgroundColor(Color.rgb(227, 227, 227));
            setCity(mCity);
            sendBroadcast(new Intent(Constants.ACTION_FORCED_APPWIDGET_UPDATE));
            setResult(RESULT_OK);
            finish();
        }

