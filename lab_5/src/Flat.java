import hierarchy.ElectricalAppliance;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * Main class for the task, represent electrical network in flat
 */
public class Flat {
    private ElectricalAppliance[] electricalAppliances;

    public Flat(ElectricalAppliance[] electricalAppliances) {
        this.electricalAppliances = electricalAppliances;
    }

    public ElectricalAppliance[] getElectricalAppliances() {
        return electricalAppliances;
    }

    /**
     * sorting array of appliances
     * @see Comparator
     */
    public void sortByPower(){
        Arrays.sort(electricalAppliances, Comparator.comparing(ElectricalAppliance::getPower));
    }

    /**
     * @param start of search range
     * @param end of search range
     * @return ElectricalAppliance array of items with .radiation within given range
     */
    public ElectricalAppliance[] getInRadiationRange(int start, int end){
        int count = 0;
        ElectricalAppliance[] result = new ElectricalAppliance[electricalAppliances.length];
        ElectricalAppliance[] resultCut;
        for (ElectricalAppliance appliance : electricalAppliances) {
            if(appliance.getRadiation() >= start & appliance.getRadiation() <= end){
                result[count++] = appliance;
            }
        }
        resultCut = new ElectricalAppliance[count];
        System.arraycopy(result, 0, resultCut, 0, resultCut.length);
        return resultCut;
    }

    /**
     * Turns on appliances in flat, writes warning if item index is out of bound for appliance array
     * @param numbers numbers of items to turn on array
     */
    public void turnOnItems(int[] numbers){
        for (int number : numbers) {
            if(number < electricalAppliances.length){
                electricalAppliances[number].turnOn();
            }else {
                System.err.println("Number "+ number + " is out of array range, it was skipped");
            }
        }
    }
    /**
     * @return sum of all .isPlugged appliances
     */
    public double getTotalConsumedPower(){
        double result = 0;
        for (ElectricalAppliance appliance : electricalAppliances) {
            if(appliance.isPlugged()){
                result += appliance.getPower();
            }
        }
        return result;
    }
}

