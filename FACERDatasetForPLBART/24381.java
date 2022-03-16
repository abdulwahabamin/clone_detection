        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            if (currentTransaction == null) {
                currentTransaction = fragmentManager.beginTransaction();
            }

            ActionBar.Tab tab = MusicBrowserActivity.this.getActionBar().getTabAt(position);

            Fragment fragment = fragmentManager.findFragmentByTag((String)tab.getTag());
            // Check if the fragment is already initialized
            if (fragment != null) {
                // If it exists, simply attach it in order to show it
                currentTransaction.attach(fragment);
            } else {
                // If not, instantiate and add it to the activity
                fragment = instantiateFragment(tab);
                currentTransaction.add(container.getId(), fragment, (String)tab.getTag());
            }
            return fragment;
        }

