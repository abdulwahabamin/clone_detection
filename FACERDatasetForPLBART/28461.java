    private void configureConfetto(Confetto confetto, ConfettiSource confettiSource,
                                   Random random, long initialDelay) {
        confetto.reset();

        confetto.setInitialDelay(initialDelay);
        confetto.setInitialX(confettiSource.getInitialX(random.nextFloat()));
        confetto.setInitialY(confettiSource.getInitialY(random.nextFloat()));
        confetto.setInitialVelocityX(getVarianceAmount(velocityX, velocityDeviationX, random));
        confetto.setInitialVelocityY(getVarianceAmount(velocityY, velocityDeviationY, random));
        confetto.setAccelerationX(getVarianceAmount(accelerationX, accelerationDeviationX, random));
        confetto.setAccelerationY(getVarianceAmount(accelerationY, accelerationDeviationY, random));
        confetto.setTargetVelocityX(targetVelocityX == null ? null
                : getVarianceAmount(targetVelocityX, targetVelocityXDeviation, random));
        confetto.setTargetVelocityY(targetVelocityY == null ? null
                : getVarianceAmount(targetVelocityY, targetVelocityYDeviation, random));
        confetto.setInitialRotation(
                getVarianceAmount(initialRotation, initialRotationDeviation, random));
        confetto.setInitialRotationalVelocity(
                getVarianceAmount(rotationalVelocity, rotationalVelocityDeviation, random));
        confetto.setRotationalAcceleration(
                getVarianceAmount(rotationalAcceleration, rotationalAccelerationDeviation, random));
        confetto.setTargetRotationalVelocity(targetRotationalVelocity == null ? null
                : getVarianceAmount(targetRotationalVelocity, targetRotationalVelocityDeviation,
                random));
        confetto.setTTL(ttl);
        confetto.setFadeOut(fadeOutInterpolator);

        confetto.prepare(bound);
    }

