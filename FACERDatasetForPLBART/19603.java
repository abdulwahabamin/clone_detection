        @Override
        public boolean onPreferenceClick(Preference preference) {
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:c.aniruddh98@gmail.com"));
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "ACEMusic Support");

            startActivity(Intent.createChooser(emailIntent, "ACEMusic Support"));

            return false;
        }

