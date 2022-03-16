  /**
   * Show fragment with fragment manager with animation parameter
   *
   * @param fragment        instance of {@link Fragment}
   * @param fragmentManager instance of {@link FragmentManager}
   * @param withAnimation   boolean value
   */
  public static void showFragment(Fragment fragment, FragmentManager fragmentManager, boolean withAnimation) {
    FragmentTransaction transaction = fragmentManager.beginTransaction();
    if (withAnimation) {
      transaction.setCustomAnimations(R.anim.slide_up_anim, R.anim.slide_down_anim);
    } else {
      transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
    }
    transaction.add(android.R.id.content, fragment).addToBackStack(null).commit();
  }

