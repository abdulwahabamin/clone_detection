        @Override
        public boolean onPreferenceClick(Preference preference) {

            Uri webpage = Uri.parse("https://github.com/psaravan/JamsMusicPlayer");
            Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
            {
                startActivity(intent);
                return false;
            }

        }

