package Lec14.seam_carving;/* ******************************************************************************
 *  Compilation:  javac-algs4 SCUtility.java
 *  Execution:    none
 *  Dependencies: SeamCarver.java
 *
 *  Some utility functions for testing SeamCarver.java.
 *
 **************************************************************************** */

import java.awt.Color;

import edu.princeton.cs.algs4.Picture;
import edu.princeton.cs.algs4.StdRandom;

public class SCUtility {

    // create random width-by-height picture
    public static Picture randomPicture(int width, int height) {
        Picture picture = new Picture(width, height);
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                int r = StdRandom.uniform(256);
                int g = StdRandom.uniform(256);
                int b = StdRandom.uniform(256);
                Color color = new Color(r, g, b);
                picture.set(col, row, color);
            }
        }
        return picture;
    }

    // convert SeamCarver picture to width-by-height energy matrix
    public static double[][] toEnergyMatrix(SeamCarver sc) {
        double[][] a = new double[sc.width()][sc.height()];
        for (int col = 0; col < sc.width(); col++)
            for (int row = 0; row < sc.height(); row++)
                a[col][row] = sc.energy(col, row);
        return a;        
    }

    // displays grayscale values as energy (converts to picture, calls show)
    public static void showEnergy(SeamCarver sc) {
        doubleToPicture(toEnergyMatrix(sc)).show();
    }

    // returns picture of energy matrix associated with SeamCarver picture
    public static Picture toEnergyPicture(SeamCarver sc) {
        double[][] energyMatrix = toEnergyMatrix(sc);
        return doubleToPicture(energyMatrix);
    }

    // converts a double matrix of values into a normalized picture
    // values are normalized by the maximum grayscale value
    public static Picture doubleToPicture(double[][] grayValues) {

        // each 1D array in the matrix represents a single column, so number
        // of 1D arrays is the width, and length of each array is the height
        int width = grayValues.length;
        int height = grayValues[0].length;

        Picture picture = new Picture(width, height);

        double maxVal = 0;
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                if (grayValues[col][row] > maxVal) {
                    maxVal = grayValues[col][row];
                }
            }
        }
            
        // return a black picture
        if (maxVal == 0) {
            return picture;
        }

        // normalize grayscale values
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                float normalized = (float) (grayValues[col][row] / (float) maxVal);
                Color gray = new Color(normalized, normalized, normalized);
                picture.set(col, row, gray);
            }
        }

        return picture;
    }


    // This method is useful for debugging seams. It overlays red
    // pixels over the calculate seam.
    public static Picture seamOverlay(Picture picture, boolean isHorizontal, int[] seam) {
        Picture overlaid = new Picture(picture);
        
        // if horizontal seam, set one pixel in every column
        if (isHorizontal) {
            for (int col = 0; col < picture.width(); col++)
                overlaid.set(col, seam[col], Color.RED);
        }

        // if vertical seam, set one pixel in each row
        else {
            for (int row = 0; row < picture.height(); row++)
                overlaid.set(seam[row], row, Color.RED);
        }

        return overlaid;
    }

}
