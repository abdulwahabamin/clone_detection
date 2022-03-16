	public static void checkKeyboardHeight(final View parentLayout, final PopupWindow popupWindow,final LinearLayout emoticonsCover) {

		parentLayout.getViewTreeObserver().addOnGlobalLayoutListener(
				new ViewTreeObserver.OnGlobalLayoutListener() {

					@Override
					public void onGlobalLayout() {
						
						Rect r = new Rect();
						parentLayout.getWindowVisibleDisplayFrame(r);
						
						int screenHeight = parentLayout.getRootView()
								.getHeight();
						int heightDifference = screenHeight - (r.bottom);
						
						if (D.previousHeightDiffrence - heightDifference > 50) {							
							popupWindow.dismiss();
						}
						
						D.previousHeightDiffrence = heightDifference;
						if (heightDifference > 100) {

							D.isKeyBoardVisible = true;
							Device.changeKeyboardHeight(heightDifference, emoticonsCover);

						} else {

							D.isKeyBoardVisible = false;
							
						}

					}
				});

	}

