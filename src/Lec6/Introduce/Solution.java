package Lec6.Introduce;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

  /*
   * Complete the 'introTutorial' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER V
   *  2. INTEGER_ARRAY arr
   */

  public static int introTutorial(int V, List<Integer> arr) {
    // Write your code here
    int l = 0;
    int r = arr.size();
    while(l <= r) {
      int m = l + (r - l) / 2;
      if(arr.get(m) == V) {
        return m;
      }
      if(arr.get(m) < V) {
        l = m + 1;
        continue;
      }
      if(arr.get(m) > V) {
        r = m - 1;
      }
    }
    return 0;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int V = Integer.parseInt(bufferedReader.readLine().trim());

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

    int result = Result.introTutorial(V, arr);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
