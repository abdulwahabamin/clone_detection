        public void onClick(View v) {
            int numweeks = mWeeks.getCurrentSelectedPos() + 1;
            MusicUtils.setIntPref(WeekSelector.this, "numweeks", numweeks);
            setResult(RESULT_OK);
            finish();
        }

