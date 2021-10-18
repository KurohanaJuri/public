public class TreasureFinder {

    private final LocationService ls;

    // There MUST be a parameterless constructor,
    // it is used by our Super-Fancy-Framework-That-Does-Not-Support-Parameters™
    public TreasureFinder() {
        this.ls = new GeolocatorService();
    }

    public TreasureFinder(LocationService gs) {
        this.ls = gs;
    }

    public String getHint(Position treasurePos) {

        Position userPosition;
        try {
            userPosition = ls.getUserPosition();
        } catch (Exception e) {
            return "The treasure is on Saturn!";
        }

        if (userPosition.latitude > 70) {
            return "Nope, the treasure is not at the North Pole.";
        }

        // Not accurate because of the Earth's curvature. Better calculation coming next sprint!
        double diff = Math.sqrt(Math.pow(treasurePos.latitude - userPosition.latitude, 2) + Math.pow(treasurePos.longitude - userPosition.longitude, 2));

        if (diff < 0.005) {
            return "You're right there!";
        }

        if (diff < 0.05) {
            return "Close...";
        }

        if (diff < 0.5) {
            return "Not too far.";
        }

        return "Far away.";
    }
}
