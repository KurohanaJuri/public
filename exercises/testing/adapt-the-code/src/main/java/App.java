public final class App {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        TreasureFinder tf = new TreasureFinder();
        System.out.println(tf.getHint(new Position(46.516659, 6.5641015)));
    }

}
