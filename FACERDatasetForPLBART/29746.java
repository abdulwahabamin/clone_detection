  private void dragScale(int scroll) {
    if (scroll == 0) return;

    totalDrag += scroll;

    // track the direction & set the pivot point for scaling
    // don't double track i.e. if start dragging down and then reverse, keep tracking as
    // dragging down until they reach the 'natural' position
    if (scroll < 0 && !draggingUp && !draggingDown) {
      draggingDown = true;
      if (shouldScale) setPivotY(getHeight());
    } else if (scroll > 0 && !draggingDown && !draggingUp) {
      draggingUp = true;
      if (shouldScale) setPivotY(0f);
    }
    // how far have we dragged relative to the distance to perform a dismiss
    // (0–1 where 1 = dismiss distance). Decreasing logarithmically as we approach the limit
    float dragFraction = (float) Math.log10(1 + (Math.abs(totalDrag) / dragDismissDistance));

    // calculate the desired translation given the drag fraction
    float dragTo = dragFraction * dragDismissDistance * dragElacticity;

    if (draggingUp) {
      // as we use the absolute magnitude when calculating the drag fraction, need to
      // re-apply the drag direction
      dragTo *= -1;
    }
    setTranslationY(dragTo);

    if (shouldScale) {
      final float scale = 1 - ((1 - dragDismissScale) * dragFraction);
      setScaleX(scale);
      setScaleY(scale);
    }

    // if we've reversed direction and gone past the settle point then clear the flags to
    // allow the list to get the scroll events & reset any transforms
    if ((draggingDown && totalDrag >= 0)
        || (draggingUp && totalDrag <= 0)) {
      totalDrag = dragTo = dragFraction = 0;
      draggingDown = draggingUp = false;
      setTranslationY(0f);
      setScaleX(1f);
      setScaleY(1f);
    }
    dispatchDragCallback(dragFraction, dragTo,
        Math.min(1f, Math.abs(totalDrag) / dragDismissDistance), totalDrag);
  }

