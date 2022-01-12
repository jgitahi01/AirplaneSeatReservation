/* Name; John Gitahi
    SMU; 48116033
	Lab 4 Fall-2019
*/	

import java.util.Scanner;;//import scanner/ program utilizes class scanner

 class VolumeOfCone {

    public static double[] getVolumeArray(double[] radiusArray, double[] heightArray) {

        double[] VolumeArray = new double[5];

        // compute volume of each cone using pi*r^2*h/3

        for (int i = 0; i < 5; i++) {

            VolumeArray[i] = Math.PI * (radiusArray[i] * radiusArray[i]) * heightArray[i] / 3;

        }

        return VolumeArray;

    }
    //public class VolumeOfCone
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        double[] radiusArray = new double[5];

        double[] heightArray = new double[5];

        // read radius and height of 5 cones

        for (int i = 0; i < 5; i++) {

            System.out.print("Enter the radiusArray of cone " + (i + 1) + ": ");

            radiusArray[i] = sc.nextDouble();

            System.out.print("Enter the heightArray of cone " + (i + 1) + ": ");

            heightArray[i] = sc.nextDouble();

        }

        // compute volume

        double[] VolumeArray = getVolumeArray(radiusArray, heightArray);

        // print radius, height and volume of each cone rounded to 4 decimal places

        for (int i = 0; i < 5; i++)

            System.out.printf("The volume of cone %d with radius %.4f and height %.4f is: %.4f\n", i + 1,

                    radiusArray[i], heightArray[i], VolumeArray[i]);

    }

}