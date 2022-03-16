        @Override
        public boolean onPreferenceClick(Preference preference) {
            Uri webpage = Uri.parse("http://c-aniruddh.us.to");
            Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
            {
                startActivity(intent);
                return false;
            }
        }

