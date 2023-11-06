
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.logging.*;

public class Main {

    private static final int[] COLLECTION_SIZES = {10, 100};
    private static final double OPERATION_PERCENTAGE = 0.1;
    private static final Random RANDOM = new Random();

    private static Logger logger = Logger.getLogger(Main.class.getName());
    static FileHandler fh;

    public static void main(String[] args) throws IOException {

        Handler fileHandeler = new FileHandler();
        logger.addHandler(fileHandeler);

        logger.info("Start program: " + java.time.LocalDateTime.now());

        for (int collectionSize : COLLECTION_SIZES) {
            logger.log(Level.INFO, "ArrayList");
            testCollectionArray(new ArrayList<>(), collectionSize);
            logger.log(Level.INFO, "LinkedList");
            testCollectionLinked(new LinkedList<>(), collectionSize);

        }

        logger.info("Finish program: " + java.time.LocalDateTime.now());
    }

    public static void testCollectionLinked(LinkedList<WashingMachine> collection, int collectionSize){
        long totalAddTime = 0;
        long totalRemoveTime = 0;
        long totalSetTime = 0;

        for (int index = 0; index < collectionSize; index++){
            logger.info("add, ID = " + index + ", " + System.nanoTime());
            long startTime = System.nanoTime();

            ColoredLaundry coloredLaundry = generateRandomLaundry();
            WashingMachine washingMachine = new WashingMachine();
            washingMachine.Load(coloredLaundry, "Universal", "Средство для цветного белья");
            collection.add(washingMachine);

            long endTime = System.nanoTime();
            long addTime = endTime - startTime;
            totalAddTime += addTime;
        }
        for (int i = 0; i < collectionSize * OPERATION_PERCENTAGE; i++) {
            int randomIndex = RANDOM.nextInt(collectionSize);
            logger.info("remove, ID = " + randomIndex + ", " + System.nanoTime());
            long startTime = System.nanoTime();


            collection.remove(randomIndex);

            long endTime = System.nanoTime();
            long removeTime = endTime - startTime;
            totalRemoveTime += removeTime;

            collectionSize--;
        }

        for (int i = 0; i < collectionSize * OPERATION_PERCENTAGE; i++) {
            int randomIndex = RANDOM.nextInt(collectionSize);
            logger.info("set, ID = " + randomIndex + ", " + System.nanoTime());
            long startTime = System.nanoTime();

            WashingMachine washingMachine = collection.get(randomIndex);

            washingMachine.Load(generateRandomLaundry(), "New Detergent", "New Conditioner");

            long endTime = System.nanoTime();
            long setTime = endTime - startTime;
            totalSetTime += setTime;
        }

        logger.info( "addTotalCount = " + collectionSize);
        logger.info( "addTotalTime = " + totalAddTime);
        logger.info( "addMedianTime = " + (totalAddTime / collectionSize));

        logger.info( "removeTotalCount = " + (collectionSize * OPERATION_PERCENTAGE));
        logger.info( "removeTotalTime = " + totalRemoveTime);
        logger.info( "removeMedianTime = " + (totalRemoveTime / (collectionSize * OPERATION_PERCENTAGE)));

        logger.info( "setTotalCount = " + (collectionSize * OPERATION_PERCENTAGE));
        logger.info( "setTotalTime = " + totalSetTime);
        logger.info( "setMedianTime = " + (totalSetTime / (collectionSize * OPERATION_PERCENTAGE)));
    }

    public static void testCollectionArray(ArrayList<WashingMachine> collection, int collectionSize) {
        long totalAddTime = 0;
        long totalRemoveTime = 0;
        long totalSetTime = 0;

        for (int index = 0; index < collectionSize; index++) {
            logger.info("add, ID = " + index + ", " + System.nanoTime());
            long startTime = System.nanoTime();

            ColoredLaundry coloredLaundry = generateRandomLaundry();
            WashingMachine washingMachine = new WashingMachine();
            washingMachine.Load(coloredLaundry, "Universal", "Средство для цветного белья");
            collection.add(washingMachine);

            long endTime = System.nanoTime();
            long addTime = endTime - startTime;
            totalAddTime += addTime;
        }

        for (int i = 0; i < collectionSize * OPERATION_PERCENTAGE; i++) {
            int randomIndex = RANDOM.nextInt(collectionSize);
            logger.info("remove, ID = " + randomIndex + ", " + System.nanoTime());
            long startTime = System.nanoTime();


            collection.remove(randomIndex);

            long endTime = System.nanoTime();
            long removeTime = endTime - startTime;
            totalRemoveTime += removeTime;

            collectionSize--;
        }

        for (int i = 0; i < collectionSize * OPERATION_PERCENTAGE; i++) {
            int randomIndex = RANDOM.nextInt(collectionSize);
            logger.info("set, ID = " + randomIndex + ", " + System.nanoTime());
            long startTime = System.nanoTime();

            WashingMachine washingMachine = collection.get(randomIndex);

            washingMachine.Load(generateRandomLaundry(), "New Detergent", "New Conditioner");

            long endTime = System.nanoTime();
            long setTime = endTime - startTime;
            totalSetTime += setTime;
        }

        logger.info( "addTotalCount = " + collectionSize);
        logger.info( "addTotalTime = " + totalAddTime);
        logger.info( "addMedianTime = " + (totalAddTime / collectionSize));

        logger.info( "removeTotalCount = " + (collectionSize * OPERATION_PERCENTAGE));
        logger.info( "removeTotalTime = " + totalRemoveTime);
        logger.info( "removeMedianTime = " + (totalRemoveTime / (collectionSize * OPERATION_PERCENTAGE)));

        logger.info( "setTotalCount = " + (collectionSize * OPERATION_PERCENTAGE));
        logger.info( "setTotalTime = " + totalSetTime);
        logger.info( "setMedianTime = " + (totalSetTime / (collectionSize * OPERATION_PERCENTAGE)));
    }

    private static ColoredLaundry generateRandomLaundry() {
        int washingTemperature = RANDOM.nextInt(100) + 1;
        int ironingTemperature = RANDOM.nextInt(200) + 1;
        int colorTypeIndex = RANDOM.nextInt(ColorType.values().length);
        ColorType colorType = ColorType.values()[colorTypeIndex];
        return new ColoredLaundry(washingTemperature, ironingTemperature, colorType);
    }
}