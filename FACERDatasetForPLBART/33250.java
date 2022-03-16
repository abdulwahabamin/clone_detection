    private Runnable testCityListRowUtilityButtonsRunnable(final ListView cityListView) {
        return new Runnable() {

            @Override
            public void run() {
                int cityListViewItemCount = cityListView.getChildCount();
                if (cityListViewItemCount > 0) {
                    View listRowView = cityListView.getChildAt(cityListView
                            .getFirstVisiblePosition());
                    ArrayList<View> utilityButtons = listRowView
                            .getFocusables(View.FOCUS_FORWARD);
                    assertEquals(
                            "City list row should contain two views (utility buttons)",
                            2, utilityButtons.size());

                    testUtilityButtons(utilityButtons);
                }
            }

            private void testUtilityButtons(ArrayList<View> utilityButtons) {
                final View decorView = cityManagementActivity.getWindow()
                        .getDecorView();

                Button deleteButton = (Button) utilityButtons.get(0);
                assertNotNull("Delete button is null", deleteButton);
                ViewAsserts.assertOnScreen(decorView, deleteButton);

                Button renameButton = (Button) utilityButtons.get(1);
                assertNotNull("Rename city button is null", renameButton);
                ViewAsserts.assertOnScreen(decorView, renameButton);
            }

        };
    }

