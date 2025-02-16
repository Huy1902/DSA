package Lec14.seam_carving;/* *****************************************************************************
 *  Compilation:  javac-algs4 ShowSeams.java
 *  Execution:    java-algs4 ShowSeams input.png
 *  Dependencies: SeamCarver.java SCUtility.java
 *                
 *  Read image from file specified as command-line argument. Show 3 images 
 *  original image as well as horizontal and vertical seams of that image.
 *
 *  % java-algs4 ShowSeams HJoceanSmall.png
 *
 **************************************************************************** */

import edu.princeton.cs.algs4.Picture;
import edu.princeton.cs.algs4.StdOut;

import java.util.Scanner;

public class ShowSeams {

    private static void showHorizontalSeam(SeamCarver sc) {
        Picture ep = SCUtility.toEnergyPicture(sc);
        int[] horizontalSeam = sc.findHorizontalSeam();
        Picture epOverlay = SCUtility.seamOverlay(ep, true, horizontalSeam);
        epOverlay.show();
    }

    private static void showVerticalSeam(SeamCarver sc) {
        Picture ep = SCUtility.toEnergyPicture(sc);
        int[] verticalSeam = sc.findVerticalSeam();
        Picture epOverlay = SCUtility.seamOverlay(ep, false, verticalSeam);
        epOverlay.show();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Picture picture = new Picture(scanner.nextLine());
        StdOut.printf("%d-by-%d image\n", picture.width(), picture.height());
        picture.show();        
        SeamCarver sc = new SeamCarver(picture);
        
        StdOut.printf("Displaying horizontal seam calculated.\n");
        showHorizontalSeam(sc);

        StdOut.printf("Displaying vertical seam calculated.\n");
        showVerticalSeam(sc);

    }

}
