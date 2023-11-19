import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.io.File;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.util.List;


public class Main {

    private static final int[] COLLECTION_SIZES = {10, 100, 1000, 10000, 100000};
    private static final double OPERATION_PERCENTAGE = 0.1;
    private static final Random RANDOM = new Random();
    private static List<Integer> scores_array_add = new ArrayList<>();
    private static List<Integer> scores_array_remove = new ArrayList<>();
    private static List<Integer> scores_array_total_add = new ArrayList<>();
    private static List<Integer> scores_array_total_remove = new ArrayList<>();

    private static List<Integer> scores_linked_add = new ArrayList<>();
    private static List<Integer> scores_linked_remove = new ArrayList<>();
    private static List<Integer> scores_linked_total_add = new ArrayList<>();
    private static List<Integer> scores_linked_total_remove = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        System.out.println("Start program");
        for (int collectionSize : COLLECTION_SIZES) {

            System.out.println("ArrayList " + collectionSize);
            testCollectionArray(new ArrayList<>(), collectionSize);

            System.out.println("LinkedList " + collectionSize);
            testCollectionLinked(new LinkedList<>(), collectionSize);
        }

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {



                Collections.reverse(scores_array_add);
                Collections.reverse(scores_linked_add);


                DrawGraph add_array_Panel = new DrawGraph(scores_array_add);
                DrawGraph add_linked_Panel = new DrawGraph(scores_linked_add);

                add_array_Panel.setPreferredSize(new Dimension(800, 600));
                add_linked_Panel.setPreferredSize(new Dimension(800, 600));
                JFrame frame = new JFrame("Среднее время добавления элемнта ArrayList и LinkedList");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(add_array_Panel, BorderLayout.NORTH);
                frame.add(add_linked_Panel, BorderLayout.CENTER);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                Collections.reverse(scores_array_remove);
                Collections.reverse(scores_linked_remove);
                DrawGraph remove_array_Panel = new DrawGraph(scores_array_remove);
                DrawGraph remove_linked_Panel = new DrawGraph(scores_linked_remove);

                remove_array_Panel.setPreferredSize(new Dimension(800, 600));
                remove_linked_Panel.setPreferredSize(new Dimension(800, 600));
                JFrame frame2 = new JFrame("Среднее время удаления элемнта ArrayList и LinkedList");
                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame2.add(remove_array_Panel, BorderLayout.NORTH);
                frame2.add(remove_linked_Panel, BorderLayout.CENTER);
                frame2.pack();
                frame2.setLocationRelativeTo(null);
                frame2.setVisible(true);

                Collections.reverse(scores_array_total_add);
                Collections.reverse(scores_linked_total_add);
                DrawGraph add_array_total_Panel = new DrawGraph(scores_array_total_add);
                DrawGraph add_linked_total_Panel = new DrawGraph(scores_linked_total_add);

                add_array_total_Panel.setPreferredSize(new Dimension(800, 600));
                add_linked_total_Panel.setPreferredSize(new Dimension(800, 600));
                JFrame frame3 = new JFrame("Общее время добавления элемнта ArrayList и LinkedList");
                frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame3.add(add_array_total_Panel, BorderLayout.NORTH);
                frame3.add(add_linked_total_Panel, BorderLayout.CENTER);
                frame3.pack();
                frame3.setLocationRelativeTo(null);
                frame3.setVisible(true);

                Collections.reverse(scores_array_total_remove);
                Collections.reverse(scores_linked_total_remove);
                DrawGraph remove_array_total_Panel = new DrawGraph(scores_array_total_remove);
                DrawGraph remove_linked_total_Panel = new DrawGraph(scores_linked_total_remove);

                remove_array_total_Panel.setPreferredSize(new Dimension(800, 600));
                remove_linked_total_Panel.setPreferredSize(new Dimension(800, 600));
                JFrame frame4 = new JFrame("Общее время удаления элемнта ArrayList и LinkedList");
                frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame4.add(remove_array_total_Panel, BorderLayout.NORTH);
                frame4.add(remove_linked_total_Panel, BorderLayout.CENTER);
                frame4.pack();
                frame4.setLocationRelativeTo(null);
                frame4.setVisible(true);
            }
        });

        System.out.println("End program");

    }

    public static void testCollectionLinked(LinkedList<WashingMachine> collection, int collectionSize){
        long totalAddTime = 0;
        long totalRemoveTime = 0;
        long totalSetTime = 0;
        long startTime_1 = System.nanoTime();

        String fname = "LinkedList" + collectionSize + ".log";
        File f = new File(fname);
        Logging log = new Logging(true,fname);

        if(f.exists() && !f.isDirectory()) {
            f.delete();
        }

        log.write(getTime());
        for (int index = 0; index < collectionSize; index++){

            long startTime = System.nanoTime();

            ColoredLaundry coloredLaundry = generateRandomLaundry();
            WashingMachine washingMachine = new WashingMachine();
            washingMachine.Load(coloredLaundry, "Universal", "Средство для цветного белья");
            collection.add(washingMachine);

            long endTime = System.nanoTime();
            long addTime = endTime - startTime;
            totalAddTime += addTime;

            log.write("add, ID = " + index + ", " + addTime);
        }
        for (int i = 0; i < collectionSize * OPERATION_PERCENTAGE; i++) {


            int randomIndex = RANDOM.nextInt(collectionSize);

            long startTime = System.nanoTime();


            collection.remove(randomIndex);

            long endTime = System.nanoTime();
            long removeTime = endTime - startTime;
            totalRemoveTime += removeTime;


            collectionSize--;
            log.write("remove, ID = " + randomIndex + ", " + removeTime);
        }

        for (int i = 0; i < collectionSize * OPERATION_PERCENTAGE; i++) {
            int randomIndex = RANDOM.nextInt(collectionSize);
            long startTime = System.nanoTime();

            WashingMachine washingMachine = collection.get(randomIndex);

            washingMachine.Load(generateRandomLaundry(), "New Detergent", "New Conditioner");

            long endTime = System.nanoTime();
            long setTime = endTime - startTime;
            totalSetTime += setTime;

            log.write("set, ID = " + randomIndex + ", " + setTime);
        }

        log.write( "addTotalCount = " + collectionSize);
        log.write( "addTotalTime = " + totalAddTime);
        log.write( "addMedianTime = " + (totalAddTime / collectionSize));

        scores_linked_add.add((int) (totalAddTime/ collectionSize));
        scores_linked_total_add.add((int) totalAddTime);

        log.write( "removeTotalCount = " + (collectionSize * OPERATION_PERCENTAGE));
        log.write( "removeTotalTime = " + totalRemoveTime);
        log.write( "removeMedianTime = " + (totalRemoveTime / (collectionSize * OPERATION_PERCENTAGE)));

        scores_linked_remove.add((int) (totalRemoveTime / (collectionSize * OPERATION_PERCENTAGE)));
        scores_linked_total_remove.add((int) totalRemoveTime);

        log.write( "setTotalCount = " + (collectionSize * OPERATION_PERCENTAGE));
        log.write( "setTotalTime = " + totalSetTime);
        log.write( "setMedianTime = " + (totalSetTime / (collectionSize * OPERATION_PERCENTAGE)));

        long endTime = System.nanoTime();
        long setTime = endTime - startTime_1;
        log.write("Totaltime = " + setTime);
    }

    public static void testCollectionArray(ArrayList<WashingMachine> collection, int collectionSize) {
        long totalAddTime = 0;
        long totalRemoveTime = 0;
        long totalSetTime = 0;



        long startTime_1 = System.nanoTime();

        String fname = "ArrayList" + collectionSize + ".log";
        File f = new File(fname);
        Logging log = new Logging(true,fname);

        if(f.exists() && !f.isDirectory()) {
            f.delete();
        }

        log.write(getTime());

        for (int index = 0; index < collectionSize; index++) {
            long startTime = System.nanoTime();

            ColoredLaundry coloredLaundry = generateRandomLaundry();
            WashingMachine washingMachine = new WashingMachine();
            washingMachine.Load(coloredLaundry, "Universal", "Средство для цветного белья");
            collection.add(washingMachine);

            long endTime = System.nanoTime();
            long addTime = endTime - startTime;
            totalAddTime += addTime;

            log.write("add, ID = " + index + ", " + addTime);
        }

        for (int i = 0; i < collectionSize * OPERATION_PERCENTAGE; i++) {
            int randomIndex = RANDOM.nextInt(collectionSize);
            long startTime = System.nanoTime();

            collection.remove(randomIndex);

            long endTime = System.nanoTime();
            long removeTime = endTime - startTime;
            totalRemoveTime += removeTime;

            collectionSize--;

            log.write("remove, ID = " + randomIndex + ", " + removeTime);
        }

        for (int i = 0; i < collectionSize * OPERATION_PERCENTAGE; i++) {
            int randomIndex = RANDOM.nextInt(collectionSize);
            long startTime = System.nanoTime();

            WashingMachine washingMachine = collection.get(randomIndex);

            washingMachine.Load(generateRandomLaundry(), "New Detergent", "New Conditioner");

            long endTime = System.nanoTime();
            long setTime = endTime - startTime;
            totalSetTime += setTime;

            log.write("set, ID = " + randomIndex + ", " + setTime);
        }

        log.write( "addTotalCount = " + collectionSize);
        log.write( "addTotalTime = " + totalAddTime);
        log.write( "addMedianTime = " + (totalAddTime / collectionSize));

        scores_array_total_add.add((int) totalAddTime);
        scores_array_add.add((int) (totalAddTime / collectionSize));

        log.write( "removeTotalCount = " + (collectionSize * OPERATION_PERCENTAGE));
        log.write( "removeTotalTime = " + totalRemoveTime);
        log.write( "removeMedianTime = " + (totalRemoveTime / (collectionSize * OPERATION_PERCENTAGE)));

        scores_array_total_remove.add((int) totalRemoveTime);
        scores_array_remove.add((int) (totalRemoveTime / (collectionSize * OPERATION_PERCENTAGE)));

        log.write( "setTotalCount = " + (collectionSize * OPERATION_PERCENTAGE));
        log.write( "setTotalTime = " + totalSetTime);
        log.write( "setMedianTime = " + (totalSetTime / (collectionSize * OPERATION_PERCENTAGE)));

        long endTime = System.nanoTime();
        long setTime = endTime - startTime_1;
        log.write("Totaltime = " + setTime);
    }

    static String getTime() {
        LocalTime time = LocalTime.now();
        LocalDate day = LocalDate.now();
        String s = String.format("%02d:%02d:%4d ",day.getDayOfMonth(),day.getMonthValue(),day.getYear());
        s += String.format("%02d:%02d:%02d ",time.getHour(),time.getMinute(),time.getSecond());
        return s;
    }
    private static ColoredLaundry generateRandomLaundry() {
        int washingTemperature = RANDOM.nextInt(100) + 1;
        int ironingTemperature = RANDOM.nextInt(200) + 1;
        int colorTypeIndex = RANDOM.nextInt(ColorType.values().length);
        ColorType colorType = ColorType.values()[colorTypeIndex];
        return new ColoredLaundry(washingTemperature, ironingTemperature, colorType);
    }

}