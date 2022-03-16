        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.ab_settings:
                    mDrawerLayout.closeDrawer(Gravity.START);
                    openSettings();
                    break;
                case R.id.ab_clear_history:
                    clearHistory();
                    mClearHistory.setVisibility(View.GONE);
                    break;
                default:
                    break;
            }
        }

