package week06_greedy.necessary;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class P17451_ParallelUniverse {

    public static int n;
    public static int[] planets;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        planets = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            planets[i] = Integer.parseInt(st.nextToken());
        }

        long earthVelocity = getEarthVelocity();

        System.out.println(earthVelocity);

        br.close();
    }

    private static long getEarthVelocity() {
        long minSpeed = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (planets[i] > minSpeed) {
                minSpeed = planets[i];
            }
            else {
                long div = minSpeed / planets[i];
                if (minSpeed % planets[i] != 0)
                    div++;
                minSpeed = planets[i] * div;
            }
        }

        return minSpeed;
    }
}
