        @Override
        public boolean onPreferenceClick(Preference preference) {

            Uri webpage = Uri.parse("https://raw.githubusercontent.com/C-Aniruddh/ACE/master/LICENSE.md");
            Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
            {
                startActivity(intent);
                return false;
            }

        }

