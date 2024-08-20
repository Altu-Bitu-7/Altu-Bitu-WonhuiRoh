package week01_sorting_map_set.challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class Employee {
    int documentRank, interviewRank;

    public Employee(int documentRank, int interviewRank) {
        this.documentRank = documentRank;
        this.interviewRank = interviewRank;
    }
}

public class P1946_NewEmployee {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T;
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N;
            N = Integer.parseInt(br.readLine());

            Employee[] employees = new Employee[N];

            for (int i = 0; i < N; i++) {
                String[] ranks = br.readLine().split(" ");
                int documentRank = Integer.parseInt(ranks[0]);
                int interviewRank = Integer.parseInt(ranks[1]);

                employees[i] = new Employee(documentRank, interviewRank);
            }

            Arrays.sort(employees, Comparator.comparingInt(o -> o.documentRank));

            int cnt = 1;    // 서류 순위 1등 => 무조건 합격
            int highestRank = employees[0].interviewRank;
            for (int i = 1; i < N; i++) {   // 서류 순위 2등부터 시작
                if (employees[i].interviewRank < highestRank) { // 인터뷰 순위가 더 선순위인 경우
                    cnt++;
                    highestRank = employees[i].interviewRank;
                }
            }

            System.out.println(cnt);
        }
    }
}
