    private void processNewEmission(long elapsedTime) {
        if (elapsedTime < emissionDuration) {
            if (lastEmittedTimestamp == 0) {
                lastEmittedTimestamp = elapsedTime;
            } else {
                final long timeSinceLastEmission = elapsedTime - lastEmittedTimestamp;

                // Randomly determine how many confetti to emit
                final int numNewConfetti = (int)
                        (random.nextFloat() * emissionRate * timeSinceLastEmission);
                if (numNewConfetti > 0) {
                    lastEmittedTimestamp += emissionRateInverse * numNewConfetti;
                    addNewConfetti(numNewConfetti, elapsedTime);
                }
            }
        }
    }

